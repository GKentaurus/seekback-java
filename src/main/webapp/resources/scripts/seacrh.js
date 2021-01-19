$(document).ready(function() {


    $("#seacrh").click(function() {
        var sea = $('#searxh').val();
        window.location.assign('searchproduct.xhtml?pr=' + sea)
    });


    $("#searxh").keypress(function(e) {
        var keycode = (e.keyCode ? e.keyCode : e.which);
        if (keycode == 13) {
            var sea = $('#searxh').val();
            window.location.assign('searchproduct.xhtml?pr=' + sea)
        }
    });

});