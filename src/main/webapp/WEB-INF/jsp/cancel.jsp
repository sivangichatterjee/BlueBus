<!DOCTYPE html>
<html lang="en">

<head>
	<title>Cancel Ticket</title>
	<!--favicon-->
	
	<link rel="icon" href="${pageContext.request.contextPath}/assets/image/favicon.ico" type="image/x-icon">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/cancel.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="theme-color" content="#18621A">
 

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

    
   
      <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet"/>  
</head>
<style>
    .btn-color {
        background: #FF5E5B;
    }
</style>

<body>
	<div class="p-0 m-0 loading-screen d-none">
		<lottie-player class="mx-auto" src="https://assets9.lottiefiles.com/packages/lf20_Gg1cd9.json" background="transparent"  speed="1" loop autoplay></lottie-player>
		<h1 class="h1 f-26 text-center text-theme-primary-dark mx-auto">Loading...</h1>
	</div>
    <nav class="navbar">
        <div class="d-flex flex-row">
            <div class=" p-2" style="margin: auto">
                <a href='<%=request.getContextPath() %>/index'> <i class="fas fa-arrow-left" style="color: white; font-size: 40px;"></i>
                </a>
            </div>


            <a href="<%=request.getContextPath() %>/index">
                <div class="logo "style="margin-left:15px">

                </div>
            </a>
           
        </div>
       
    </nav>
    <main class="p-md-4 p-3">
        <div class="row">
            <div class="border-1 rounded-corner col-11 col-md-6 col-xl-4 mx-auto mt-75" style="background: #F7F7FB;">

                <section class="border-0 mt-4 pt-2">
                    <h4 class="mb-3 text-center text-md-left ">Ticket Cancellation</h4>
                    <div class="form-group  mb-40">
                        <input type="text" id="pnr" name="pnr" placeholder="Enter your pnr" class="form-control" style="
                        margin-top: 47px;"><small id="result" class="text-danger"></small>


                    </div>
                    <a href="#" id="submit" class="btn btn-color mb-40 mt-15">
                        Submit
                    </a>



                </section>
            </div>
        </div>
    </main>
	 <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/pages/cancel.js"></script>
	
</body>

</html>