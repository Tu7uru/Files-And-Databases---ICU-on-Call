const typespec = document.getElementById("type");
const docspec = document.getElementById("doc-spec");
const nursespec = document.getElementById("nurse-spec");
const emplspec = document.getElementById("empl-spec");
const patspec = document.getElementById("patient-fields");


console.log("HELLO!");
type.addEventListener("change", e => {

  var value = typespec.value;
  if(value == "doc") {
    docspec.className = "doc-spec success";
    console.log(docspec.className);
  } else if(value == "nurse") {
    nursespec.className = "nurse-spec success";
  } else if(value == "empl") {
    emplspec.className = "empl-spec success";
  } else if(value == "pat"){
    patspec.className = "patient-fields success";
  } else {
    docspec.className = "doc-spec";
    nursespec.className = "nurse-spec";
    emplspec.className = "empl-spec";
    patspec.className = "patient-fields";
  }
});
