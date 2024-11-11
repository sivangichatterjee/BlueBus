<!-- TO BE INTEGRATED WITH PAYMENT CONTROLLER -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Payment Details</title>
	
	    <!-- Google font -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
	    <!-- Font Awesome -->
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
	    <!-- BootStrap -->
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
	    <!-- Custom Css -->
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/util.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/payment.css">
	    <!-- Toastr -->
	    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet"/>
	</head>

	<body>
		<div class="p-0 m-0 loading-screen d-none">
	        <lottie-player class="mx-auto" src="https://assets9.lottiefiles.com/packages/lf20_Gg1cd9.json" background="transparent"  speed="1" loop autoplay></lottie-player>
	        <h1 class="h1 f-26 text-center text-theme-primary-dark mx-auto">Loading...</h1>
	    </div>
	    <div class="container">
	        <nav class="navbar navbar-expand d-none d-md-block">
	            <a href="javascript:javascript:history.go(-1)" class="navbar-brand d-flex align-items-center mb-3">
	                <i class="fas fa-arrow-left em-2 text-theme-primary-dark"></i>
	                <img class="mx-4" src="${pageContext.request.contextPath}/assets/image/BlueBus_dark_icon.png" alt="Company Logo" width="125px">
	            </a>
	        </nav>
	        <header class="row pt-4 pb-5 mt-sm-3 py-md-4 px-md-5 bg-theme-primary f-22 font-weight-light text-theme-white">
	            <div class="col-12 d-block d-md-none mb-4">
	                <a href="javascript:javascript:history.go(-1)"><i class="fas fa-chevron-left text-theme-white"></i></a>
	            </div>
	            <div class="col-12 col-lg-6 col-xl-5 d-flex justify-content-between from-to-dest mb-4 mb-xl-0">
	                <div class="d-flex flex-column">
	                    <div class="mb-5 from-block" id="bus-start-time"><fmt:formatDate pattern = "HH:mm" value = "${busDetails.getStartTime()}" /></div>                <!-- BUS TIMGING START ID -->
	                    <div class="to-block" id="bus-stop-time"><fmt:formatDate pattern = "HH:mm" value = "${busDetails.getEndTime()}" /></div>                        <!-- BUS TIMGING STOP  ID -->
	                </div>
	                <div class="d-flex flex-column flex-grow-1  ml-5">
	                    <div class="d-flex justify-content-end justify-content-md-between mb-5 position-relative">
	                        <span class="d-none d-md-inline-block font-weight-medium">From: </span> 
	                        <div class="d-inline-block">
	                            <div class="text-right" id="bus-start-name">${busDetails.getStartStopName()}</div>                                                <!-- BUS START NAME ID -->
	                          <!--  <div class="f-15 text-right">(<span id="bus-start-date"><fmt:formatDate pattern = "dd MMM yyyy" value = "${busDetails.getDateOfDept()}" /></span>)</div> -->
	                        </div>                          
	                    </div>
	                    <div class="d-flex justify-content-end justify-content-md-between position-relative">
	                        <span class="d-none d-md-inline-block font-weight-medium">To: </span>
	                        <div class="d-inline-block">
	                            <div class="text-right" id="bus-stop-name">${busDetails.getEndStopName()}</div>                                                               <!-- BUS STOP NAME ID -->
	                        </div>                                  
	                    </div>
	                </div>
	            </div>
	            <div class="col-12 col-lg-6 col-xl-3 d-flex flex-column mb-4 mb-xl-0">
	                <div class="d-flex justify-content-between mb-5">
	                    <span class="inline-block font-weight-medium">BusCode: </span> 
	                    <span class="inline-block" id="bus-code">${busDetails.getBusCode()}</span>                                                  <!-- BUS CODE -->
	                </div>
	                <div class="d-flex justify-content-between">
	                    <span class="inline-block font-weight-medium">Date: </span> 
	                    <span class="inline-block" id="bus-date"><fmt:formatDate pattern = "dd MMM yyyy" value = "${busDetails.getDateOfDept()}" /></span>                                             <!-- BUS DATE FOR DEPARTURE -->
	                </div>
	            </div>
	            <div class="col-12 col-xl-4 d-flex mt-4 mt-xl-0 justify-content-end align-items-center f-26">
	                <span class="mr-4">Total Cost:</span>
	                    <span class="font-weight-bold" id="total-ticket-cost"></span>                                                              <!-- TICKET TOTAL COST -->
	            </div>
	        </header>
	        <main class="row d-flex flex-column-reverse flex-lg-row px-2 px-sm-0 py-4">
	            <article class="col-12 col-lg-5 notice-board mt-3 mt-lg-0 py-5 px-4 border">
	                <h1 class="h1 f-22">Notice: </h1>
	                <p class="my-4">
	                    <div class="d-flex">
	                        <div class="card-badge">1</div>
	                        <h2 class="h2 f-18">Always wear Mask</h2>
	                        <i class="fas fa-head-side-mask f-22 text-theme-grey px-4 flex-grow-1 text-right"></i>
	                    </div>
	                    <p>
	                        Due to Covid 19, wearing mask is mandatory. Bus Management hold the rights to reject service if not followed.
	                    </p>
	                </p>
	                <p class="my-4">
	                    <div class="d-flex">
	                        <div class="card-badge">2</div>
	                        <h2 class="h2 f-18">Carry Ticket Booking</h2>
	                        <i class="fas fa-ticket-alt f-22 text-theme-grey px-4 flex-grow-1 text-right"></i>
	                    </div>
	                    <p>
	                        Ticket information will  be sent to the entered email address which contains the PNR number, this email would be proof
	                         of your booking and customers need to produce the ticket while boarding the bus.
	                    </p>
	                </p>
	            </article>
	            <section class="col-12 col-lg-7 p-0 m-0 pl-lg-3">
	                <article class="card pt-4 pb-3 px-3 px-md-5 d-flex flex-column flex-md-row mb-3">
	                    <div class="card-badge">a</div>
	                        <form class="flex-grow-1 pt-4">
	                            <div class="form-group">
	                                <input class="form-control" type="text" placeholder="Enter Email Address" id="email">               <!-- PERSONAL EMAIL ID -->
	                                <small data-validator="email" class="text-danger hidden">Enter Valid Email Address</small>
	                            </div>
	                            <div class="form-group row">
	                                <label for="num-seats" class="col-sm-4 col-form-label mb-4">Number of Seats: </label>                
	                                <div class="col-sm-8 my-auto">
	                                    <div class="p-0 position-relative">
	                                        <input type="range" class="custom-range " id="num-seats" min="1" max="${maxBookableSeats}" steps="1">         <!-- NUMBER OF SEATS REQUERED -->
	                                        <output class="bubble"></output>
	                                    </div>
	                                </div>
	                            </div>
	                        </form>
	                </article>
	                <article class="card pt-4 pb-3 px-3 px-md-5 d-flex flex-column flex-md-row">
	                    <div class="card-badge">b</div>
	                        <form class="flex-grow-1 py-4">
	                            <div class="form-row ">
	                                <div class="form-group col-12 col-md-8">
	                                    <input class="form-control" type="text" placeholder="Enter Card Number" id="card-num">      <!-- CARD NUMBER -->
	                                    <small data-validator="card-num" class="text-danger hidden">Enter Valid Card Number</small>
	                                </div>
	                                <div class="form-group col-12 col-md-4">
	                                    <input class="form-control" type="password" placeholder="Enter CVV" id="card-cvv">              <!-- CARD CVV -->
	                                    <small data-validator="card-cvv" class="text-danger hidden">Enter Valid CVV</small>                              
	                                </div>
	                            </div>
	                            <div class="form-row">
	                                <div class="form-group col-12">
	                                    <input class="form-control" type="text" placeholder="Name of Card Holder" id="card-holder-name">    <!-- CARD HOLDER NAME -->
	                                    <small data-validator="card-holder-name" class="text-danger hidden">Enter Card Holder Name</small>                                
	                                </div>
	                            </div>
	                            <div class="form-row justify-content-between">
	                                <div class="form-row col-12 col-xl-8 mb-3">
	                                    <div class="col-12 col-md-6 form-group pb-1 m-0 mb-2 mb-md-0">
	                                        <select class="custom-select" id="month-exp">                                                   <!-- EXPIRY MONTH -->
	                                            <option value="none" selected disabled hidden>Month of Exp.</option>
	                                            
	                                        </select>                             
	                                        
	                                    </div>
	                                    <div class="col-12 col-md-6 form-group pb-1 m-0">
	                                        <select class="custom-select" id="year-exp">
	                                            <option value="none" selected disabled hidden>Year of Exp.</option>                             <!-- EMPIRY YEAR -->
	                                            
	                                        </select>                     
	                                    </div>
	                                    <small data-validator="exp_date" class="text-danger pl-1 hidden">Expiry date has passed or invalid</small>
	                                </div>
	                                <button class="col-12 col-xl-4 btn bg-theme-secondary px-4 text-theme-white" type="button" id="submit-btn">Continue</button>            <!-- SUBMIT BUTTON -->
	                            </div>
	                        </form>
	                </article>
	            </section>
	
	        </main>
	    
	    </div>
	
	    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
	    
	    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
	
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
	
	    <script src="${pageContext.request.contextPath}/assets/js/pages/payment.js"></script>
	</body>
</html>