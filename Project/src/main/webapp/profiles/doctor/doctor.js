const submit = document.getElementById("submit");
const pat_id = document.getElementById("patient");

submit.addEventListener("click", e => {
  if(pat_id.value != undefined && pat_id.value != "") {
    communicateWithServlet('GET','/Servlet/Profile?');
  }
});

function communicateWithServlet(method, url) {
  var http = new XMLHttpRequest();

  http.onload = function() {
    !// TODO: 
    console.log("HELLO");
  };

  http.open(method, url);
  http.send();
}
