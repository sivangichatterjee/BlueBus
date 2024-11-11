<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blue Bus</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@1,300&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@1,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/pages/index.css">
 
</head>

</head>
<body>
    <nav id="mainNavbar" class="navbar navbar-light navbar-default navbar-expand-md py-0">
        <div class="navbar-brand "><img id="logo" class="py-1" src="assets/image/BlueBus_dark.png" alt=""></div>
        <!--<img id="logo" src="image/BlueBus_dark.png" alt="">-->

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navLinks"
            aria-label="Toggle Navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-md-between" id="navLinks">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a href="#how_it_works" id="" class="nav-link ">How it works</a>
                </li>
                <li class="nav-item">
                    <a href="#testimonial" id="" class="nav-link ">Testimonial</a>
                </li>
                <li class="nav-item">


                    <a href="<%=request.getContextPath() %>/cancel" class="cancel nav-link ">Cancel Ticket</a>


                </li>
            </ul>
        </div>
    </nav>
    <div class="full-bg  d-lg-block" >
        <section class="container  ">
            <div class="d-flex justify-content-center text-center">
                <div class="">
                    <div id=" " class="d-none d-lg-block ">
                        <h3 id="head1" class="">1000+ people use our system</h3>
                        <h1 id="head2" class="">Book Tickets From Anywhere and Everywhere!</h1>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <section class="place-form">
        <div id="box1" class="card d-block d-lg-block">

          <form:form action="SearchBus" class="form1 " id="source-dest-form" method = "post" modelAttribute ="travelDetails">

                <div class="row justify-content-around ">
                    <div  class="form-group col-10 col-lg-3 ">
                        <label for="source">Source</label><br>
                       <!--  <select name="source" class="form-control " id="source">
                            <option value="Esplanade">Esplanade</option>
                            <option value="Howrah">Howrah</option>
                            <option value="Taratala">Taratala</option>
                        </select> -->
                        <form:select cssid="source" path="source" cssClass="form-control">
							<form:option value="-" label="--Please Select--" />
							<form:options items="${stationList}" />
						</form:select>
                    </div>
                    <div class="form-group col-10 col-lg-3">
                        <label for="destination">Destination</label>
                        <!-- <select name="destination" class="form-control" id="destination">

                            <option value="Kolkata">Kolkata</option>

                            <option value="Puri">Puri</option>
                            <option value="Siliguri">Siliguri</option>
                        </select> -->
                        <form:select cssid="destination" path="destination" cssClass="form-control">
							<form:option value="-" label="--Please Select--" />
							<form:options items="${stationList}" />
						</form:select>
                    </div>
                    <div  class="form-group col-10 col-lg-3">
                        <label for="date">Date</label>

                        <input name = "traveldate" type="date" class="form-control" id="date">
                    </div>
                    <div class="book_btn form-group col-10 col-lg-2 ">
                        <button id="submit-form" type="submit" class="btn btn-colour btn-hover btn-lg">Book Ticket</button>

                    </div>
                </div>
            </form:form>
        </div>
    </section>
    <section id="how_it_works" class="container-fluid ">
        <h1 class=" text-center">How it works</h2>
            <p class=" text-center py-2">
                Standing in long queues for booking bus tickets is a thing of the past now. Get your tickets booked
                through Blue Bus by just a few clicks on your mobile or laptop and make your life easy.
            </p>
            <div class="row justify-content-around py-4">
                <div class="col-10 col-lg-3 text-center">

                    <img id="picture" class="img-fluid " src="assets/image/book_online.jpg" alt="">

                    <h4 id="heading" class="py-1">Book Online</h4>
                    <p class="">
                        Book the tickets easily on your mobile or laptop or desktop.
                    </p>
                </div>
                <div class="col-10 col-lg-3 text-center">

                    <img id="picture" class="img-fluid" src="assets/image/payment.jpeg" alt="">

                    <h4 id="heading" class="py-1">Payment </h4>
                    <p class="">
                        Hassle free payment through debit cards of any bank.
                    </p>
                </div>
                <div class="col-10 col-lg-3 text-center">

                    <img id="picture" class="img-fluid " src="assets/image/tickets.jpg" alt="">

                    <h4 id="heading" class="py-1">Tickets </h4>
                    <p class="">
                        Get your ticket personally mailed to your mail id.
                    </p>
                </div>
            </div>
    </section>
    <section id="testimonial" class=" container-fluid">
        <div class="row">
            <div class="col-md-8 col-center m-auto">
                <h1 class=" text-center py-4">Testimonial</h1>
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="img-area">

                                    <img class="" src="assets/image/man1.jfif" alt="First slide">

                                </div>
                                <div class="carousel-caption">
                                    <h3>Mehdi Hossain</h3>
                                    <p>The service was good.Arrival and departure was as per time. The seats were
                                        properly
                                        sanitised.Looking forward to travel again!</p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="img-area">

                                    <img class="" src="assets/image/man2.jfif" alt="Second slide">

                                </div>
                                <div class="carousel-caption">
                                    <h3>Saikat Datta </h3>
                                    <p>It was value for money. The buses have very comfortable seats and they are
                                        punctual as well.I had a very good
                                        experience
                                        overall.</p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="img-area">

                                    <img class="" src="assets/image/woman.jpeg" alt="Third slide">

                                </div>
                                <div class="carousel-caption">
                                    <h3>Shivangini Mishra</h3>
                                    <p>Excellent in terms of service. Covid protocols maintained properly.</p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="img-area">

                                    <img class="" src="assets/image/man3.jfif" alt="Fourth slide">

                                </div>
                                <div class="carousel-caption">
                                    <h3>Arin Tripathi </h3>
                                    <p>Very nice management of routes and timings. Will surely travel again soon.</p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="img-area">

                                    <img class="" src="assets/image/woman2.jpeg" alt="Fifth slide">

                                </div>
                                <div class="carousel-caption">
                                    <h3>Prachi Sharma</h3>
                                    <p>Had a great experience. Would recommend everyone to try their services.</p>
                                </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                            data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next " href="#carouselExampleIndicators" role="button"
                            data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="foot-note">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-4 col-lg-3">

                    <img id="logo" class="d-none d-lg-block py-4" src="assets/image/BlueBus_light.png" alt="">

                    <p class="text-white address">21, M.G Road, Kolkata-700020</p>
                </div>
                <div class="col-4 col-lg-2 ">
                    <!--<h3 class="text-white py-3">Admin Login</h3>-->

                    <a href="<%=request.getContextPath() %>/login" id="" class="admin ">Admin Login</a>

                </div>
                <div class="col-4 col-lg-2">
                    <h4 class="text-white py-1">Contact Us:</h3>
                        <p class="text-white ">Email-bluebusservices@gmail.com.
                            Phone-033-11112222</p>
                </div>
            </div>
        </div>
    </section>
    <div id="snackbar"></div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
          <script src="assets/js/pages/index.js"></script>
          
</body>
</html>