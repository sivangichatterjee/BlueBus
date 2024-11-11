<!DOCTYPE html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="assets/css/pages/dashboard.css">
<title>Dashboard</title>

<script>
   history.pushState(null, null, location.href);
window.addEventListener('popstate', function () {
    history.pushState(null, null, location.href);
});
</script>
</head>

<html>

<body>

	<%
	session = request.getSession(false);
	if (session.getAttribute("isValidUser") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);
	%>
	<nav class="navbar nav-col mb-3">
		<div class="container-fluid">
			<a class="navbar-brand px-2 m-0"
				href="<%=request.getContextPath()%>/">
				<div class="pl-3">
					<!-- <img src="assets/image/arrow.png" alt="back-arrow" height="28"
						class="mx-2 d-inline-block" /> -->
					<img src="assets/image/bus.png" alt="logo" height="100"
						class="m-0 -inline-block" />
				</div>
			</a>
			<h2 class="p-2 text-white">Admin Dashboard</h2>
			<div class="pb-2 mt-4 mb-2">
				<form action="<%=request.getContextPath()%>/logout" method="get">
					<button type="submit"
						class="fw-bolder btn-lg add-btn p-2 rounded-3 shadow">Log Out</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row m-0">
			<div
				class="col-md-5 col-10 p-4 mt-md-4 mt-sm-1 justify-content-between">
				<div class="text-center mt-md-3 p-md-3">

					<div class="pb-2 mt-4 mb-2">
						<!-- <button class="fw-bolder add-btn p-2 rounded-3 ">Add
							Bus</button> -->
						<form action="addBus" method="post">
							<button id="addbus" type="submit" class="fw-bolder add-btn p-2 rounded-3 ">Add
								Bus</button>
						</form>
					</div>
					<!-- 	<form method="post" onsubmit="fun(this)" action=""> -->
					<div id="route" onclick="choosediv(this)"
						class="border option rounded-3 p-md-3 p-2">Route Wise
						Migration</div>
					<div id="revenue" onclick="choosediv(this)"
						class="selected-type border option rounded-3 p-md-3 p-2">Revenue
						per bus</div>

					<div id="perbus" onclick="choosediv(this)"
						class="border rounded-3 p-md-3 p-2">Per Bus Ticket Booking
						Data</div>
				</div>
			</div>

			<div class="col-md-6 col-10 p-4 mt-md-4">
				<div id="date-error" class="date-error fw-bolder position-absolute">Please
					Enter Valid Date</div>
				<div class="text-center p-5">
					<!-- <img id="pdf" onclick="chooseformat(this)" class="selected-format" src="pdfimg.png" alt="pdf" />
            <img id="excel" onclick="chooseformat(this)" class="" src="excelimg.png" alt="excel" /> -->

					<img id="pdf" class="" src="${pageContext.request.contextPath}/assets/image/pdfimg.png" alt="pdf" />
					<img id="excel" class="" src="${pageContext.request.contextPath}/assets/image/excelimg.png"
						alt="excel" />
				</div>
				<form method="post" onsubmit="return validate(this)" action="report" modelAttribute="QueryDetails">

					<input class="input-cl text-center p-2 pb-0 pt-0 d-none"
						type="text" name="report_type" id="report-type" />

					<div class="container p-0">
						<div class="row justify-content-end">
							<div class="col-5 text-center pb-2">
								<label for="from-date">From Date:</label>
							</div>
							<div class="col-7 pb-2">
								<input class="input-cl text-center p-2 pb-0 pt-0" type="date"
									name="from_date" id="from-date" />
							</div>
						</div>
						<div class="row justify-content-center">
							<div class="col-5 text-center pb-2">
								<label for="from-date">To Date:</label>
							</div>
							<div class="col-7 pb-2">
								<input class="input-cl text-center p-2 pb-0 pt-0" type="date"
									name="to_date" id="to-date" />
							</div>
						</div>
						<div class="row m-0 p-0 ">
							<button id="genreport" class="fw-bolder col-7 add-btn p-2 rounded-3 shadow mt-1"
								type="submit" onclick="fun(this)">Generate Report</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
<script src="${pageContext.request.contextPath}/assets/js/pages/dashboard.js"></script>

</body>

</html>