$(document).ready(function () {
  $('.sidenav').sidenav();
  $(".dropdown-trigger").dropdown();
  $('.modal').modal();
  $('.tooltipped').tooltip();



  if (localStorage.getItem("preferredmode") == "dark") {

    $("#ody").addClass("dark-mode");
    $("#inv").addClass("wrapmoddark");
    $(".card").removeClass("lighten-4");
    $(".card").addClass("darken-4");
    $(".card-content").removeClass("black-text");
    $(".card-content").addClass("white-text");
    $(".modal-content").removeClass("lighten-4");
    $(".modal-content").addClass("darken-4");

  }

  $("#drkmode").click(function () {

    $("#ody").toggleClass("dark-mode");

    if ($("#ody").hasClass("dark-mode") == true) {
      $("#inv").addClass("wrapmoddark");
      $(".card").removeClass("lighten-4");
      $(".card").addClass("darken-4");
      $(".card-content").removeClass("black-text");
      $(".card-content").addClass("white-text");
      $(".modal-content").removeClass("lighten-4");
      $(".modal-content").addClass("darken-4");
      localStorage.setItem("preferredmode", "dark");
    } else {
      $("#inv").removeClass("wrapmoddark");
      $(".card").removeClass("darken-4");
      $(".card").addClass("lighten-4");
      $(".card-content").removeClass("white-text");
      $(".card-content").addClass("black-text");
      $(".modal-content").removeClass("darken-4");
      $(".modal-content").addClass("lighten-4");
      localStorage.setItem("preferredmode", "normal");
    }

  });
});