const range = document.getElementById("num-seats")
const bubble = document.getElementsByClassName("bubble")[0]
const cost_label = document.getElementById("total-ticket-cost")
const select_month = document.getElementById("month-exp")
const select_year = document.getElementById("year-exp")
const submit_btn = document.getElementById("submit-btn")

var price_per_ticket = -1;

// ******************************On Load********************************
window.onload = ()=>{
	let startStop = document.getElementById("bus-start-name");
	let endStop = document.getElementById("bus-stop-name");
	let busCode = document.getElementById("bus-code");
	
	$.ajax({
            url : `ticketprice?startStop=${startStop.innerText}&endStop=${endStop.innerText}&busCode=${busCode.innerText}`,          // url for request for booking
            type: "GET",
            success: function(response) {
                price_per_ticket = response;
                range.value = 1;
			    setBubble(range, bubble)
			    setPrice(range, cost_label)
            },
            error: function (error) {
                console.log(error)
                console.log("cost retriving error")
            }
        });
	
	//console.log(price_per_ticket);
	
    // set range bubble value

    for(let i=2021; i<=2140; i++){
        select_year.innerHTML +=  generate_option(i);
    }

    for(let i=1; i<=12; i++){
        select_month.innerHTML += generate_option(i);
    }

}

// ****************************Util Functions******************************
function setBubble(range, bubble) {
    // changes the position of hover bubble for number of seats range input
    const val = range.value;
    const min = range.min;
    const max = range.max;
    const newVal = Number(((val - min) * 100) / (max - min));
    bubble.innerHTML = val;

     bubble.style.left = `calc(${newVal}% + (${8 - newVal * 0.15}px))`;
}

function setPrice(range, cost_label){
    // sets price of the total cost of ticket section in the header
    cost_label.innerHTML = (range.value*price_per_ticket).toLocaleString('en-IN', {
        maximumFractionDigits: 2,
        style: 'currency',
        currency: 'INR'
    });
}

function generate_option(num){
    // generates options for select year and month
    return `<option value="${num}">${num}</option>`
}

function isValidExpDate(select_month, select_year){
    // validates  expiry date (only checks if input present; for now)
    if(select_month.value==="none" || select_year.value==="none")
        return false
    else
        return true
}

function createRequestObject(){
    //creates the js object that needs to be shared to server side for booking info
    var RequestObject = {}
    //const start_time = document.getElementById("bus-start-time")
    //const stop_time = document.getElementById("bus-stop-time")
    const bus_start_name = document.getElementById("bus-start-name")
    const bus_stop_name = document.getElementById("bus-stop-name")
    const bus_code = document.getElementById("bus-code")
    const bus_date = document.getElementById("bus-date")

    const email = document.getElementById("email")
    const num_seats = document.getElementById("num-seats")
    const card_num = document.getElementById("card-num")
    const card_holder_name = document.getElementById("card-holder-name")
    const card_cvv = document.getElementById("card-cvv")

    // RequestObject[start_time.id] = start_time.innerText
    // RequestObject[stop_time.id] = stop_time.innerText
    RequestObject["startStopName"] = bus_start_name.innerText
    RequestObject["endStopName"] = bus_stop_name.innerText
    RequestObject["busCode"] = bus_code.innerText
    RequestObject["busDate"] = bus_date.innerText


    const cost =  parseFloat(cost_label.innerHTML.substring(1).replace(/,/g,''))
    RequestObject["totalTicketCost"] = cost         // Golbal scoped

	RequestObject["email"] = email.value
	RequestObject["numSeats"] = parseInt(num_seats.value)
	RequestObject["cardNum"] = Number(card_num.value)
	RequestObject["cardHolderName"] = card_holder_name.value
	RequestObject["cardCvv"] = parseInt(card_cvv.value)

    RequestObject["monthExp"] = parseInt(select_month.value)         // Global scoped
    RequestObject["yearExp"] = parseInt(select_year.value)           // Global scoped

    return RequestObject


}

function getConfirmationPage(response){
	my_form=document.createElement('FORM')
	my_form.method='POST'
	my_form.action='confimation'
	for(var key in response){
		if(key === "dateofTrip" || key === "busCode" || key === "pnr" || key === "seatsBooked" ){
			console.log(key);
			my_tb=document.createElement('INPUT')
			my_tb.type='TEXT'
			my_tb.name=key
			my_tb.value=response[key]
			console.log(typeof my_tb.value)
			my_form.appendChild(my_tb)
		}
		
	}
	my_form.style.display = 'none'
	document.body.appendChild(my_form)
	my_form.submit()
}


// ************************** Event Listners **************************
range.addEventListener("input", () => {
    setBubble(range, bubble)
    setPrice(range, cost_label)
});

submit_btn.addEventListener("click", ()=>{
    let isValid = true
    const all_input = Array.from(document.getElementsByTagName("input"))
    const select_month = document.getElementById("month-exp")
    const select_year = document.getElementById("year-exp")

    all_input.forEach(element => {
        // console.log(element.value)
        const error_message = document.querySelector(`small[data-validator="${element.id}"]`)
        if(!element.value){
            error_message.classList.remove("hidden")
            isValid = false
        }
        else if(element.id === "email" && !/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(element.value)){
            error_message.classList.remove("hidden")
            isValid = false
        }
        else if(element.id === "card-cvv" && !/^[0-9]{3}$/.test(element.value)){
            error_message.classList.remove("hidden")
            isValid = false
        }
        else if(element.id === "card-num" && !/^[0-9]{16}$/.test(element.value)){
            error_message.classList.remove("hidden")
            isValid = false
        }
        else if(element.id !== "num-seats"){
            error_message.classList.add("hidden")
        }
    })

    
    if(!isValidExpDate(select_month, select_year)){
        document.querySelector(`small[data-validator="exp_date"]`).classList.remove("hidden")
        isValid = false
    }
    else{
        document.querySelector(`small[data-validator="exp_date"]`).classList.add("hidden")
    }

    if(isValid){
        var json_request = createRequestObject();
        //console.log(json_request)
        const loading_window = document.getElementsByClassName("loading-screen")[0]
        // console.log(loading_window)
        loading_window.classList.add("d-block")
        loading_window.classList.remove("d-none")
        loading_window.classList.remove("opacity-0")
        $.ajax({
            url : "dopayment",          // url for request for booking
            type: "POST",
            contentType:"application/json",
            data: JSON.stringify(json_request),
            // response of the form {msg: "message form server" , isbooked: true/false }
            success: function(response, status, xhr) {
                loading_window.classList.remove("d-block")
                loading_window.classList.add("d-none")
                var ct = xhr.getResponseHeader("content-type") || "";
                //console.log("sucess: ", status)
                //console.log("here", ct)
			    if (ct.indexOf('html') > -1) {
			      html = document.getElementsByTagName("html")[0]
			      html.innerHTML = response
			    }
			    else if (ct.indexOf('json') > -1) {
			      //result = JSON.parse(response)
			      toastr.error(response.msg, 'Booking failed')
			    }
			    else {
				  toastr.error("Unknown format of data recieved", 'Booking failed')
				}
                //console.log(response);
                    
            },
            error: function (error, status, xhr) {
				console.log("errro: ", status)
                loading_window.classList.remove("d-block")
                loading_window.classList.add("d-none")
                console.log(error)
                toastr.error("Request failed due to unexpected problem", "Error")
            }
        });
    }


})
