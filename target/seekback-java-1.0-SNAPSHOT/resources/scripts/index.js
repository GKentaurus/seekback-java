$(document).ready(function() {
    $('.sidenav').sidenav();

    $(".dropdown-trigger").dropdown();

    $('.slider').slider();

    $('.slider').hover(function() {
        $(this).slider('pause')
    }, function() {
        $(this).slider('start')
    });

    $('.scrollspy').scrollSpy();

    $("#drkmode").click(function() {

        $("#ody").toggleClass("dark-mode");

        if ($("#ody").hasClass("dark-mode") == true) {
            $("#inv").addClass("wrapmoddark");
            $(".card").removeClass("white");
            $(".card").addClass("black");
            $(".division").removeClass("white");
            $(".division").addClass("black");
            $(".ingr").addClass("white-text");
            $(".ingr").removeClass("black-text");
            localStorage.setItem("preferredmode", "dark");
        } else {
            $("#inv").removeClass("wrapmoddark");
            $(".card").removeClass("black");
            $(".card").addClass("white");
            $(".division").removeClass("black");
            $(".division").addClass("white");
            $(".ingr").removeClass("white-text");
            $(".ingr").addClass("black-text");
            localStorage.setItem("preferredmode", "normal");
        }

    });

    if (localStorage.getItem("preferredmode") == "dark") {

        $("#ody").addClass("dark-mode");
        $("#inv").addClass("wrapmoddark");
        $(".card").removeClass("white");
        $(".card").addClass("black");
        $(".division").removeClass("white");
        $(".division").addClass("black");
        $(".ingr").addClass("white-text");
        $(".ingr").removeClass("black-text");

    }

});