const travelForm = document.getElementById("submit-form")
var source = document.querySelector("#source");
    var destination = document.querySelector("#destination");
source.options[0].disabled = true
	destination.options[0].disabled = true
travelForm.addEventListener("click",function(e){
	const journeyDate = document.getElementById("date").value; // extracting
																// date in Date
																// format
    const selectedDate = journeyDate.split('-'); // converting date to string
													// by splitting using -
    console.log(journeyDate);
    const today = new Date;
    // Retrieving source and destination dropdown
    
    const sourceVal = source.options[source.selectedIndex].text;
    const destVal = destination.options[destination.selectedIndex].text;
    var isDateValid = 0

    
    // Check validation of date
    if(selectedDate[0] < today.getFullYear()){ //past year
    	//alert("Please select a valid date");
showToaster("Please select a valid date")
e.preventDefault()
        return;
    }



    if(selectedDate[0] > today.getFullYear()){ //future year
    	isDateValid =1
    }
    if (selectedDate[0] == today.getFullYear()){	//same year
    	if(selectedDate[1]< (today.getMonth() + 1)){ //same year but previous month
    		//alert("Please select a valid date");
			showToaster("Please select a valid date")
			e.preventDefault()
            return;
    	}
    	if(selectedDate[1]> (today.getMonth() + 1)){ //same year but future month
    		isDateValid =1
    	}
    	if(selectedDate[1] == (today.getMonth() + 1)){ //same year same month 
    		if(selectedDate[2] > today.getDate())     //same year same month today or future date
    			isDateValid =1
    	}
    }
    if(isDateValid ==0){
       // alert("Please select a valid date");
		showToaster("Please select a valid date")
		e.preventDefault()
        return;
	}
	if(destination.value=='-' && source.value=='-')
{
	//alert("Select valid destination");
	showToaster("Select valid source and destination ")
	e.preventDefault()
}
else{
    //source and destination should not be null
if(source.value=='-' ){
	//alert("Select valid source");
	showToaster("Select valid source ")
	e.preventDefault()
}
if(destination.value=='-' ){
	//alert("Select valid destination");
	showToaster("Select valid destination ")
	e.preventDefault()
}

    // Check if source and destination are same
    if (sourceVal == destVal) {
        //alert("Source and destination can not be same");
showToaster("Source and destination can not be same")
e.preventDefault()
    }
}
})

function showToaster(m) {
  var x = document.getElementById("snackbar");
  x.innerHTML=m;
  x.className = "show";
  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}