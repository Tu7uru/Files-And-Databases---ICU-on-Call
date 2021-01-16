const submitpat = document.getElementById("submitpat");
const submitinfo = document.getElementById("submit-info");
const submitvisit = document.getElementById("submit-visit");
const pat_id = document.getElementById("patient");
const navbar = document.getElementById("nav-info");
const patinfo = document.getElementById("pat-info");
const changeable = document.getElementById("changeable-info");
const logout = document.getElementById("log-out");
var mkexam = undefined;
var mkexamdone = false;
var asexam = undefined;
var presc = undefined;
var doneEvents = false;
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

submitvisit.addEventListener("click", e => {
  var pat_id = document.getElementById("pat_id");
  var pat_date = document.getElementById("pat_date");
  var pat_cure = document.getElementById("pat_cure");
  var pate_state = document.getElementById("pat_state");

  var data = "patient_id=" + pat_id.value + "\n" +
              "date=" + pat_date.value + "\n" +
              "cure=" + pat_cure.value + "\n" +
              "type=visit\n" +
              "state=" +  pat_state.value;

              console.log("SENDING "  + data);
  updateUser('PUT', '/Project/Register',data);
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
      // PAT INFO
        var response = http.response;
        patinfo.innerHTML = patinfo.innerHTML + response;
        mkexam = document.getElementById("make-exam");
        asexam = document.getElementById("assign-exam");
        presc = document.getElementById("prescribe");
        var row = mkexam.parentElement.parentElement.cells;



        mkexam.addEventListener("click", e => {






          if(mkexamdone == false) {
            var data = 'date=' + row[1].innerHTML + "\n" +
                          'doctor_id=' + id + "\n" +
                          'patient_id=' + row[0].innerHTML+ "\n" +
                          'type=make';
                  mkexamdone = true;
                  mkexam.innerHTML = "<i class='fas fa-lock-open'></i>Re-Examine";
                  asexam.innerHTML = "<i class='fas fa-lock-open'></i>Assign Exam";
                  presc.innerHTML = "<i class='fas fa-lock-open'></i>Prescribe";
          } else {
            var data = 'date=' + row[1].innerHTML + "\n" +
                          'doctor_id=' + id + "\n" +
                          'patient_id=' + row[0].innerHTML+ "\n" +
                          'type=re-examine';
          }

          console.log(data);
          
          examinePatient('POST', '/Project/ExamServlet', data );

        });

    } else if(http.status == 207) {
      // MY INFO
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
  }

  http.open(method, url);
  http.send();
};

function examinePatient(method,url,data) {
  var http = new XMLHttpRequest();

  http.onload = function () {
    if(http.status == 200) {
      var response = JSON.parse(http.response);
      if (doneEvents == false) {
        console.log("checkhere: \n"+response);
        initEvents(response.exam_room, response.exam_name, response.exam_id);
      }
    }
  }

  console.log("sending to " + url);

  http.open(method, url);
  http.send(data);
}

function initEvents(examRoom, examName, examID) {
  asexam.addEventListener("click", e => {
    var row = asexam.parentElement.parentElement.cells;

    var data = 'date=' + row[1].innerHTML + "\n" +
                  'doctor_id=' + id + "\n" +
                  'patient_id=' + row[0].innerHTML+ "\n" +
                  'exam_room=' + examRoom+ "\n" +
                  'exam_name=' + examName+ "\n" +
                  'type=assign';

    asexam.innerHTML = "<i class='fas fa-check'></i></i>Assign Exam";
    console.log(data);

    assignExam('POST','/Project/ExamServlet',data);

  });

  presc.addEventListener("click", e => {
    var row = presc.parentElement.parentElement.cells;

    var data = 'date=' + row[1].innerHTML + "\n" +
                  'doctor_id=' + id + "\n" +
                  'exam_id=' + examID + "\n" +
                  'type=prescribe';

    console.log(data);

    presc.innerHTML = "<i class='fas fa-check'></i></i>Prescribe";
    prescribeMed('POST','/Project/ExamServlet',data);

  });

  doneEvents = true;
}

function assignExam(method,url,data) {
  var http = new XMLHttpRequest();

  http.onload = function () {
      console.log(http.response);

  }

  http.open(method,url);
  http.send(data);
}

function prescribeMed(method,url,data) {
  var http = new XMLHttpRequest();

  http.onload = function () {
      if(http.status == 200) {
        console.log(http.response);

      }
  }

  http.open(method,url);
  http.send(data);
}
