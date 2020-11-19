

$(document).ready(function () {
  $('.modal').modal();
});

$(document).ready(function () {
  var counter = 0;

  $("#addrow").on("click", function () {
    var newRow = $("<tr>");
    var cols = "";

    cols += '<td><input type="text" class="form-control" name="Referencia' + counter + '"/></td>';
    cols += '<td><input type="number" class="form-control" name="Cantidad' + counter + '"/></td>';
    cols += '<td><input type="number" class="form-control" name="Costo' + counter + '"/></td>';

    cols += '<td><a class="ibtnDel waves-effect waves-light btn red col s12">Eliminar</a></td>';
    newRow.append(cols);
    $("table.responsive-table").append(newRow);
    counter++;
  });



  $("table.responsive-table").on("click", ".ibtnDel", function (event) {
    $(this).closest("tr").remove();
    counter -= 1
  });


});
ç


