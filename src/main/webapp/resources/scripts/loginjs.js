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

  $('#modal2').modal({
    onCloseEnd: function () {
      window.location.replace('login.html');
    }
  });

});


function login() {
  var emaillog = document.getElementById("emaillog").value;
  var passwordlog = document.getElementById("passwordlog").value;

  var data = emaillog + '/' + passwordlog;

  var cliente = 'cliente@cliente.com/123456';
  var empleado = 'empleado@empleado.com/123456';
  var admin = 'admin@admin.com/123456';



  if (data === cliente) {
    window.location.replace('../frames/cliente.html');
  } else if (data === empleado) {
    window.location.replace('../frames/empleado.html');
  } else if (data === admin) {
    window.location.replace('../frames/admin.html');
  } else if (data === '/') {
    M.toast({html: 'datos invalidos'});
  } else {
    M.toast({html: 'Usuario no esta registrado'});
  }

}

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


// cambio de pais
function paiss() {
  var pais = document.getElementById("pais");
  var opais = document.getElementById("opais");
  var oubi = document.getElementById("oubi");
  var paiss = document.getElementById("paiss").className;
  if (pais.value == "Otro") {
    opais.style.display = "inherit";

    document.getElementById("paiss").className = paiss.replace("s12", "s2");
    oubi.value = ("");
  } else {

    opais.style.display = "none";

    document.getElementById("paiss").className = paiss.replace("s2", "s12");
    oubi.value = ("");
  }
}