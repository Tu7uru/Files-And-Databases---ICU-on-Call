const typespec = document.getElementById("type");
const docspec = document.getElementById("doc-spec");
const nursespec = document.getElementById("nurse-spec");
const emplspec = document.getElementById("empl-spec");
const patspec = document.getElementById("patient-fields");
const submit = document.getElementById("submit");
const username = document.getElementById("username");
const password = document.getElementById("password");
const email = document.getElementById("email");
const firstName = document.getElementById("firstName");
const lastName = document.getElementById("lastName");
const address = document.getElementById("address");
const phone = document.getElementById("phone");
const degree = document.getElementById("degree");
const department = document.getElementById("department");
const insurance = document.getElementById("insurance");
const amka = document.getElementById("amka");
var value = undefined;

emplspec.addEventListener("change", e => {
  if(emplspec.value != "simple") {
    degree.className = "degree success";
  }
})

console.log("HELLO!");
typespec.addEventListener("change", e => {

  value = typespec.value;
  if(value == "doc") {
    docspec.className = "doc-spec success";
    nursespec.className = "nurse-spec";
    emplspec.className = "empl-spec";
    patspec.className = "patient-fields";
    department.className = "department";
    degree.className = "degree";
    value = "doc";
    console.log(value);
  } else if(value == "nurse") {
    nursespec.className = "nurse-spec success";
    docspec.className = "doc-spec";
    emplspec.className = "empl-spec";
    patspec.className = "patient-fields";
    department.className = "department";
    degree.className = "degree";
    value = "nurse";
    console.log(value);
  } else if(value == "empl") {
    emplspec.className = "empl-spec success";
    docspec.className = "doc-spec";
    nursespec.className = "nurse-spec";
    patspec.className = "patient-fields";
    department.className = "department success";
    value = "empl";
    console.log(value);
  } else if(value == "pat"){
    patspec.className = "patient-fields success";
    docspec.className = "doc-spec";
    nursespec.className = "nurse-spec";
    emplspec.className = "empl-spec";
    department.className = "department";
    degree.className = "degree";
    value = "pat";
    console.log(value);
  } else {
    docspec.className = "doc-spec";
    nursespec.className = "nurse-spec";
    emplspec.className = "empl-spec";
    patspec.className = "patient-fields";
    department.className = "department";
    degree.className = "degree";
  }
});

submit.addEventListener("click", e => {
  if(checkFields()) {
      var data = createDataForServlet();

      communicateWithServlet('POST', "/Project/Register",data);
  } else {
    console.log("CHECK FIELDS!");
  }
});

function createDataForServlet() {
  var data = "type=" + value + "\n" +
              "username=" + username.value + "\n" +
              "password=" + password.value + "\n" +
              "email=" + email.value + "\n" +
              "firstName=" + firstName.value + "\n" +
              "lastName=" + lastName.value + "\n" +
              "address=" + address.value + "\n" +
              "phone=" + phone.value + "\n";

  if(value == "doc") {
    data = data + "spec=" + docspec.value;
  } else if( value == "nurse" ) {
    data = data  + "spec=" + nursespec.value;
  } else if( value == "empl" && emplspec.value == "simple" ) {
    data = data + "spec=" + emplspec.value + "\n" +
                  "department="+ department.value;
  } else if( value == "empl" && emplspec.value != "simple" ) {
    data = data + "spec=" + emplspec.value + "\n" +
                  "department="+ department.value + "\n" +
                  "degree="+degree.value;
  }
  else if ( value == "pat" ) {
    data = data  + "insurance=" + insurance.value + "\n" +
                    "amka=" + amka.value;
  }
  return data;
}

function checkFields() {
  console.log("value: "+value + " username" + username.value);
  if(value == undefined|| value=="empty" || username.value == undefined || username.value == "") {
    return false;
  }

  return true;
}


function communicateWithServlet(method,url,data) {
  var http = new XMLHttpRequest();

  console.log("Sending " + data);
  http.onload = function() {
      window.location.href = "../login/login.html";
  }

  http.open(method,url);
  http.send(data);
}
