<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AddBus</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
<link rel="stylesheet" href="assets/css/pages/addBus.css">
</head>

<body>

	<%
		session = request.getSession(false);
		if (session.getAttribute("isValidUser") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="container">
		<nav class="navbar head">
			<div class="navbar-brand">
				<img src="assets/image/bus.png" height="100">
			</div>
			<a href="<%=request.getContextPath()%>/dashboard">Back To
				Dashboard</a>
		</nav>
		
			<div id="form" class="main mb-5">
				<div class="row m-5 justify-content-between">
					<div class="form-group wd">
						<input type="text"  name="busCode" placeholder="Bus Code"
							id="bus_code" class="form-control" required>
					</div>
					<div class="form-group wd">
						<input type="text" name="reg_no" placeholder="Reg No" id="reg_no"
							class="form-control" required>
					</div>
					<div class="form-group wd">
						<input type="number" name="fare" placeholder="Base Fare" id="fare"
							class="form-control" required>
					</div>
					<div class="form-group wd">
						<input type="number" name="fare_per_km" placeholder="Fare Per Km"
							id="fare_per_km" class="form-control" required>
					</div>
				</div>
				<div class="row m-5 justify-content-around" style="margin-top: 70px">
					<div class="form-group wd">
					                      

                        <form:select path="routeNumList" class="form-control" style="background-color: #FFF6F6;	color: black;	border-color: black;text-align: center; width:100%;width:206px" name="route_code">
						<form:option value="" label="Route code"/>
						<form:options items="${routeNumList}"  />
							
						</form:select>
                    </div>
					<div class="form-group wd">
						<select id="timeDropdownlist" name="time_of_departure" style="background-color: #FFF6F6;	color: black;	border-color: black;text-align: center; width:100%;width:206px" 
							class="form-control" required>
							<option value="" selected>Start Time</option>
						</select>
					</div>
					<div class="form-group wd">
						<input type="number" name="seat_count" placeholder="Seat Count"
							id="seat_count" class="form-control" required>
					</div>
				</div>
				<div class="filters d-flex flex-row m-5" style="margin-top: 70px">
					<div class="pl-3 pr-5">
						<input type="checkbox" name="facility_ac" id="ac-check"> <label
							class="mb-0" for="ac-check">AC</label>
					</div>
					<div class="pr-5">
						<input type="checkbox" name="facility_water" id="water-check">
						<label class="mb-0" for="water-check">Water</label>
					</div>
					<div class="pr-5">
						<input type="checkbox" name="facility_charging" id="cp-check">
						<label class="mb-0" for="cp-check">Charging Point</label>
					</div>
					<div class="pr-5">
						<input type="checkbox" name="facility_pushback_seat"
							id="pbs-check"> <label class="mb-0" for="pbs-check">Pushback
							Seat</label>
					</div>
				</div>
				<div class="d-flex flex-row justify-content-center">
					<button   id="sub" class="btn">Add Bus</button>
				</div>

			</div>
			<div class="row text-center">
					<table id="pager" class="table table-hover table-bordered">
						<thead>
							<tr class="bg-info">
								<th class="fs-5">BUS CODE</th>
								<th class="fs-5">REG NO</th>
								<th class="fs-5">FARE PER KM</th>
								<th class="fs-5">BASIC FARE</th>
								<th class="fs-5">SEAT COUNT</th>
								<th class="fs-5">TIME OF DEPARTURE</th>
								<th class="fs-5">AC FACILITY</th>
								<th class="fs-5">WATER FACILITY</th>
								<th class="fs-5">CHARGING FACILITY</th>
								<th class="fs-5">PUSHBACK SEAT FACILITY</th>
								<th class="fs-5">ROUTE</th>
							</tr>
						</thead>
						<c:set var="count" value="1" scope="page" />
						<c:forEach items="${busDetails}" var="arr">
							<tbody>
								<tr>
								 	    
									<td class="td-style">${arr[0]}</td>
									<td class="td-style">${arr[1]}</td>
									<td class="td-style">${arr[2]}</td>
									<td class="td-style">${arr[3]}</td>
									<td class="td-style">${arr[4]}</td>
								   	<td class="td-style"><fmt:formatDate pattern = "HH:mm" value = "${arr[5]}" /></td>    
									<td class="td-style">${arr[6]}</td>
									<td class="td-style">${arr[7]}</td>
									<td class="td-style">${arr[8]}</td>
									<td class="td-style">${arr[9]}</td>
									<td class="td-style">${arr[10]}</td>
								 	    
								</tr>
							</tbody>

						</c:forEach>
					</table>
				</div>
				
				<div class="row text-center">
					<div id="pageNavPosition" class="pager-nav"></div>
				</div>

	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
	<script src="assets/js/pages/addBus.js"></script>
	<script>
    /* eslint-env browser */
    /* global document */
    
     var formattype="";
    function chooseformat(element){
        formattype=element.id;
        console.log(formattype);
    }


    function Pager(tableName, itemsPerPage) {
        'use strict';

        this.tableName = tableName;
        this.itemsPerPage = itemsPerPage;
        this.currentPage = 1;
        this.pages = 0;
        this.inited = false;

        this.showRecords = function (from, to) {
            let rows = document.getElementById(tableName).rows;

            // i starts from 1 to skip table header row
            for (let i = 1; i < rows.length; i++) {
                if (i < from || i > to) {
                    rows[i].style.display = 'none';
                } else {
                    rows[i].style.display = '';
                }
            }
        };

        this.showPage = function (pageNumber) {
            if (!this.inited) {
                // Not initialized
                return;
            }

            let oldPageAnchor = document.getElementById('pg' + this.currentPage);
            oldPageAnchor.className = 'pg-normal';

            this.currentPage = pageNumber;
            let newPageAnchor = document.getElementById('pg' + this.currentPage);
            newPageAnchor.className = 'pg-selected';

            let from = (pageNumber - 1) * itemsPerPage + 1;
            let to = from + itemsPerPage - 1;
            this.showRecords(from, to);

            let pgNext = document.querySelector('.pg-next'),
                pgPrev = document.querySelector('.pg-prev');

            if (this.currentPage == this.pages) {
                pgNext.style.display = 'none';
            } else {
                pgNext.style.display = '';
            }

            if (this.currentPage === 1) {
                pgPrev.style.display = 'none';
            } else {
                pgPrev.style.display = '';
            }
        };

        this.prev = function () {
            if (this.currentPage > 1) {
                this.showPage(this.currentPage - 1);
            }
        };

        this.next = function () {
            if (this.currentPage < this.pages) {
                this.showPage(this.currentPage + 1);
            }
        };

        this.init = function () {
            let rows = document.getElementById(tableName).rows;
            let records = (rows.length - 1);

            this.pages = Math.ceil(records / itemsPerPage);
            this.inited = true;
        };

        this.showPageNav = function (pagerName, positionId) {
            if (!this.inited) {
                // Not initialized
                return;
            }

            let element = document.getElementById(positionId),
                pagerHtml = '<span onclick="' + pagerName + '.prev();" class="pg-normal pg-prev">&#171;</span>';

            for (let page = 1; page <= this.pages; page++) {
                pagerHtml += '<span id="pg' + page + '" class="pg-normal pg-next bold" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span>';
            }

            pagerHtml += '<span onclick="' + pagerName + '.next();" class="pg-normal">&#187;</span>';

            element.innerHTML = pagerHtml;
        };
    }



    //
    let pager = new Pager('pager', 10);

    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);

</script>
	
</body>
</html>