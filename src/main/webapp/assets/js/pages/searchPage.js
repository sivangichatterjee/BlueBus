
//Retrieve the travel details form 
const form = document.getElementById("source-dest-date-form");

//add function on submit
form.addEventListener("submit", async function (e) {
	//prevent default submit
    e.preventDefault();  
    
    const journeyDate = document.getElementById("date").value; // extracting
																// date in Date
																// format
    const selectedDate = journeyDate.split('-'); // converting date to string
													// by splitting using -

    const today = new Date; 
    // Retrieving source and destination dropdown
    var source = document.querySelector("#source");
    var destination = document.querySelector("#destination");
    const sourceVal = source.options[source.selectedIndex].text;
    const destVal = destination.options[destination.selectedIndex].text;
 // retrive bus list
    const buses = document.querySelectorAll(".bus")
    // Remove the previous buslist
    for(let bus of buses){
    	bus.remove()
    }
    var filterBoxes = document.querySelectorAll(".form-check-input")
    for(let eachCheck of filterBoxes){
    	eachCheck.checked = false;
    }
    // Check validation of date
    var isDateValid = 0
    
    if(selectedDate[0] > today.getFullYear()){ //future year
    	isDateValid =1
    }
    if (selectedDate[0] == today.getFullYear()){	//same year

    	if(selectedDate[1]> (today.getMonth() + 1)){ //same year but future month
    		isDateValid =1
    	}
    	if(selectedDate[1] == (today.getMonth() + 1)){ //same year same month 
    		if(selectedDate[2] > today.getDate())     //same year same month today or future date
    			isDateValid =1
    	}
    }
    if(isDateValid ==0){
    	showSnackbar("Please select a valid date")
        return;

    }

    else if(source.value=='-' && destination.value == '-'){
    	showSnackbar("Please select a source and destination")
    	return
    }else //check if any of the source or destination field is blank
        if(source.value=='-'){
        	showSnackbar("Please select a source")
        }
        
        else if(destination.value=='-'){
        	showSnackbar("Please select a destination")
        }
    // Check if source and destination are same
    else if (sourceVal == destVal) {
    	showSnackbar("Source and destination can not be same")
    }
    

    // All okay ready to send ajax call
    else{
    	console.log("Url of the current file is");
        let getUrl = window.location.href+"/getBusList?source="+sourceVal+"&destination="+destVal+"&traveldate="+journeyDate
        // Sending ajax request
        const res = await axios.get(getUrl);
        data = res.data;
        // render the buslist received from server
        await showBusList(data)
        //filter buses
        await filterBuses()
        // Send post request to payment page after user clicks on book now
        await bookBus(sourceVal,destVal,journeyDate);             
    }
   return "done"
})

