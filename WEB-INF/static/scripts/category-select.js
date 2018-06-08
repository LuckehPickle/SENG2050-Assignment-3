function ready(fn) {
  if (document.attachEvent ? document.readyState === "complete" : document.readyState !== "loading"){
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
}


function selectChangeHandler(event) {

  var select = event.target;
  var subcategories = document.querySelectorAll(".subcategory-wrapper .select-wrapper");

  // Hide all subcategories
  subcategories.forEach(function (cat) {
    cat.style.display = 'none';
  });

  switch (select.value) {

  }

}

ready(function () {

  var subcategories = document.querySelectorAll(".subcategory-wrapper .select-wrapper");
  var categorySelect = document.querySelector("#issue-category");

  // Hide all subcategories
  subcategories.forEach(function (select) {
    select.style.display = 'none';
  });

  // Ensure category select exists
  if (categorySelect != null) {
    return;
  }

  categorySelect.addEventListener("change", selectChangeHandler);

});
