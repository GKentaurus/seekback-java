$(document).ready(function() {
  $('.sidenav').sidenav();
  $(".dropdown-trigger").dropdown();
  $('.collapsible').collapsible({
    draggable: true
  });
  $('.sidenav').sidenav();
  

  if (localStorage.getItem("preferredmode") == "dark") {

    $("#ody").addClass("dark-mode");
    $("#inv").addClass("wrapmoddark");

  }

  $("#drkmode").click(function() {

    $("#ody").toggleClass("dark-mode");

    if ($("#ody").hasClass("dark-mode") == true) {
      $("#inv").addClass("wrapmoddark");
      localStorage.setItem("preferredmode", "dark");
    } else {
      $("#inv").removeClass("wrapmoddark");
      $(".card").removeClass("darken-4");
      localStorage.setItem("preferredmode", "normal");
    }

  });
  
  
});