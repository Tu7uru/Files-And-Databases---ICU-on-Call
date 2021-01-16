const username = document.getElementById("username");
const password = document.getElementById("password");
const type = document.getElementById("type");
const submit = document.getElementById("submit");

submit.addEventListener("click", e => {
  if(checkFields()) {
    console.log(username.value);
    url = "/Project/Login?username=" + username.value + "&password=" + password.value + "&type=" + type.value;
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

function communicateWithServlet(method, url) {
  var http = new XMLHttpRequest();


  console.log("Sending request to " + url);
  http.onload = function() {
    console.log(http.response);
    var response = JSON.parse(http.response);
    if(response.status == 200) {
      var user = response.user.username;
      console.log(user);
      var type = response.type;
      if(type == "doctor") {
        //window.location.href = "../profiles/doctor/doctor.html?username=" + user + "&type=doctor";
      } else if(type == "patient") {
        window.location.href = "../profiles/patient/pat.html?username=" + user + "&id=" + response.user.patient_id;
      } else if(type == "nurse") {
        //window.location.href = "../profiles/doctor/doctor.html?username=" + user + "&type=nurse";
      } else if(type == "employee") {
        window.location.href = "../profiles/asman/asman.html?username=" + user;
      }

    }
  };

  http.open(method,url);
  http.send();
}
