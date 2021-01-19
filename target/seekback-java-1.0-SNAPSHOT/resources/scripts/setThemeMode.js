$(document).ready(function() {

    $('.sidenav').sidenav();

    $(".dropdown-trigger").dropdown();

    $('.slider').slider();

    $('.slider').hover(function() {
        $(this).slider('pause')
    }, function() {
        $(this).slider('start')
    });
    $('.modal').modal();
    $('select').formSelect();
    $('.tabs').tabs();
    $('.sidenav').sidenav();

    $('.scrollspy').scrollSpy();


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
        $("#ody").addClass("dark-mode");
        $("#inv").addClass("wrapmoddark");
        $(".card").removeClass("white");
        $(".card").addClass("black");
        $(".division").removeClass("white");
        $(".division").addClass("black");
        $(".ingr").addClass("white-text");
        $(".ingr").removeClass("black-text");

        /* login */
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

    }

    $("#drkmode").click(function() {

        $("#ody").toggleClass("dark-mode");

        if ($("#ody").hasClass("dark-mode") == true) {

            /* tipos producto */
            $("#inv").addClass("wrapmoddark");
            $(".card").addClass("black");
            $(".card").removeClass("white");
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
            $(".division").removeClass("white");
            $(".division").addClass("black");
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

            localStorage.setItem("preferredmode", "dark");
        } else {

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
            $(".division").removeClass("black");
            $(".division").addClass("white");
            $(".ingr").removeClass("white-text");
            $(".ingr").addClass("black-text");

            /* login */
            $(".modal").addClass("white");
            $(".modal").removeClass("black");
            $(".modal-footer").addClass("darken-3");
            $(".modal-footer").removeClass("darken-4");
            $(".ingre").css("color", "#222");
            $(".select-dropdown").css("color", "#222");
            $(".collection-item").addClass("white");
            $(".collection-item").removeClass("black");

            localStorage.setItem("preferredmode", "normal");
        }

    });

    /* login */
    $('#modal2').modal({
        onCloseEnd: function() {
            window.location.replace('login.html');
        }
    });

    function namesa() {
        var fname = document.getElementById('fname').value;
        var nameee = document.getElementById('nameee');

        nameee.innerHTML = fname;

    }


    // verificacion de password
    function passwo() {
        var pass = document.getElementById("fcontra").value;
        var passa = document.getElementById("scontra").value;
        var ing = document.getElementById("ing");
        var lpass = document.getElementById("lpass");
        var Mpass = document.getElementById("Mpass");
        var Cpass = document.getElementById("Cpass");
        var Npass = document.getElementById("Npass");
        var Ipass = document.getElementById("Ipass");
        var i = 0;

        if (pass.length < 8) {
            lpass.innerHTML = "close";
            lpass.className = lpass.className.replace("green-text", "red-text");
            i = i + 0;
        } else {
            lpass.innerHTML = "check";
            lpass.className = lpass.className.replace("red-text", "green-text");
            i = i + 20;
        }

        var formatc = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
        if (formatc.test(pass)) {
            Cpass.innerHTML = "check";
            Cpass.className = Cpass.className.replace("red-text", "green-text");
            i = i + 20;
        } else {
            Cpass.innerHTML = "close";
            Cpass.className = Cpass.className.replace("green-text", "red-text");
            i = i + 0;
        }

        var formatn = /[0-9]/;
        if (formatn.test(pass)) {
            Npass.innerHTML = "check";
            Npass.className = Npass.className.replace("red-text", "green-text");
            i = i + 20;
        } else {
            Npass.innerHTML = "close";
            Npass.className = Npass.className.replace("green-text", "red-text");
            i = i + 0;
        }

        var formatm = /[A-Z]/;
        if (formatm.test(pass)) {
            Mpass.innerHTML = "check";
            Mpass.className = Mpass.className.replace("red-text", "green-text");
            i = i + 20;
        } else {
            Mpass.innerHTML = "close";
            Mpass.className = Mpass.className.replace("green-text", "red-text");
            i = i + 0;
        }

        if (pass == passa && pass != "") {
            Ipass.innerHTML = "check";
            Ipass.className = Ipass.className.replace("red-text", "green-text");
            i = i + 20;
        } else {
            Ipass.innerHTML = "close";
            Ipass.className = Ipass.className.replace("green-text", "red-text");
            i = i + 0;
        }

        document.getElementById("bar").style.width = i + "%";

        if (i == 100) {
            document.getElementById("ing").className = ing.className.replace("disabled", "enabled modal-trigger");
        } else {
            document.getElementById("ing").className = ing.className.replace("enabled modal-trigger", "disabled");
        }

    }

});