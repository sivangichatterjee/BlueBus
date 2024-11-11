<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Error</title>
</head>
<body>
<div class="top-bar fixed-top">
    <div class="row bg-theme-primary">
      <!--BlueBus logo-->
      <div class="col-sm-2">
        <img class="mt-4 ms-4 p-2 mb-2" src="${pageContext.request.contextPath}/assets/image/BlueBus_icon.png" height="100px">
      </div>
    </div>
  </div>
  <main class="p-md-4 p-3">
    <div class="row">
        <div class="border-1 rounded-corner col-11 col-md-6 col-xl-5 mx-auto bg-theme-primary-light" ">
            <div class="d-flex justify-content-center" >
                <img class="admin-logo rounded-circle " width="250px" height="250px" src="${pageContext.request.contextPath}\assets\image\614338.png">
            </div>
            <section class="border-0">
            <br>
             <h4 class="mb-3 text-center text-md-left text-theme-primary ">Something went wrong!</h4>
            </section>
            <p class="text-center pt-5 text-theme-primary ">
            Error in accessing <c:out value="${url}"/> <hr/>
<c:choose>
	<c:when test="${not empty exception}">
		${exception.localizedMessage}
	</c:when>
	<c:otherwise>
		<ol>
			<c:forEach var="error" items="${errors}">
				<li>${error}</li>
			</c:forEach>
		</ol>
	</c:otherwise>
</c:choose>
             
            </p>
        </div>
    </div>
</main>
<!--Error in accessing <c:out value="${url}"/> <hr/>
<c:choose>
	<c:when test="${not empty exception}">
		${exception.localizedMessage}
	</c:when>
	<c:otherwise>
		<ol>
			<c:forEach var="error" items="${errors}">
				<li>${error}</li>
			</c:forEach>
		</ol>
	</c:otherwise>
</c:choose> -->
</body>
</html>