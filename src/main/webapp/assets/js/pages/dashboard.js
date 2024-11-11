
    var divtype = "revenue";
    document.getElementById("report-type").value=divtype;
    /* var formattype = "pdf"; */

    function choosediv(element) {

      divtype = element.id;
      // if(divtype==""){
      //   divtype="revenue";
      // }
      // console.log(divtype);
      if (document.querySelectorAll('.selected-type').length > 0) {
        document.querySelectorAll('.selected-type').forEach(el => {
          el.classList.remove('selected-type');
        })
      }
      element.classList.add('selected-type');
      document.getElementById("report-type").value=divtype;
    }
   /*  function chooseformat(element) {
      formattype = element.id;
      // console.log(element.alt);
      if (document.querySelectorAll('.selected-format').length > 0) {
        document.querySelectorAll('.selected-format').forEach(el => {
          el.classList.remove('selected-format');
        })
      }
      element.classList.add('selected-format');
    } */
    function fun(element) {
      console.log(divtype);
     /*  console.log(formattype); */
      console.log(document.getElementById("from-date").value);
      console.log(document.getElementById("to-date").value);
      var fromDate = document.getElementById("from-date").value;
      var toDate = document.getElementById("to-date").value;
      var today = new Date().toISOString().slice(0, 10);
      if (fromDate == "" || toDate == "") {
          document.getElementById("date-error").innerHTML = "Please Select Both Dates";
        }
        else if (fromDate > toDate) {
          document.getElementById("date-error").innerHTML = "From Date Should Be Less Than To Date";
        }
       
        else if (toDate > today) {
            document.getElementById("date-error").innerHTML = "To Date Should Be Less Than or Equal To Today";
          }
      
      
    }
    function validate() {

      var fromDate = document.getElementById("from-date").value;
      var toDate = document.getElementById("to-date").value;
      var today = new Date().toISOString().slice(0, 10);
      console.log(today);
      if (fromDate <= toDate && fromDate<=today && fromDate!="" && toDate!="" && toDate<=today) {
        console.log("ok");
        document.getElementById("date-error").style.display = "none";
        return true;
      }
      else {
        console.log("not ok");
        document.getElementById("date-error").style.display = "block";
        return false;
      }


    }