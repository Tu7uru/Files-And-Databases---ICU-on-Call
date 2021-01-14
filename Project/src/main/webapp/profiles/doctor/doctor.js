const submitpat = document.getElementById("submitpat");
const submitinfo = document.getElementById("submit-info");
const pat_id = document.getElementById("patient");
const navbar = document.getElementById("nav-info");
const patinfo = document.getElementById("pat-info");
const changeable = document.getElementById("changeable-info");
const logout = document.getElementById("log-out");
var mkexam = undefined;
var mkexamdone = false;
var asexam = undefined;
var presc = undefined;
var type = undefined;
var user = undefined;
var id = undefined;
const urlParams = new URLSearchParams(window.location.search);

console.log("HELLO");

window.addEventListener('DOMContentLoaded', e => {
  console.log("in here");
  user = urlParams.get('username');
  type = urlParams.get('type');
  console.log(user);
  if(user != undefined) {
    navbar.innerHTML = navbar.innerHTML + " <span><i class='fas fa-user-md'></i>"+ user + "</span>";

    communicateWithServlet('GET', '/Project/Finder?username=' + user + "&type=doctor");
  }
});

logout.addEventListener("click", e => {
  window.location.href = "../../index.html";
});

submitpat.addEventListener("click", e => {
  if(pat_id.value != undefined && pat_id.value != "") {
    console.log(pat_id.value);
    communicateWithServlet('GET','/Project/Finder?username=' + pat_id.value + "&type=visit");
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

function communicateWithServlet(method, url) {
  var http = new XMLHttpRequest();
  http.onload = function() {
    if(http.status == 200 ) {

        var response = http.response;
        patinfo.innerHTML = patinfo.innerHTML + response;
        mkexam = document.getElementById("make-exam");
        asexam = document.getElementById("assign-exam");
        presc = document.getElementById("prescribe");

        mkexam.addEventListener("click", e => {
          var data;
          //communicateWithServlet('POST', '/Project/ExamServlet', data );
          if(mkexamdone == false) {
            mkexamdone = true;
            mkexam.innerHTML = "<i class='fas fa-lock-open'></i>Re-Examine";
            asexam.innerHTML = "<i class='fas fa-lock-open'></i>Assign Exam";
            presc.innerHTML = "<i class='fas fa-lock-open'></i>Prescribe";
          }
        });

    } else if(http.status == 207) {
      console.log(http.response);
      var response = JSON.parse(http.response);

      var user = response.user;
      var password = document.getElementById("password");
      var phone = document.getElementById("phone");
      var address = document.getElementById("address");
      var unchinfo = document.getElementById("unchangeable-info");
      if(type == "doctor") {
        id = response.user.doctor_id;
      } else {
        id = response.user.nurse_id;
      }

      password.value =  user.password;
      phone.value = user.phone;
      address.value = user.address;

      var unchdata = "<small>USERNAME:</small> " + user.username + "<br><br><br>" +
                      "<small>NAME:</small> " + user.name + "<br><br><br>" +
                      "<small>LASTNAME:</small> " + user.lastname + "<br><br><br>" +
                      "<small>EMAIL:</small> " + user.email + "<br><br><br>";

      unchinfo.innerHTML = unchdata;


    }
  };

  http.open(method, url);
  http.send();
}
