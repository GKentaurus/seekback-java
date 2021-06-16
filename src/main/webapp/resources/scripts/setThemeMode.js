$(document).ready(function () {

  $('.sidenav').sidenav();
  $(".dropdown-trigger").dropdown();
  $('.slider').slider();
  $('.slider').hover(function () {
    $(this).slider('pause')
  }, function () {
    $(this).slider('start')
  });
  $('.modal').modal();
  $('select').formSelect();
  $('.tabs').tabs();
  $('.scrollspy').scrollSpy();
  $('.collapsible').collapsible({
    draggable: true
  });


  if (localStorage.getItem("preferredmode") == "dark") {

    /* tipos producto */
    $("#ody").addClass("dark-mode");
    $("#inv").addClass("wrapmoddark");
    $(".card").addClass("black");
    $(".card").removeClass("white");
    $("#bread").addClass("darken-1");
    $("#bread").removeClass("darken-4");
    $("#namet").addClass("white-text");
    $("#bsea").addClass("white-text");
    $(".filtable").addClass("white-text");
    $(".dataTables_empty").addClass("white-text");
    $(".childesc").addClass("white-text");

    /* index */
    $(".card").addClass("black");
    $(".card").removeClass("white");
    $(".division").addClass("black");
    $(".division").removeClass("white");
    $(".ingr").addClass("white-text");
    $(".ingr").removeClass("black-text");

    /* login */
    $(".modal").addClass("black");
    $(".modal").removeClass("white");
    $(".modal-footer").addClass("darken-4");
    $(".modal-footer").removeClass("darken-3");
    $(".ingre").css("color", "white");
    $(".select-dropdown").css("color", "white");
    $(".collection-item").addClass("black");
    $(".collection-item").removeClass("white");

  }



  $("#drkmode").click(function () {


    if ($("#ody").hasClass("dark-mode") == true) {

      /* tipos producto */
      $("#ody").addClass("dark-mode");
      $("#inv").addClass("wrapmoddark");
      $(".card").addClass("black");
      $(".card").removeClass("white");
      $("#bread").addClass("darken-1");
      $("#bread").removeClass("darken-4");
      $("#namet").addClass("white-text");
      $("#bsea").addClass("white-text");
      $(".filtable").addClass("white-text");
      $(".dataTables_empty").addClass("white-text");
      $(".childesc").addClass("white-text");

      /* index */
      $("#inv").addClass("wrapmoddark");
      $(".division").removeClass("white");
      $(".division").addClass("black");
      $(".ingr").addClass("white-text");
      $(".ingr").removeClass("black-text");

      /* tipos producto */
      $("#bread").addClass("darken-4");
      $("#bread").removeClass("darken-1");
      $("#namet").addClass("white-text");
      $("#namet").removeClass("black-text");
      $("#bsea").addClass("white-text");
      $("#bsea").removeClass("black-text");
      $(".filtable").removeClass("black-text");
      $(".filtable").addClass("white-text");
      $(".dataTables_empty").removeClass("black-text");
      $(".dataTables_empty").addClass("white-text");
      $(".childesc").removeClass("black-text");
      $(".childesc").addClass("white-text");

      /* index */
      $(".division").addClass("black");
      $(".division").removeClass("white");
      $(".ingr").addClass("white-text");
      $(".ingr").removeClass("black-text");

      /* login */
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

      $("#ody").removeClass("dark-mode");
      /* tipos producto */
      $("#inv").removeClass("wrapmoddark");
      $(".card").addClass("white");
      $(".card").removeClass("black");
      $("#bread").addClass("darken-1");
      $("#bread").removeClass("darken-4");
      $("#namet").addClass("black-text");
      $("#namet").removeClass("white-text");
      $("#bsea").addClass("black-text");
      $("#bsea").removeClass("white-text");
      $(".filtable").addClass("black-text");
      $(".filtable").removeClass("white-text");
      $(".dataTables_empty").addClass("black-text");
      $(".dataTables_empty").removeClass("white-text");
      $(".childesc").addClass("black-text");
      $(".childesc").removeClass("white-text");

      /* index */
      $(".division").addClass("white");
      $(".division").removeClass("black");
      $(".ingr").addClass("black-text");
      $(".ingr").removeClass("white-text");

      /* login */
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