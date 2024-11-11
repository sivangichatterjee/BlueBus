<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/util.css">
<link rel="stylesheet" href="assets/css/color.css">
<link rel="stylesheet" href="assets/css/pages/SearchBus.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.24.0/axios.min.js"
	integrity="sha512-u9akINsQsAkG9xjc1cnGF4zw5TFDwkxuc9vUp5dltDWYCSmyd0meygbvgXrlc/z7/o4a19Fb5V0OUE58J7dcyw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<title>Search Bus</title>
</head>

<body>
	<!--Top Navbar-->
	<div class="top-bar fixed-top">
		<div class="row bg-theme-primary">
			<!--BlueBus logo-->
			<div class="col-sm-2">
				<a href="<%=request.getContextPath()%>/"><img
					class="mt-4 ms-4 p-2 mb-2" src="assets/image/BlueBus_icon.png"
					height="100px"></a>
			</div>
			<div class="col-sm-10  px-5 ">
				<div class="mt-5 mb-1 p-2 ps-4">
					<!--Source destination and date field-->
					<form:form action="" id="source-dest-date-form" method="post"
						modelAttribute="travelDetails">
						<div class="search-field f-22 row g-0">
							<!--Source-->
							<div class="col-sm-3">
								<!--    <select class="serachElements ms-2 px-4 " name="source" id="source">
                  <option class="source-op" value="select">Source</option>
                  <option class="source-op" value="Howrah">Howrah</option>
                  <option class="source-op" value="Kolkata">Kolkata</option>
                  <option class="source-op" value="Durgapur">Durgapur</option>
                  <option class="source-op" value="Burdwan">Burdwan</option>
                </select> -->
								<form:select path="source" cssClass="serachElements  px-4"
									id="source">
									<form:option value="-" label="--Please Select--" />
									<form:options items="${stationList}" />
								</form:select>
							</div>
							<!--Destination-->
							<div class="col-sm-3">
								<!-- <select class="serachElements  px-4 " name="destination" id="destination">
                  <option class="destination-op" value="select">Destination</option>
                  <option class="destination-op" value="Howrah">Howrah</option>
                  <option class="destination-op" value="Kolkata">Kolkata</option>
                  <option class="destination-op" value="Durgapur">Durgapur</option>
                  <option class="destination-op" value="Burdwan">Burdwan</option>
                </select> -->
								<form:select path="destination" cssClass="serachElements  px-4"
									cssid="destination">
									<form:option value="-" label="--Please Select--" />
									<form:options items="${stationList}" />
								</form:select>
							</div>
							<!--Date-->
							<div class="col-sm-3">
								<input class="serachElements px-4 " id="date" type="date"
									value="date" name="name ">
							</div>
							<!--Search Button-->
							<div class="col-sm-3">
								<input class="serachElements button font-weight-medium ps-4"
									id="SearchBus" type="submit" value="Search">
							</div>
						</div>
					</form:form>
				</div>
			</div>

		</div>
	</div>

	<div class="row ">
		<!-- Side Filter (Sticky)-->
		<div class=" col-sm-2 ps-4 f-18">

			<div class="sticky-top sticky-offset">
				<div class=" py-2 font-weight-medium mb-4 filter">Filters:</div>
				<div class="">
					<div class="form-check my-4">
						<input class="form-check-input" type="checkbox" value=""
							id="AC"> <label class="form-check-label"
							for="AC"> AC </label>
					</div>
					<div class="form-check my-4">
						<input class="form-check-input" type="checkbox" value=""
							id="Non-Ac"> <label class="form-check-label"
							for="Non-Ac"> Non Ac </label>
					</div>
					<div class="form-check my-4">
						<input class="form-check-input" type="checkbox" value=""
							id="Drinking-Water"> <label class="form-check-label"
							for="Drinking-Water"> Drinking Water </label>
					</div>
					<div class="form-check my-4">
						<input class="form-check-input" type="checkbox" value=""
							id="Charging-Point"> <label class="form-check-label"
							for="Charging-Point"> Charging Point </label>
					</div>
					<div class="form-check my-4">
						<input class="form-check-input" type="checkbox" value=""
							id="Push-Back-Seat"> <label class="form-check-label"
							for="Push-Back-Seat"> Push Back Seat </label>
					</div>

				</div>
				<div class="ms-3 ">
					<button class="button btn font-weight-bold " id="apply-filter">Apply
						Filters</button>
				</div>
			</div>

		</div>
		<!--Search Results-->
		<div class=" search-result col-sm-10"></div>
	</div>
	<div id="snackbar">Some text some message..</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script src="assets/js/pages/searchPage.js"></script>
</html>


<script>
window.onload= async function (){
	
	var source = document.querySelector("#source") 
	source.value='${travelDetails.source}'
	var dest = document.querySelector("#destination") 
	dest.value='${travelDetails.destination}' 
	var date = document.getElementById("date")
	date.value = '${travelDetails.traveldate}'
		source.options[0].disabled = true
		dest.options[0].disabled = true
	var searchResult = document.querySelector(".search-result")
	if(source.value == ''){
		source.value ='-'
		dest.value = '-'
		var newDiv2=document.createElement("H4")
				newDiv2.classList.add("text-center","pt-5")
				newDiv2.style.margin="180px"
				newDiv2.style.color="GREY"
				newDiv2.innerHTML="Start Booking!<br>Select a source,destination and date."
			    searchResult.append(newDiv2)
	}
	else{
		//retrieve the travel details as string
		const sourceVal = source.options[source.selectedIndex].text;
	    const destVal = dest.options[dest.selectedIndex].text;
		const journeyDate = date.value;
	    let getUrl = window.location.href+"/getBusList?source="+sourceVal+"&destination="+destVal+"&traveldate="+journeyDate
	  //Sending ajax request
	    const res = await axios.get(getUrl);
	    var data = res.data;
	// render the buslist received from server
	    await showBusList(data)
	//Send post request to payment page after user clicks on book now
	    await filterBuses()
	await bookBus(sourceVal,destVal,journeyDate);
	}
}
</script>

