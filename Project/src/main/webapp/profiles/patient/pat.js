const navbar = document.getElementById("nav");
var user = undefined;
var id = undefined;
const urlParams = new URLSearchParams(window.location.search);
const btn = document.getElementById("make-visit");
const date = document.getElementById("date");

window.addEventListener('DOMContentLoaded', e => {
  console.log("in here");
  user = urlParams.get('username');
  id = urlParams.get('id');
  if(user != undefined) {
    navbar.innerHTML = navbar.innerHTML + "<div class='info'><span><i class='far fa-user-circle'></i>"+ user + "</span>" + "\n" +
                        "<button type='button' id='sumbit' name='button'>Log out</button></div>";
  }
});

btn.addEventListener('click', e => {
  if(date.value != undefined || date.value != "") {
    var data = "date=" + date.value + "\npatient_id=" + id;
    communicateWithServlet('POST',"/Project/VisitServlet",data);
  }
});

function communicateWithServlet(method,url,data) {
  var http = new XMLHttpRequest();

  http.onload = function() {
      console.log(http.response);
  }

  http.open(method,url);
  http.send(data)
}
