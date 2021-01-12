const navbar = document.getElementById("nav");
var user = undefined;
const urlParams = new URLSearchParams(window.location.search);

window.addEventListener('DOMContentLoaded', e => {
  console.log("in here");
  user = urlParams.get('username');
  console.log(user);
  if(user != undefined) {
    navbar.innerHTML = navbar.innerHTML + "<div class='info'><span><i class='fas fa-user-shield'></i>"+ user + "</span>" + "\n" +
                        "<button type='button' id='sumbit' name='button'>Log out</button></div>";
  }
});
