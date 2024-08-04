<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inscripciones</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script type="text/javascript">

document.addEventListener("DOMContentLoaded", function() {
    // Obtener el elemento input por su ID
    const fechainicio = document.getElementById("startDate");
    const fechafin = document.getElementById("endDate");
    // Obtener la fecha actual en el formato YYYY-MM-DD
    const fechaActual = new Date().toISOString().split("T")[0];
    // Asignar la fecha actual al atributo value del input
    fechainicio.value = fechaActual;
    fechafin.value = fechaActual;
});

	function inscribir() {
	    var valoresSeleccionados = [];
	    $('.seleccionarEvento:checked').each(function () {
	        var id = $(this).data('id');
	        var nombre = $(this).closest('tr').find('td:eq(2)').text();
	        valoresSeleccionados.push({ id: id, nombre: nombre });
	    });
	    //console.log(valoresSeleccionados);
	    // Verificar si el array está vacío
	    if (valoresSeleccionados.length === 0) {
	        // si esta vacio
	        Swal.fire({
	            title: 'Advertencia',
	            text: 'No se ha seleccionado ningún elemento',
	            icon: 'warning',
	            confirmButtonText: 'OK'
	        });
	        return;
	    } 
	    $.ajax({
	        type: 'POST',
	        url: '/aso-web/ParticipacionesExposServlet', 
	        contentType: 'application/json',
	        data: JSON.stringify({ valores: valoresSeleccionados,'accion':'inscribir' }),
	        success: function (response) {
	            // La respuesta del servidor ha sido recibida correctamente
	            if (response.status === 'ok') {
	                Swal.fire({
	                    title: 'Éxito',
	                    text: ' procesado correctamente',
	                    icon: 'success',
	                    confirmButtonText: 'OK'
	                }).then(function () {
	                    $('#inscripcionModal').modal('hide');
	                 // Recorremos los valores actualizados y actualizamo los botones según el id
	                    $.each(response.valoresActualizados, function (index, elemento) {
	                    let idNuevoValor = elemento.id; 
	                    $('.seleccionarEvento:checked').each(function () {
	                    	if ($(this).data('id') === idNuevoValor) {
		                        $(this).closest('tr').find('.btn-success').hide();
		                        $(this).closest('tr').find('.btn-warning').show();
	                    	}
	                    });
	                    });
	                });
	            } else {
	                Swal.fire({
	                    title: 'Error',
	                    text: 'Error en el procesamiento del array',
	                    icon: 'error',
	                    confirmButtonText: 'OK'
	                }).then(function () {
	                    $('#inscripcionModal').modal('hide');
	                });
	            }
	        },
	        error: function (error) {
	            Swal.fire({
	                title: 'Error',
	                text: 'Error en la solicitud AJAX',
	                icon: 'error',
	                confirmButtonText: 'OK'
	            }).then(function () {
                    $('#inscripcionModal').modal('hide');
                });
	        }
	    });
	}

	function cancelar() {
	    var valoresSeleccionados = [];
	    $('.seleccionarEvento:checked').each(function () {
	        var id = $(this).data('id');
	        var nombre = $(this).closest('tr').find('td:eq(2)').text();
	        valoresSeleccionados.push({ id: id, nombre: nombre });
	    });
	    //console.log(valoresSeleccionados);
	    // Verificar si el array está vacío
	    if (valoresSeleccionados.length === 0) {
	        // si esta vacio
	        Swal.fire({
	            title: 'Advertencia',
	            text: 'No se ha seleccionado ningún elemento',
	            icon: 'warning',
	            confirmButtonText: 'OK'
	        });
	        return;
	    } 
	    $.ajax({
	        type: 'POST',
	        url: '/aso-web/ParticipacionesExposServlet', 
	        contentType: 'application/json',
	        data: JSON.stringify({ valores: valoresSeleccionados,'accion':'cancelar' }),
	        success: function (response) {
	            // La respuesta del servidor ha sido recibida correctamente
	            if (response.status === 'ok') {
	                Swal.fire({
	                    title: 'Éxito',
	                    text: ' procesado correctamente',
	                    icon: 'success',
	                    confirmButtonText: 'OK'
	                }).then(function () {
	                    $('#cancelacionModal').modal('hide');
	                 // Recorremos los valores actualizados y actualizamo los botones según el id
	                    $.each(response.valoresActualizados, function (index, elemento) {
	                    let idNuevoValor = elemento.id; 
	                    $('.seleccionarEvento:checked').each(function () {
	                    	if ($(this).data('id') === idNuevoValor) {
		                        $(this).closest('tr').find('.btn-success').show();
		                        $(this).closest('tr').find('.btn-warning').hide();
	                    	}
	                    });
	                    });
	                });
	            } else {
	                Swal.fire({
	                    title: 'Error',
	                    text: 'Error en el procesamiento del array',
	                    icon: 'error',
	                    confirmButtonText: 'OK'
	                }).then(function () {
	                    $('#cancelacionModal').modal('hide');
	                });
	            }
	        },
	        error: function (error) {
	            Swal.fire({
	                title: 'Error',
	                text: 'Error en la solicitud AJAX',
	                icon: 'error',
	                confirmButtonText: 'OK'
	            }).then(function () {
                    $('#cancelacionModal').modal('hide');
                });
	        }
	    });
	}
	
