var user = undefined;
const urlParams = new URLSearchParams(window.location.search);
const navbar = document.getElementById('navbar');
const sql = document.getElementById('sql-submit');


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

sql.addEventListener("click", e => {
  var query = document.getElementById("query");

  var data = query.value;

  communicateWithServlet('POST', '/Project/Finder', data);
});

function communicateWithServlet(method, url, data) {
  var http = new XMLHttpRequest();

  http.onload = function() {
    if(http.status == 200) {
      console.log("Query successfully executed with status " + http.status);
    } else {
      console.log("Error: Query unable to execute, status code: " + http.status);
    }
  }

  http.open(method, url);
  http.send(data);
}
