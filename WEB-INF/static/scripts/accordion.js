function ready(fn) {
  if (document.attachEvent ? document.readyState === "complete"
      : document.readyState !== "loading") {
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
}

ready(function () {
  var dropdowns = document.querySelectorAll(".accordion-dropdown");

  dropdowns.forEach(function (dropdown) {
    dropdown.addEventListener("click", function (event) {

      var target = event.target;

      while (!target.classList.contains("accordion-dropdown")) {
        target = target.parentNode;

        if (target === document.body) {
          return;
        }
      }

      var openedAccordions = document.querySelectorAll(".accordion .open");
      openedAccordions.forEach(function (openAccordion) {
        openAccordion.classList.toggle("open");
      });

      target.parentNode.parentNode.classList.toggle("open");
    })
  })
});