</script>
<link
	href="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.css"
	rel="stylesheet">
</head>

<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div>
			<h4>Filtrar Exposiciones por Fecha</h4>
			<form id="filterForm">
				<div class="mb-3">
					<label for="startDate" class="form-label">Fecha de Inicio:</label>
					<input type="date" class="form-control" id="startDate" required>
				</div>
				<div class="mb-3">
					<label for="endDate" class="form-label">Fecha de Fin:</label> <input
						type="date" class="form-control" id="endDate" required>
				</div>
				<button type="button" class="btn btn-primary"
					onclick="filterExhibitions()">Filtrar</button>
				<button type="button" class="btn btn-info"
					onclick="window.location.reload()">restaurar</button>
			</form>
		</div>
		<div>
			<h2>Listado de Exposiciones</h2>
			<table class="table" id="tabla_expos">
				<thead>
					<tr>
						<th title="Seleccionar"><input type="checkbox"
							id="seleccionarTodo"></th>
						<th scope="col">ID</th>
						<th scope="col">Nombre</th>
						<th scope="col">Descripcion</th>
						<th scope="col">Organiza</th>
						<th scope="col">Ubicacion</th>
						<th scope="col">Fecha</th>
						<th scope="col">Opciones</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<button type="button" class="btn btn-primary"
				id="btnEnviarSeleccionados" data-bs-toggle="modal"
				data-bs-target="#inscripcionModal">Inscribirse en
				Seleccionados</button>
			<button type="button" class="btn btn-warning"
				id="btnCancelarSeleccionados" data-bs-toggle="modal"
				data-bs-target="#cancelacionModal">Anular Seleccionados</button>

		</div>
		<div class="modal fade" id="inscripcionModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Inscripcion a Expo</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p id="parrafoTexto"></p>
						<p id="parrafoTexto2"></p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-success"
							onclick="inscribir();">Registrar</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="cancelacionModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Cancelar Inscripcion</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p id="parrafoTextoCancel"></p>
						<p id="parrafoTextoCancel2"></p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">No Deseo Cancelar</button>
						<button type="button" class="btn btn-success"
							onclick="cancelar();">Si, Deseo Cancelar la incripcion</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.datatables.net/v/dt/dt-1.13.7/datatables.min.js"></script>
	<script>
	const inscriptionModal = document.getElementById('inscripcionModal');
	if (inscriptionModal) {
	  inscriptionModal.addEventListener('show.bs.modal', event => {
	    const button = event.relatedTarget;
	    const idToInscript = button.getAttribute('data-bs-id');
	    const parrafoTexto = inscriptionModal.querySelector('#parrafoTexto');
		//document.getElementById("ID").value = idToInscript; 
	    parrafoTexto.textContent = `¿Está seguro de querer registrarse a la expo? ` 
	    parrafoTexto2.textContent = button.getAttribute('data-nombre') 
	  })
	}
	const cancelacionModal = document.getElementById('cancelacionModal');
	if (cancelacionModal) {
	  cancelacionModal.addEventListener('show.bs.modal', event => {
	    const button = event.relatedTarget;
	    const idToCancel = button.getAttribute('data-bs-id');
	    const parrafoTextoCancel = cancelacionModal.querySelector('#parrafoTextoCancel');
		//document.getElementById("ID").value = idToCancel; 
	    parrafoTextoCancel.textContent = `¿Está seguro de querer anular su registro a la expo? ` 
	    parrafoTextoCancel2.textContent = button.getAttribute('data-nombre') 
	  })
	}
