<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/util.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/color.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/SearchBus.css">
  <link rel="icon" href="${pageContext.request.contextPath}/assets/image/favicon.ico" type="image/x-icon">
  <title>Ticket Confirmation</title>
</head>
<body>
 	<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");%>
     <!--Top Navbar-->
  <div class="top-bar fixed-top">
    <div class="row bg-theme-primary">
      <!--BlueBus logo-->
      <div class="col-sm-2">
        <a href="${pageContext.request.contextPath}/"><img class="mt-4 ms-4 p-2 mb-2" src="${pageContext.request.contextPath}/assets/image/BlueBus_icon.png" height="100px"></a>
      </div>
    </div>
  </div>
  <main class="p-md-4 p-3">
    <div class="row">
        <div class="border-1 rounded-corner col-11 col-md-6 col-xl-5 mx-auto bg-theme-primary-light" ">
            <div class="d-flex justify-content-center" >
                <img class="admin-logo rounded-circle " width="400px" height="300px" src="${pageContext.request.contextPath}/assets/image/tick-icon.png">
            </div>
            <section class="border-0">
             <h4 class="mb-3 text-center text-md-left text-theme-primary ">Booking Confirmed!</h4>
            </section>
            <p class="text-center pt-5 text-theme-primary" id="ticket">
               Your PNR number is ${pnr}<br>
			   You have booked ${seatsBooked} seats of Bus Code ${busCode} for <fmt:formatDate pattern = "dd MMM yyyy" value = "${dateOfTrip}" /><br>
			   You will receive your ticket by email shortly
			   
            </p>
        </div>
    </div>
</main>
  </div>
  </div> 
	
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="${pageContext.request.contextPath}/assets/js/pages/confirmation.js"></script>
</body>
</html>
