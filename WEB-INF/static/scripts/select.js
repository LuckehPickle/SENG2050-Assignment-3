var icons = {
  OPEN: '&#xE5C5;',
  CLOSE: '&#xE5C7;'
};

var getValueAsString = function (select) {

  var value = select.value;

  // Ensure value is not empty
  if (value === "") {
    return value;
  }

  // Iterate over children
  for (var option in select.children) {
    if (option.value === value) {
      return option.innerText;
    }
  }

  return "";

};

/**
 * Creates a new option for a custom select element.
 * @param option Option to build from.
 */
var generateOption = function (option) {

  var element = document.createElement("li");
  element.classList.add("select-option");
  element.setAttribute("data-value", option.value);
  element.innerText = option.innerText;

  // Add selected attribute
  if (option.hasAttribute("selected")) {
    element.set("data-selected", "true");
  }

  return element;

};


/**
 * Creates a new select button wrapper.
 * @param select Original select element.
 */
var generateWrapper = function (select) {

  // Create wrapper
  var wrapper = document.createElement("div");
  wrapper.classList.add("select-wrapper");

  // Create select button
  var button = document.createElement("div");
  button.classList.add("select-button");
  button.innerHTML = "<span>" + getValueAsString(select)
      + "</span><i class=\"material-icons\">&#xE5C5;</i>";
  wrapper.appendChild(button);

  // Create dropdown
  var dropdown = document.createElement("ul");
  dropdown.classList.add("select-options");

  // Create options
  select.querySelectorAll("option").forEach(function (child) {
    dropdown.append(generateOption(child));
  });

  wrapper.appendChild(dropdown);

  return wrapper;

};


var initSelect = function (select) {

  var parent = select.parentNode;
  var wrapper = generateWrapper(select);

  // Set wrapper as parent element
  parent.replaceChild(wrapper, select);
  wrapper.appendChild(select);

};

/**
 * Toggles the state of the given wrapper.
 */
var toggleWrapper = function (wrapper) {

  if (wrapper.classList.contains("open")) {
    wrapper.classList.remove("open");
    wrapper.querySelector(".select-button i.material-icons").innerHTML = icons.OPEN;
  } else {
    wrapper.classList.add("open");
    wrapper.querySelector(".select-button i.material-icons").innerHTML = icons.CLOSE;
  }

};


var closeAllSelects = function () {
  var selects = document.querySelectorAll(".select-wrapper.open");
  selects.forEach(function (select) {
    toggleWrapper(select)
  });
};


/**
 * A delegated event that handles select button clicks.
 */
var selectButtonClickHandler = function (button) {
  toggleWrapper(button.parentNode);
};


/**
 * A delegated event that handle select option clicks.
 */
var selectOptionClickHandler = function (option) {

  // Update button
  var button = option.parentNode.previousElementSibling;
  var wrapper = button.parentNode;

  button.querySelector("span").innerText = option.innerText;
  closeAllSelects();

  // Update select input
  var select = wrapper.querySelector("select");
  select.value = option.getAttribute("data-value");

  // Fire event
  select.dispatchEvent(new Event("change", { bubbles: true }));

};

/**
 * Handles all document clicks. Define delegated event listeners here.
 */
var delegatedClickHandler = function (event) {

  var target = event.target;

  // Find parent
  while (true) {

    if (target.classList.contains("select-button")) {
      selectButtonClickHandler(target);
      return;
    }

    if (target.classList.contains("select-option")) {
      selectOptionClickHandler(target);
      return;
    }

    // Make sure we don't reach the body
    if (matches(target, "body")) {
      closeAllSelects();
      return;
    }

    // Try the element above
    target = target.parentNode;

  }

};



function ready(fn) {
  if (document.attachEvent ? document.readyState === "complete" : document.readyState !== "loading"){
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
}



ready(function () {
  var selects = document.querySelectorAll("select");
  selects.forEach(initSelect);
});

document.addEventListener("click", delegatedClickHandler);