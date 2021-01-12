const submit = document.getElementById("submit");
const pat_id = document.getElementById("patient");
const navbar = document.getElementById("nav");
const patinfo = document.getElementById("pat-info");
var user = undefined;
const urlParams = new URLSearchParams(window.location.search);

window.addEventListener('DOMContentLoaded', e => {
  console.log("in here");
  user = urlParams.get('username');
  console.log(user);
  if(user != undefined) {
    navbar.innerHTML = navbar.innerHTML + "<div class='info'><span><i class='fas fa-user-md'></i>"+ user + "</span>" + "\n" +
                        "<button type='button' id='sumbit' name='button'>Log out</button></div>";
  }
});

submit.addEventListener("click", e => {
  if(pat_id.value != undefined && pat_id.value != "") {

    communicateWithServlet('GET','/Project/Finder?username=' + pat_id.value);
  }
});

function communicateWithServlet(method, url) {
  var http = new XMLHttpRequest();

  http.onload = function() {
    if(http.status == 200) {

        var response = http.response;
        console.log(response);
        patinfo.innerHTML = patinfo.innerHTML + response;
    }
  };

  http.open(method, url);
  http.send();
}
