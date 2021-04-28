$(document).ready(function () {
  $('.modal').modal();
  $('select').formSelect();
  $('.tabs').tabs();
  $('.sidenav').sidenav();
  $(".dropdown-trigger").dropdown();



  if (localStorage.getItem("preferredmode") == "dark") {

    $("#ody").addClass("dark-mode");
    $("#inv").addClass("wrapmoddark");
    $(".modal").addClass("black");
    $(".modal").removeClass("white");
    $(".modal-footer").addClass("darken-4");
    $(".modal-footer").removeClass("darken-3");
    $(".ingre").css("color", "white");
    $(".select-dropdown").css("color", "white");
    $(".collection-item").addClass("black");
    $(".collection-item").removeClass("white");
    $(".registrer").addClass("black");
    $(".registrer").removeClass("white");

  }

  $("#drkmode").click(function () {

    $("#ody").toggleClass("dark-mode");

    if ($("#ody").hasClass("dark-mode") == true) {

      $("#inv").addClass("wrapmoddark");
      $(".modal").addClass("black");
      $(".modal").removeClass("white");
      $(".modal-footer").addClass("darken-4");
      $(".modal-footer").removeClass("darken-3");
      $(".ingre").css("color", "white");
      $(".select-dropdown").css("color", "white");
      $(".collection-item").addClass("black");
      $(".collection-item").removeClass("white");
      $(".registrer").addClass("black");
      $(".registrer").removeClass("white");

      localStorage.setItem("preferredmode", "dark");
    } else {

      $("#inv").removeClass("wrapmoddark");
      $(".modal").addClass("white");
      $(".modal").removeClass("black");
      $(".modal-footer").addClass("darken-3");
      $(".modal-footer").removeClass("darken-4");
      $(".ingre").css("color", "#222");
      $(".select-dropdown").css("color", "#222");
      $(".collection-item").addClass("white");
      $(".collection-item").removeClass("black");
      $(".registrer").addClass("white");
      $(".registrer").removeClass("black");

      localStorage.setItem("preferredmode", "normal");
    }

  });

});
