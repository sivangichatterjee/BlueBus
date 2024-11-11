
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Report</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/pages/report.css">


</head>

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
			<div class="pl-3">
				<a class="navbar-brand px-2 m-0"
					href="<%=request.getContextPath()%>/dashboard"><img
					src="${pageContext.request.contextPath}/assets/image/arrow.png"
					alt="arrow" height="28" class="mx-2 d-inline-block" /> </a> <a
					href="<%=request.getContextPath()%>/"><img
					class="m-0 d-inline-block" src="assets/image/bus.png" height="100"></a>
			</div>
			<c:if test="${report=='revenue'}">
				<h2 class="p-2 text-white">Revenue Per Bus</h2>
			</c:if>
			<c:if test="${report=='route'}">
				<h2 class="p-2 text-white">Route Wise Migration</h2>
			</c:if>
			<c:if test="${report=='perbus'}">
				<h2 class="p-2 text-white">Per Bus Ticket Booked</h2>
			</c:if>
			<form action="<%=request.getContextPath()%>/logout" method="get">
				<div class="pb-2 mt-4 mb-2">
					<button class="fw-bolder add-btn pt-2 pb-2 rounded-3 mb-2 shadow">Log Out</button>
				</div>
			</form>
		</div>
	</nav>

	<%-- 	<div>
		<!-- <a href="http://localhost:8080/downloadExcelFile" class="btn btn-primary">Download Excel File</a> -->
		<a href="${pageContext.request.contextPath}/downloadExcelFile">Export
			to Excel</a>
	</div>
	 --%>


	<div class="container-fluid">
		<div class="flex-row text-center">
			<form method="get" class="d-inline"
				action="${pageContext.request.contextPath}/downloadPdfFile">
				<input class="input-cl text-center p-2 pb-0 pt-0 d-none" type="text"
					name="report_type" value='${report}' id="report-type" /> <input
					class="input-cl text-center p-2 pb-0 pt-0 d-none" type="text"
					name="from_date" value='${todate}' id="from-date" /> <input
					class="input-cl text-center p-2 pb-0 pt-0 d-none" type="text"
					name="to_date" value='${fromdate}' id="to-date" />
				<button id="pdf"
					class="fw-bolder download-btn p-2 px-3 rounded-3 mb-2">Download
					PDF</button>
			</form>
			<form method="get" class="d-inline"
				action="${pageContext.request.contextPath}/downloadExcelFile">
				<input class="input-cl text-center p-2 pb-0 pt-0 d-none" type="text"
					name="report_type" value='${report}' id="report-type" /> <input
					class="input-cl text-center p-2 pb-0 pt-0 d-none" type="text"
					name="from_date" value='${todate}' id="from-date" /> <input
					class="input-cl text-center p-2 pb-0 pt-0 d-none" type="text"
					name="to_date" value='${fromdate}' id="to-date" />
				<button id="excel"
					class="fw-bolder download-btn p-2 rounded-3 mb-2 btn-excel">Download
					EXCEL</button>
			</form>

		</div>
		<%-- <c:out value='${report}' /> --%>

		<c:choose>

			<c:when test="${report=='revenue'}">
				<!-- <div class="d-flex justify-content-center m-2">
					<h2 class="h2-style">Revenue Per Bus</h2>
				</div> -->
				<div class="row text-center">
					<table id="pager" class="table table-hover table-bordered">
						<thead>
							<tr class="bg-info">
								<th class="fs-5">Rank</th>
								<th class="fs-5">Bus Code</th>
								<th class="fs-5">Route Code</th>
								<th class="fs-5">Revenue Per Bus</th>
							</tr>
						</thead>

						<c:if test="${data=='out'}">
							<tbody>
								<tr>
									<td colspan="4" class="td-style fs-4">No data to display</td>
								</tr>
							</tbody>
						</c:if>

						<c:set var="count" value="1" scope="page" />

						<c:forEach items="${revperbus}" var="arr">
							<tbody>
								<tr>
									<td class="td-style"><c:out value="${count}" /></td>
									<td class="td-style">${arr[0]}</td>
									<td class="td-style">${arr[1]}</td>
									<td class="td-style">${arr[2]}</td>
									<c:set var="count" value="${count + 1}" scope="page" />

								</tr>
							</tbody>

						</c:forEach>
					</table>
				</div>
			</c:when>
			<c:when test="${report=='route'}">
				<!-- <div class="d-flex justify-content-center m-2">
					<h2 class="h2-style">Route Wise Migration</h2>
				</div> -->
				<div class="row text-center">
					<table id="pager" class="table table-hover table-bordered">
						<thead>
							<tr class="bg-info">
								<th class="fs-5">Rank</th>
								<th class="fs-5">Route Num</th>
								<th class="fs-5">Route Code</th>
								<th class="fs-5">Seat Booked</th>
								<th class="fs-5">Total Seat Count</th>
								<th class="fs-5">Seat Booked Percentage</th>
							</tr>
						</thead>

						<c:if test="${data=='out'}">
							<tbody>
								<tr>
									<td colspan="6" class="td-style fs-4">No data to display</td>
								</tr>
							</tbody>
						</c:if>

						<c:set var="count" value="1" scope="page" />
						<c:forEach items="${routeMig}" var="arr">
							<tbody>
								<tr>

									<td class="td-style"><c:out value="${count}" /></td>
									<td class="td-style">${arr[0]}</td>
									<td class="td-style">${arr[1]}</td>
									<td class="td-style">${arr[2]}</td>
									<td class="td-style">${arr[3]}</td>
									<td class="td-style"><fmt:formatNumber
											minFractionDigits="2" maxFractionDigits="2" value="${arr[4]}" /></td>
									<c:set var="count" value="${count + 1}" scope="page" />

								</tr>
							</tbody>

						</c:forEach>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<!-- <div class="d-flex justify-content-center m-2">
					<h2 class="h2-style">Per Bus Ticket Booked</h2>
				</div> -->
				<div class="row text-center">
					<table id="pager" class="table table-hover table-bordered">
						<thead>
							<tr class="bg-info">
								<th class="fs-5">Rank</th>
								<th class="fs-5">Bus Code</th>
								<th class="fs-5">Route Code</th>
								<th class="fs-5">Total Tickets Booked</th>
							</tr>
						</thead>

						<c:if test="${data=='out'}">
							<tbody>
								<tr>
									<td colspan="4" class="td-style fs-4">No data to display</td>
								</tr>
							</tbody>
						</c:if>

						<c:set var="count" value="1" scope="page" />
						<c:forEach items="${perBus}" var="arr">
							<tbody>
								<tr>
									<td class="td-style"><c:out value="${count}" /></td>
									<td class="td-style">${arr[0]}</td>
									<td class="td-style">${arr[1]}</td>
									<td class="td-style">${arr[2]}</td>
									<c:set var="count" value="${count + 1}" scope="page" />
								</tr>
							</tbody>

						</c:forEach>
					</table>
				</div>
			</c:otherwise>

		</c:choose>

		<div class="row text-center">
			<div id="pageNavPosition" class="pager-nav"></div>
		</div>

	</div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/pages/report.js"></script>

</html>