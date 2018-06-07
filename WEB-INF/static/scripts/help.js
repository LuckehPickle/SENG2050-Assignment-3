
function add(event) {
  var request = new XMLHttpRequest();
  var id = event.target.getAttribute("data-article-id");
  request.open('POST', '/articles/'+id, true);

  request.onload = function() {
    if (request.status >= 200 && request.status < 400) {
      // Success!
      document.getElementById("helpButton").disabled = true;
      var value = parseInt(document.getElementById("help").value);
      value++;
      document.getElementById("help").value = value;
    } else {

    }
  };

  request.onerror = function() {
    // There was a connection error of some sort
  };

  request.send();
}

function ready(fn) {
  if (document.attachEvent ? document.readyState === "complete" : document.readyState !== "loading"){
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
}

ready(function(){
  var button = document.querySelector(".js-help");
  button.addEventListener("click",add);
});