</script>
	<script type="text/javascript">
	function marcarInput(x) {
	    //console.log(x);
	    var input = document.getElementById('checkbox_'+x);
	    if (input) {
	        input.checked = true;
	    }
	}
	
	function marcarOutput(x) {
	    //console.log(x);
	    var input = document.getElementById('checkbox_'+x);
	    if (input) {
	        input.checked = true;
	    }
	}

	$('#seleccionarTodo').on('change', function () {
	    $('.seleccionarEvento').prop('checked', $(this).prop('checked'));
	});

	$('#tabla_expos tbody').on('change', '.seleccionarEvento', function () {
	    if (!$(this).prop('checked')) {
	        $('#seleccionarTodo').prop('checked', false);
	    } else {
	        var todasMarcadas = $('.seleccionarEvento').length === $('.seleccionarEvento:checked').length;
	        $('#seleccionarTodo').prop('checked', todasMarcadas);
	    }
	});

		var tablaExpos;
		var columns = [
			 {
			        "title": '<input type="checkbox" id="seleccionarTodo">', 
			        "render": function (data, type, full, meta) {
			        	let activo = data.activo;
			        	let input = "";
			        	var checkboxId = 'checkbox_' + data.id;
			        	//if (activo === 0) {
			        	 input = '<input type="checkbox" class="seleccionarEvento" id="' + checkboxId + '" data-id="' + data.id + '">';
				        	
				       /* }else{
				         input = '<input type="checkbox" class="seleccionarEvento" checked id="' + checkboxId + '" data-id="' + data.id + '">';
					        }
				        */
			            return input;
			        },
			        "bSortable": false,
			        "bSearchable": false,
			        "data": null
			    },
				{
					"title" : "Id",
					"data" : "id"
				},
				{
					"title" : "Nombre",
					"data" : "nombre"
				},
				{
					"title" : "Descripcion",
					"data" : "descripcion"
				},
				{
					"title" : "Organiza",
					"data" : "organiza"
				},
				{
					"title" : "Ubicacion",
					"data" : "ubicacion"
				},
				{
					"title" : "Fecha",
					"data" : "fechaExpo"
				},
				{
					"title" : "Acciones",
					"render" : function(data, type, full, meta) {
					        // Mostrar u ocultar los botones según el valor de 'activo'
						 var activo = data.activo; 

					        var inscribirBtn = '<button type="button" class="btn btn-success mb-3" onclick="marcarInput(' + data.id + ');" data-bs-toggle="modal" data-bs-id="' + data.id + '" data-nombre="' + data.nombre + '" data-bs-target="#inscripcionModal">Inscribir</button>';
					        var anularBtn = '<button type="button" class="btn btn-warning mb-3" onclick="marcarOutput(' + data.id + ');" data-bs-toggle="modal" data-bs-id="' + data.id + '" data-nombre="' + data.nombre + '" data-bs-target="#cancelacionModal" style="display: none;">Anular Inscripcion</button>';

					        if (activo === 1) {
					            inscribirBtn = '<button type="button" class="btn btn-success mb-3" onclick="marcarInput(' + data.id + ');" data-bs-toggle="modal" data-bs-id="' + data.id + '" data-nombre="' + data.nombre + '" data-bs-target="#inscripcionModal" style="display: none;">Inscribir</button>';
					            anularBtn = '<button type="button" class="btn btn-warning mb-3" onclick="marcarOutput(' + data.id + ');" data-bs-toggle="modal" data-bs-id="' + data.id + '" data-nombre="' + data.nombre + '" data-bs-target="#cancelacionModal">Anular Inscripcion</button>';
					        }

					        return inscribirBtn + anularBtn;
					},
					"bSortable" : false,
					"bSearchable" : false,
					"data" : null
				}	 ];

		$(document)
				.ready(
						function() {
							tablaExpos = $('#tabla_expos')
									.DataTable(
											{
												"columns" : columns,
												"ajax" : {
													"url" : '/aso-web/ExposicionServlet?ACCION=LISTAR&FORMATO=JSON',
													"dataSrc" : "",
												/*
												"success": function (data) {
												    console.log("Datos devueltos:", data);
												}
												 */
												}
											});
						});
	</script>
	<script>
    function filterExhibitions() {
      var startDateString = document.getElementById('startDate').value;
      var endDateString = document.getElementById('endDate').value;
      // Convertir las cadenas de fecha a objetos Date
      var startDate = new Date(startDateString + 'T00:00:00');
      var endDate = new Date(endDateString + 'T00:00:00');
      var hoy = new Date();
      hoy.setHours(0, 0, 0, 0);
      //console.log(startDate);
      //console.log(endDate);
      //console.log(hoy);
      if (startDate < hoy) {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'La fecha de inicio no puede ser menor a hoy',
        });
        return;
      }
      if (endDate < startDate) {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'La fecha de fin debe ser mayor o igual a la fecha de inicio',
        });
        return;
      }
      
      $.ajax({
	        type: 'POST',
	        url: '/aso-web/ExposicionServlet', 
	        contentType: 'application/json',
	        data: JSON.stringify({ 'inicio': startDateString,'fin': endDateString,'FORMATO':'JSON' }),
	        success: function (response) {
					console.log(response);
					//if (response && response.length > 0) {
			            // Limpiar la tabla antes de agregar nuevos datos
			            tablaExpos.clear().draw();

			            // Agregar cada fila de datos a la tabla
			            response.forEach(function (data) {
			                tablaExpos.row.add(data).draw();
			            });
			      //  }
	        },
	        error: function (error) {
	            Swal.fire({
	                title: 'Error',
	                text: 'Error en la solicitud AJAX',
	                icon: 'error',
	                confirmButtonText: 'OK'
	            });
	        }
	    });

    }
  </script>
</body>
</html>
