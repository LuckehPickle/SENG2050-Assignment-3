function ready(fn) {
  if (document.attachEvent ? document.readyState === "complete" : document.readyState !== "loading"){
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
}


function selectChangeHandler(event) {

  var select = event.detail.select;

  if (!select.classList.contains("category-select")) {
    return;
  }

  var wrapper = document.querySelector(".subcategory-wrapper");
  var subcategories = wrapper.querySelectorAll(".select-wrapper");

  // Hide all subcategories
  subcategories.forEach(function (cat) {
    cat.style.display = 'none';
  });

  wrapper.style.display = "none";

  var selector;
  switch (select.value) {
    case "NETWORK":
      selector = "#issue-subcategory.network";
      break;
    case "SOFTWARE":
      selector = "#issue-subcategory.software";
      break;
    case "HARDWARE":
      selector = "#issue-subcategory.hardware";
      break;
    case "EMAIL":
      selector = "#issue-subcategory.email";
      break;
    case "ACCOUNT":
      selector = "#issue-subcategory.account";
      break;
    default:
      return;
  }

  var selectWrapper = document.querySelector(selector).parentNode;
  selectWrapper.style.display = 'block';
  wrapper.style.display = "block";

}

function submitHandler(event) {
  var form = event.target;
  console.log(form);
  var selects = form.querySelectorAll(".select-wrapper");
  selects.forEach(function (select) {
    if (select.style.display === "none") {
      select.parentNode.removeChild(select);
      console.log("Removing element");
    }
  });
};

ready(function () {

  var subcategories = document.querySelectorAll(".subcategory-wrapper .select-wrapper");
  var categorySelect = document.querySelector("#issue-category");

  // Hide all subcategories
  subcategories.forEach(function (select) {
    select.style.display = 'none';
  });

  // Ensure category select exists
  if (categorySelect == null) {
    return;
  }

  var form = document.querySelector("form.issue-form");
  form.addEventListener("submit", submitHandler);

});

document.addEventListener("select:change", selectChangeHandler);