//function for showing buslist
const showBusList = function (data){
	 // retrive container for buslist
    var searchResult = document.querySelector(".search-result")
    
    // retrive bus list
    const buses = document.querySelectorAll(".bus")
    // Remove the previous buslist
    for(let bus of buses){
    	//bus.style.display = "none";
    	bus.remove()
    }
    //remove previous messages ("no buses found")
   const newD=document.getElementsByTagName("H4")
   	
    for (let eachD of newD){
    	if(eachD!=undefined){
    	eachD.remove()}
    	}
   // handle the case when no buses found in the route
    if(data.length==0){   
	    var newDiv=document.createElement("H4")
		newDiv.classList.add("text-center","pt-5")
		newDiv.style.margin="180px"
		newDiv.style.color="GREY"
		newDiv.innerHTML="No Buses Found!<br> Please select another route."  
	    searchResult.append(newDiv)
    }
    else{
	for(let eachBus of data){
		
		//preparing start and end time
		var sTime = eachBus.startTime
		var sliceTime = sTime.slice(0,5)
		var dTime = eachBus.endTime.slice(0,5)
		// preparing list of features available in the bus
		features=[]
		if(eachBus.facilityAc){
			features.push("AC")
		}
		else{
			features.push("Non Ac")
		}	
		if(eachBus.facilityCharging){
			features.push("Charging Point")
		}
		if(eachBus.facilityPushBackSeat){
			features.push("Push Back Seat")
		}
		if(eachBus.facilityWater){
			features.push("Drinking Water")
		}

        // Create new div element for each bus
        var busTemplate = document.createElement("DIV");
        // Set class for each bus
        busTemplate.classList.add("bus", "my-3", "mx-4", "p-4");	
        // set new html to busTemplate
        busTemplate.innerHTML = `<div class="d-flex justify-content-between f-22">
        <div class="font-weight-bold">Bus Code :<span  class="bus_id font-weight-light" id = "bus_code">${eachBus.busCode}</span></div>
        <div class="font-weight-bold">Fare: <span id="bus_fare" class="bus_fare text-theme-primary"> ${eachBus.totalFare}/-</span></div>
      </div>

      <div class="d-flex justify-content-between f-18 mt-2">
        <div class="d-flex justify-content-between font-weight-medium">
          <div class="">Start Time: <span id="start-time" class="font-weight-light">${sliceTime} </span></div>
          <div class=" mx-4">End Time: <span id="end-time" class="font-weight-light"> ${dTime}</span></div>
        </div>
        <div class="font-weight-medium">Available Seats: <span id="available-seats" class="font-weight-light">
            ${eachBus.seatsRemain}</span></div>
      </div>
      <div class="d-flex justify-content-between mt-2">
        <div class="d-flex align-items-start mt-2  font-weight-medium featureList"  >

        </div>
        <button class=" button btn font-weight-bold f-22 px-3 py-2 rounded book-now" >Book Now</button>
      </div>`
      searchResult.append(busTemplate);
        //add features
        if(busTemplate.querySelector("#available-seats").innerText<=0){
    		busTemplate.querySelector(".button").disabled= true;
    	}
        let featureList = busTemplate.getElementsByClassName("featureList")[0]
        for(let feature of features){
        	var featureProperty = document.createElement("SPAN")
        	featureProperty.classList.add("features", "px-2", "mx-2")
        	featureProperty.innerHTML = feature
        	featureList.append(featureProperty)
        }

     }  
    }
}

//function for booking bus
const bookBus =   function (sourceVal,destVal,journeyDate) {
const buses = document.querySelectorAll('.bus');
for (let bus of buses){bus.querySelector(".button").addEventListener("click",function() {

 
 var busCode = bus.firstElementChild.firstElementChild.firstElementChild.textContent;
//preparing data for payment page
 const busData = { "busCode":busCode,
				  "startStopName":sourceVal,
				  "endStopName":destVal,
				  "dateOfDept":journeyDate
				}
 //preparing a dynnamic form
busDetailsForm = document.createElement("FORM")
busDetailsForm.setAttribute("id","bus-booking-form")
busDetailsForm.method='POST';
busDetailsForm.action='bookticket/payment';
//add fields to the form    
for(var key in busData)
     {
	     my_tb=document.createElement('INPUT');
		 my_tb.type='TEXT';
		 my_tb.name=key;
		 my_tb.value=busData[key];
		 busDetailsForm.appendChild(my_tb);
     }
     //add the form to dom and submit
     document.body.appendChild(busDetailsForm);
     busDetailsForm.submit();
     //remove the form from dom
     busDetailsForm.remove()
})}
}

const filterBuses = function(){
	
	document.getElementById("apply-filter").onclick = function(){
	let checkedBoxes= []
    let checkboxes = document.getElementsByClassName("form-check");
    for(let checkbox of checkboxes){
    	if(checkbox.querySelector(".form-check-input").checked){
    		checkedBoxes.push(checkbox.querySelector(".form-check-label").innerText)
    	}    
    }
    var busList = document.querySelectorAll(".bus")
    //display all previously hidden buses
    for(let bus of busList){
    	bus.style.display = "block"
    }
    //filter buses
    for(let bus of busList){	
    	var featureList = []
    	for(let eachFeature of bus.querySelectorAll(".features")){
    		featureList.push(eachFeature.innerText)
    	}
    	if(checkedBoxes.includes("AC") && checkedBoxes.includes("Non Ac")){
    		if(featureList.includes("AC")){
    			featureList.push("Non Ac")
    		}else{
    			featureList.push("AC")
    		}
    	}
    	for(let eachCheck of checkedBoxes){
    		if(!featureList.includes(eachCheck)){
    			bus.style.display = "none"
    		}
    	}
    	
    }
	 }
}

function showSnackbar(message){
	var x = document.getElementById("snackbar");
	x.innerHTML = message
	  x.className = "show";
	  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}



