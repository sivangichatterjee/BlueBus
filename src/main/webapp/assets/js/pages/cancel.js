$("#submit").click(function(){

   var pnr = $("#pnr").val().trim();
   $("#result").text('');
   var filter = /[1]{1}[0-9]{9}$/;
   if(pnr < 1  || !filter.test(pnr))
   {
       $("#result").text("Enter a valid pnr");
        return;
   }
	const loading_window = document.getElementsByClassName("loading-screen")[0]
  
        loading_window.classList.add("d-block")
        loading_window.classList.remove("d-none")
        loading_window.classList.remove("opacity-0")
	data = {pnr : pnr};
	var url = "doCancel"
	$.ajax({
   url: url, 
   type: "POST",
  // dataType: "json",
   contentType: "application/json; charset=utf-8",
   data: JSON.stringify(data),
   success: function (result) {
       // when call is sucessfull
        loading_window.classList.remove("d-block")
        loading_window.classList.add("d-none")
       notify(result);
 
    },
    error: function (err) {
   	 loading_window.classList.remove("d-block")
     loading_window.classList.add("d-none")
     alert("failed...please try after sometime");
    // check the err for error details
    }
 }); // ajax call closing;
	
});
//code to center the toastr alert box
function notify(data) {
	$("#result").text("");
	toastr.options = {
	timeOut: 0,
	positionClass: "toast-top-center"
	}
	var notify;
    toastr.clear();
    if(data === true)
    	 notify = toastr.success("Your ticket was cancelled");
    else
    	notify = toastr.error("Pnr does not exist");

    var $notifyContainer = jQuery(notify).closest('.toast-top-center');
    if ($notifyContainer) {
        // align center
        var containerWidth = jQuery(notify).width() + 20;
        $notifyContainer.css("margin-left", -containerWidth / 2);
    }
}
