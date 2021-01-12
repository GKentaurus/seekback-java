$(document).ready(function () {

  $('.sidenav').sidenav();

  $(".dropdown-trigger").dropdown();


  if (localStorage.getItem("preferredmode") == "dark") {

    $("#ody").addClass("dark-mode");
    $("#inv").addClass("wrapmoddark");
    $(".card").addClass("black");
    $(".card").removeClass("white");
    $("#bread").addClass("darken-1");
    $("#bread").removeClass("darken-4");
    $("#namet").addClass("white-text");
    $("#bsea").addClass("white-text");
    $(".input-sm").removeClass("black-text");
    $(".input-sm").addClass("white-text");

  }

  $("#drkmode").click(function () {

    $("#ody").toggleClass("dark-mode");

    if ($("#ody").hasClass("dark-mode") == true) {

      $("#inv").addClass("wrapmoddark");
      $(".card").addClass("black");
      $(".card").removeClass("white");
      $("#bread").addClass("darken-4");
      $("#bread").removeClass("darken-1");
      $("#namet").addClass("white-text");
      $("#namet").removeClass("black-text");
      $("#bsea").addClass("white-text");
      $("#bsea").removeClass("black-text");
      $(".input-sm").removeClass("black-text");
      $(".input-sm").addClass("white-text");

      localStorage.setItem("preferredmode", "dark");
    } else {

      $("#inv").removeClass("wrapmoddark");
      $(".card").addClass("white");
      $(".card").removeClass("black");
      $("#bread").addClass("darken-1");
      $("#bread").removeClass("darken-4");
      $("#namet").addClass("black-text");
      $("#namet").removeClass("white-text");
      $("#bsea").addClass("black-text");
      $("#bsea").removeClass("white-text");
      $(".input-sm").addClass("black-text");
      $(".input-sm").removeClass("white-text");

      localStorage.setItem("preferredmode", "normal");
    }

  });


});