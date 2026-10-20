const navbar = document.getElementById("nav-info");
var user = undefined;
var id = undefined;
const urlParams = new URLSearchParams(window.location.search);
const makevisit = document.getElementById("make-visit");
const date = document.getElementById("date");
const unchinfo = document.getElementById("unchangeable-info");
const password = document.getElementById("password");
const address = document.getElementById("address");
const phone = document.getElementById("phone");
const logout = document.getElementById("logout");
const submitinfo = document.getElementById("submit-info");

window.addEventListener('DOMContentLoaded', e => {
  console.log("in here");
  user = urlParams.get('username');
  id = urlParams.get('id');
  if(user != undefined) {
    navbar.innerHTML = navbar.innerHTML + "<span><i class='far fa-user-circle'></i>"+ user + "</span>" + "\n";

    communicateWithServlet('GET', '/Project/Finder?username=' + user + "&type=patient");
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
              "type=patient" ;

    communicateWithServlet('PUT', '/Project/Register',data);
  }
});

makevisit.addEventListener('click', e => {
  if(date.value != undefined || date.value != "") {
    var s = document.getElementById("symptoms");
    var data = "date=" + date.value + "\n" +
          "patient_id=" + id + "\n" +
          "symptoms=" + s.value;
          console.log(data);
    communicateWithServlet('POST',"/Project/VisitServlet",data);
  }
});

logout.addEventListener("click", e => {
  window.location.href = "../../index.html";
});

function communicateWithServlet(method, url, data) {

  var http = new XMLHttpRequest();
  if(method == 'GET') {
    http.onload = function() {
        if(http.status == 200 ) {

            var response = JSON.parse(http.response);
            console.log(response);

            var user = response.user;
            var password = document.getElementById("password");
            var phone = document.getElementById("phone");
            var address = document.getElementById("address");
            var unchinfo = document.getElementById("unchangeable-info");

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
  } else if( method == 'POST') {
      http.onload = function() {
          if(http.status == 201 ) {

              console.log(http.response);
          }
      }

      http.open(method, url);
      http.send(data);
  } else if( method == 'PUT' ) {
    http.onload = function() {
      if(http.status == 201) {
        var response = JSON.parse(http.response);
        console.log(response);
      }
    }

    http.open(method,url);
    http.send(data);
  }
}
