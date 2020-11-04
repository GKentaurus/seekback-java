$(document).ready(function() {

  $('.sidenav').sidenav();

  $(".dropdown-trigger").dropdown();
  

  if (localStorage.getItem("preferredmode") == "dark") {

    $("#ody").addClass("dark-mode");
    $("#inv").addClass("wrapmoddark");
    $(".card").addClass("black");
    $(".card").removeClass("white");
    $("#bread").addClass("darken-1");
    $("#bread").removeClass("darken-4");

  }

  $("#drkmode").click(function() {

    $("#ody").toggleClass("dark-mode");

    if ($("#ody").hasClass("dark-mode") == true) {

      $("#inv").addClass("wrapmoddark");
      $(".card").addClass("black");
      $(".card").removeClass("white");
      $("#bread").addClass("darken-4");
      $("#bread").removeClass("darken-1");

      localStorage.setItem("preferredmode", "dark");
    } else {

      $("#inv").removeClass("wrapmoddark");
      $(".card").addClass("white");
      $(".card").removeClass("black");
      $("#bread").addClass("darken-1");
      $("#bread").removeClass("darken-4");

      localStorage.setItem("preferredmode", "normal");
    }

  });


});

// function setThemeMode() {
//   var x = localStorage.getItem("preferredmode");
//   var wrap = document.getElementById("inv").className;
//   var cards = document.getElementsByClassName("card");
//   var bread = document.getElementById("bread").className;

//   if (x == "dark") {
//     document.body.className += " dark-mode";
//     document.getElementById("inv").className = wrap.replace("wrap", "wrap wrapmoddark");

//     for (let i = 0; i < cards.length; i++) {
//       cards[i].className = cards[i].className.replace("white", "black");
//     }

//     document.getElementById("bread").className = bread.replace("grey darken-1", "grey darken-4");

//   }
// }

// function changecodetheme() {
//   var cc = document.body.className;
//   var elements = document.getElementById("inv").className;
//   var cards = document.getElementsByClassName("card");
//   var bread = document.getElementById("bread").className;

//   if (cc.indexOf("dark-mode") > -1) {
//     document.body.className = cc.replace("dark-mode", " ");

//     document.getElementById("inv").className = elements.replace("wrapmoddark", "");

//     for (let i = 0; i < cards.length; i++) {
//       cards[i].className = cards[i].className.replace("black", "white");
//     }

//     document.getElementById("bread").className = bread.replace("grey darken-4", "grey darken-1");

//     localStorage.setItem("preferredmode", "normal");
//   } else {
//     document.body.className += " dark-mode";

//     document.getElementById("inv").className += " wrapmoddark";

//     for (let i = 0; i < cards.length; i++) {
//       cards[i].className = cards[i].className.replace("white", "black");
//     }

//     document.getElementById("bread").className = bread.replace("grey darken-1", "grey darken-4");

//     localStorage.setItem("preferredmode", "dark");
//   }

// }