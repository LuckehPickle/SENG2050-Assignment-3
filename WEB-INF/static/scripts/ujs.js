/*
 * Unobtrusive JavaScript
 * Inspired by the Rails Unobtrusive Scripting Adapter.
 * @author Sean Bailey
 */


var VALID_METHODS = ["GET", "HEAD", "POST", "PUT", "DELETE", "CONNECT", "OPTIONS", "TRACE", "PATCH"];


/**
 * Determines whether the given element matches a selector. For IE9+
 * @param el Element to test.
 * @param selector Selector to compare against.
 * @returns {boolean | *} Whether the selector matches the element.
 */
function matches (el, selector) {
  return (el.matches || el.matchesSelector || el.msMatchesSelector || el.mozMatchesSelector || el.webkitMatchesSelector || el.oMatchesSelector).call(el, selector);
}


/**
 * Calls the given function only once the DOM is ready.
 * @param func Function to call when DOM is ready.
 */
function ready (func) {
  if (document.attachEvent ? document.readyState === "complete" : document.readyState !== "loading") {
    func();
  } else {
    document.addEventListener('DOMContentLoaded', func);
  }
}


/**
 * An event handler that is fired whenever something is clicked on the DOM.
 * This handler looks at the click event, and decides whether to fire a more
 * specific event listener, such as one only on links.
 * @param event Click event.
 */
function delegatedClickHandler (event) {

  var target = event.target;

  // Bubble up the DOM until we reach the body
  do {

    // Handle links
    if (matches(target, "a")) {
      linkClickHandler(target, event);
      return;
    }

    // Move up one element
    target = target.parentNode;

  } while (!matches(target, "body"));

}


/**
 * Handles a click event on a link.
 * @param link Link that was clicked.
 * @param event Click event.
 */
function linkClickHandler (link, event) {

  // Look for method links
  if (link.hasAttribute("data-method")) {
    event.preventDefault();
    handleLinkWithMethod(link);
    return;
  }

}


/**
 * Sends the user to the given page, but via a particular HTTP method. This
 * allows the web app to be more RESTful.
 * @param link Link with method.
 */
function handleLinkWithMethod (link) {

  // Get method
  var method = link.getAttribute("data-method");
  var action = link.getAttribute("href");
  var params = JSON.parse(link.getAttribute("data-params"));

  // Validate method
  if (VALID_METHODS.indexOf(method.toUpperCase()) === -1) {
    console.error("Unknown HTTP method: '" + method + "'.");
    return;
  }

  // Validate action
  if (action === null) {
    console.error("No href was provided.");
    return;
  }

  // Create form
  var form = document.createElement("form");
  form.setAttribute("method", method);
  form.setAttribute("action", action);
  form.classList.add("hidden-form");

  // Deal with params
  for (var key in params) {

    // Create hidden field
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", key);
    hiddenField.setAttribute("value", params[key]);
    form.appendChild(hiddenField);

  }

  document.body.appendChild(form);
  form.submit();

}


// Register event listeners
document.addEventListener("click", delegatedClickHandler);