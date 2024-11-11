function populate(selector) {
	var select = $(selector);
	var hours, minutes, ampm;
	for (var i = 0; i <= 1410; i += 30) {
		hours = Math.floor(i / 60);
		minutes = i % 60;
		if (minutes < 10) {
			minutes = '0' + minutes; // adding leading zero to minutes portion
		}
		select.append($('<option></option>')
			.attr('value', hours + ':' + minutes)
			.text(hours + ':' + minutes));

	}
}
//Calling the function on pageload
window.onload = function() {
	populate('#timeDropdownlist');
}


$("#sub").click(function(){
	var json = {};
    $('#form').find('input, select, textarea').each(function() {
	
		if($(this).prop('type')==="checkbox")
		{
			var val = $(this).is(":checked");
			var key = ($(this).attr('name'));
			json[key] = val;
		}
		else
		{
	        var key = ($(this).attr('name'));
			var val = ($(this).val());
			json[key] = val;
		}
    });
	//alert(JSON.stringify(json));
	
	$.ajax({
   url: "doAdd", 
   type: "POST",
 	contentType: "application/json",
   data:  JSON.stringify(json),
   success: function (result) {
       // when call is sucessfull
       console.log(result);
       notify(result);
 
    },
    error: function (err) {
   	
    // check the err for error details
    }
 }); // ajax call cl
});
function notify(data) {
	toastr.options = {
	timeOut: 0,
	positionClass: "toast-top-center"
	}
	var notify;
    toastr.clear();
    if(data === "true")
    	 notify = toastr.success("Bus was added successfully!!");
    else if(data === "false")
    	notify = toastr.error("Bus already exist!!");
	else if(data === "Invalid data")
    	notify = toastr.error("Please enter valid data.");
    else
    	notify = toastr.error("Enter values!!");

    var $notifyContainer = jQuery(notify).closest('.toast-top-center');
    if ($notifyContainer) {
        // align center
        var containerWidth = jQuery(notify).width() + 20;
        $notifyContainer.css("margin-left", -containerWidth / 2);
    }
}
