const navbar = document.getElementById("nav");
var user = undefined;
const submitpat = document.getElementById("submitpat");
const submitdoc = document.getElementById("submitdoc");
const submitnurse = document.getElementById("submitnurse");
const submitinfo = document.getElementById("submit-info");
const updateinfo = document.getElementById("submit-visit");
const updateshift = document.getElementById("submit-shift");
const logout = document.getElementById("log-out");
const pat_id = document.getElementById("patient");
const doc_id = document.getElementById("doctor");
const nurse_id = document.getElementById("nurse");
const patinfo = document.getElementById("pat-info");
const docinfo = document.getElementById("doc-info");
const nurseinfo = document.getElementById("nurse-info");
const urlParams = new URLSearchParams(window.location.search);

window.addEventListener('DOMContentLoaded', e => {
  console.log("in here");
  user = urlParams.get('username');
  console.log(user);
  if(user != undefined) {
    navbar.innerHTML = navbar.innerHTML + "<span><i class='fas fa-user-shield'></i>"+ user + "</span>";

    communicateWithServlet('GET', '/Project/Finder?username=' + user + "&type=employee");
  }
});

logout.addEventListener("click", e => {
  console.log("click");
  window.location.href = "../../index.html";
});

submitpat.addEventListener("click", e => {
  if(pat_id.value != undefined && pat_id.value != "") {
    console.log(pat_id.value);
    communicateWithServlet('GET','/Project/Finder?username=' + pat_id.value + "&type=patient-info", "patient");
  }
});

submitdoc.addEventListener("click", e => {
  if(doc_id.value != undefined && doc_id.value != "") {
    console.log(doc_id.value);
    communicateWithServlet('GET','/Project/Finder?username=' + doc_id.value + "&type=doctor-info", "doctor");
  }
});

submitnurse.addEventListener("click", e => {
  if(nurse_id.value != undefined && nurse_id.value != "") {
    console.log(nurse_id.value);
    communicateWithServlet('GET','/Project/Finder?username=' + nurse_id.value + "&type=nurse-info", "nurse");
  }
});

submitinfo.addEventListener("click", e => {
  if(user != undefined) {
    var password = document.getElementById("password");
    var phone = document.getElementById("phone");
    var address = document.getElementById("address");

    var data = "username=" + user + "\n" +
              "password=" + password.value + "\n" +
              "phone=" + phone.value + "\n" +
              "address=" + address.value + "\n" +
              "type=" + type;

    updateUser('PUT', '/Project/Register',data);
  }
});

updateinfo.addEventListener("click", e => {
    var pat_id = document.getElementById("pat_id");
    var pat_date = document.getElementById("pat_date");
    var pat_cure = document.getElementById("pat_cure");
    var pate_state = document.getElementById("pat_state");

    var data = "patient_id=" + pat_id.value + "\n" +
                "date=" + pat_date.value + "\n" +
                "cure=" + pat_cure.value + "\n" +
                "type=visit\n" +
                "state=" +  pat_state.value;

                console.log("SENDING "  + data);
    updateUser('PUT', '/Project/Register',data);
});

updateshift.addEventListener("click", e => {
    var emp_id = document.getElementById("emp_id");
    var doc_id = document.getElementById("doc_id");
    var nurse_id = document.getElementById("nurse_id");
    var s_type = document.getElementById("s_type");
    var s_dept = document.getElementById("s_dept");
    var date = document.getElementById("date");

    console.log(emp_id.value);

    var emp,doc,nurse,s_type1,dept;

    if(emp_id.value == "") {
      emp = "null";
    } else {
      emp = emp_id.value;
    }
     if (doc_id.value == "") {
      doc = "null";
    } else {
      doc = doc_id.value;
    }
     if (nurse_id.value == "") {
      nurse = "null";
    } else {
      nurse = nurse_id.value;
    }
      if (s_type.value == "") {
      s_type1 = "null";
    } else {
      s_type1 = s_type.value;
    }
      if (s_dept.value == "") {
      dept = "null";
    } else {
      dept = s_dept.value;
    }

    var data = "employee_id=" + emp + "\n" +
                "doctor_id=" + doc + "\n" +
                "nurse_id=" + nurse + "\n" +
                "s_type="+ s_type1 +"\n" +
                "date="+ date.value +"\n" +
                "type=shift\n" +
                "department=" +  dept;

                console.log(data);
    updateUser('PUT', '/Project/Register',data);
});

function updateUser(method, url, data) {
  var http = new XMLHttpRequest();

  http.onload = function() {
      if(http.status == 201) {
        var response = JSON.parse(http.response);
        console.log(response);
      }
  }

  http.open(method,url);
  http.send(data);
}

function communicateWithServlet(method, url, type) {
  var http = new XMLHttpRequest();
  http.onload = function() {
    if(http.status == 200 ) {
      // OTHERS INFO
        console.log(http.response);
        var response = http.response;
        if(type == "patient") {
          patinfo.innerHTML = patinfo.innerHTML + response;
        } else if(type == "doctor") {
          console.log("in here");
          docinfo.innerHTML = docinfo.innerHTML + response;
        } else {
          nurseinfo.innerHTML = nurseinfo.innerHTML + response;
        }

    } else if(http.status == 207) {
      // MY INFO
        console.log(http.response);
        var response = JSON.parse(http.response);

        var user = response.user;
        var password = document.getElementById("password");
        var phone = document.getElementById("phone");
        var address = document.getElementById("address");
        var unchinfo = document.getElementById("unchangeable-info");
        id = user.employee_id;

        password.value =  user.password;
        phone.value = user.phone;
        address.value = user.address;

        var unchdata = "<small>USERNAME:</small> " + user.username + "<br><br><br>" +
                        "<small>NAME:</small> " + user.name + "<br><br><br>" +
                        "<small>LASTNAME:</small> " + user.lastname + "<br><br><br>" +
                        "<small>EMAIL:</small> " + user.email + "<br><br><br>";

        unchinfo.innerHTML = unchdata;



    }
  }

  http.open(method, url);
  http.send();
};
