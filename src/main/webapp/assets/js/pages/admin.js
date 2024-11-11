$("#submit").click(function(){
    // action goes here!!
	$('#result').text("");
   var username = $("#username").val().trim();
   var password = $("#password").val().trim();
   

   if(username === '' || password === '' || username.length < 8 || password.length < 8 || username.length > 20 || password.length > 20)
   {
    $('#result').text("Invalid credentials");
    event.preventDefault();
    return;
   }
   
   
}

);