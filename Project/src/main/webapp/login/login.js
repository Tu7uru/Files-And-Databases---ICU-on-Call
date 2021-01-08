const username = document.getElementById("username");
const password = document.getElementById("password");
const submit = document.getElementById("submit");

submit.addEventListener("click", e => {
  if(checkFields()) {
    url = "/Project/Login?username=" +username.value;
    communicateWithServlet('GET', url);
  }
});

function checkFields() {
  if(username.value == "" || username.value == undefined) {
    return false;
  } else if( password.value == "" || password.value == undefined) {
    return false;
  }

  return true;
}

communicateWithServlet(method, url) {
  var http = new XMLHttpRequest();

  http.onload = function() {
    var response = JSON.parse(http.response);
    if(response.status == 200) {
      var user = response.username;
      window.location.href = "../profile/profile.html?username=" + user;
    }
  };

  http.open(method,url);
  http.send();
}
