var user = undefined;
const urlParams = new URLSearchParams(window.location.search);
const navbar = document.getElementById('navbar');


window.addEventListener('DOMContentLoaded', e => {
  console.log("in here");
  user = urlParams.get('username');
  console.log(user);
  if(user == undefined) {
    navbar.innerHTML = navbar.innerHTML + "<a href='./register/register.html'>Register</a>" + "\n" +
                        "<a href='./login/login.html'>Login</a>" + "\n";
  } else {
    navbar.innerHTML = navbar.innerHTML + "<a href='./profile/profile.html?username=" + user +"'>" + user + "</a>" +"\n"+
                        "<a href='index.html'>Log Out</a>" + "\n";
  }
});
