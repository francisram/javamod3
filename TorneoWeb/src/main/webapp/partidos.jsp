<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Partidos</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- DataTables CSS -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<!-- SweetAlert CSS and JS -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container mt-5">
		<h1 class="mb-4">Buscador</h1>
		<form id="searchForm">
			<div class="mb-3">
				<label for="searchInput" class="form-label">Nombre</label> <input
					type="text" class="form-control" id="searchInput"
					placeholder="Buscar por nombre">
			</div>
		</form>

		<table id="example" class="display table table-striped"
			style="width: 100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Equipo Local</th>
					<th>Equipo Visitante</th>
					<th>Torneo</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Goles Local</th>
					<th>Goles Visitante</th>
					<th>Número de Fecha</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>

		<button type="button" class="btn btn-primary mt-3"
			data-bs-toggle="modal" data-bs-target="#addModal">Agregar</button>

		<!-- Modal Agregar -->
		<div class="modal fade" id="addModal" tabindex="-1"
			aria-labelledby="addModalLabel" aria-hidden="true"
			onfocus="cargarEquipos(); cargarTorneos();">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="addModalLabel">Agregar Partido</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form id="addForm">
							<div class="mb-3">
								<label for="equipoLocal" class="form-label">Equipo Local</label> 
								<select class="form-control" id="equipoLocal"></select>
							</div>
							<div class="mb-3">
								<label for="equipoVisitante" class="form-label">Equipo Visitante</label> 
								<select class="form-control" id="equipoVisitante"></select>
							</div>
							<div class="mb-3">
								<label for="torneo" class="form-label">Torneo</label> 
								<select class="form-control" id="torneo"></select>
							</div>
							<div class="mb-3">
								<label for="fecha" class="form-label">Fecha</label> 
								<input type="date" class="form-control" id="fecha">
							</div>
							<div class="mb-3">
								<label for="hora" class="form-label">Hora</label> 
								<input type="time" class="form-control" id="hora">
							</div>
							<div class="mb-3">
								<label for="golesLocal" class="form-label">Goles Local</label> 
								<input type="number" class="form-control" id="golesLocal">
							</div>
							<div class="mb-3">
								<label for="golesVisitante" class="form-label">Goles Visitante</label> 
								<input type="number" class="form-control" id="golesVisitante">
							</div>
							<div class="mb-3">
								<label for="fechaNro" class="form-label">Número de Fecha</label> 
								<input type="number" class="form-control" id="fechaNro">
							</div>
							<button type="button" class="btn btn-primary" id="saveButton"
								onclick="registrar();">Guardar</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal Eliminar -->
		<div class="modal fade" id="deleteModal" tabindex="-1"
			aria-labelledby="deleteModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="deleteModalLabel">Confirmar
							Eliminación</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p>
							¿Está seguro que desea eliminar este partido?
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cancelar</button>
						<button type="button" class="btn btn-danger"
							id="confirmDeleteButton">Eliminar</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
	<!-- DataTables JS -->
	<script
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

	<script>
		$(document).ready(function() {
			var table = $('#example').DataTable({
				ajax : {
					url : 'PartidoServlet',
					type : 'POST',
					contentType : 'application/json',
					data : function(d) {
						return JSON.stringify({ accion : 'listar' });
					},
					dataSrc : ''
				},
				columns : [
					{ data : 'id' },
					{ data : 'equipoLocal.nombre' },
					{ data : 'equipoVisitante.nombre' },
					{ data : 'torneoDTO.nombre' },
					{ data : 'fecha' },
					{ data : 'hora' },
					{ data : 'goleLocal' },
					{ data : 'goleVisitante' },
					{ data : 'fechaNro' },
					{
						data : null,
						render : function(data, type, row) {
							return '<button type="button" class="btn btn-danger btn-sm delete-btn" data-bs-toggle="modal" data-bs-target="#deleteModal">Eliminar</button>';
						},
						orderable : false
					}
				]
			});

			$('#searchInput').on('keyup', function() {
				table.search(this.value).draw();
			});

			var rowToDelete;
			$('#example tbody').on('click', '.delete-btn', function() {
				rowToDelete = table.row($(this).parents('tr'));
				var data = rowToDelete.data();
				$('#deleteTeamName').text('¿Estás seguro de que deseas eliminar el partido?');
				$('#confirmDeleteButton').attr('onclick', 'eliminar(' + data.id + ');');
			});
		});

		function registrar() {
			let equipoLocal = $('#equipoLocal').val();
			let equipoVisitante = $('#equipoVisitante').val();
			let torneo = $('#torneo').val();
			let fecha = $('#fecha').val();
			let hora = $('#hora').val();
			let golesLocal = $('#golesLocal').val();
			let golesVisitante = $('#golesVisitante').val();
			let fechaNro = $('#fechaNro').val();

			if (equipoLocal && equipoVisitante && torneo && fecha && hora && golesLocal && golesVisitante && fechaNro) {
				$.ajax({
					url : 'PartidoServlet',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify({
						equipoLocal : { id: equipoLocal },
						equipoVisitante : { id: equipoVisitante },
						torneoDTO : { id: torneo },
						fecha : fecha,
						hora : hora,
						goleLocal : golesLocal,
						goleVisitante : golesVisitante,
						fechaNro : fechaNro,
						accion : 'inscribir'
					}),
					success : function(response) {
						if (response.status === "error") {
							Swal.fire({ icon : 'error', title : 'Error', text : response.message });
						} else {
							Swal.fire({ icon : 'success', title : '¡Éxito!', text : 'El partido se ha registrado correctamente.' })
								.then(function() {
									$('#addModal').modal('hide');
									$('#addForm')[0].reset();
									location.reload();
								});
						}
					},
					error : function() {
						Swal.fire({ icon : 'error', title : 'Error', text : 'Ocurrió un error al registrar el partido. Inténtelo nuevamente.' });
					}
				});
			} else {
				Swal.fire({ icon : 'warning', title : 'Campos incompletos', text : 'Por favor, complete todos los campos.' });
			}
		}

		function cargarEquipos() {
			$.ajax({
				url : 'EquipoServlet',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify({ accion : 'listar' }),
				success : function(data) {
					const equipoLocal = $('#equipoLocal');
					const equipoVisitante = $('#equipoVisitante');

					equipoLocal.empty();
					equipoVisitante.empty();

					data.forEach(function(equipo) {
						equipoLocal.append('<option value="' + equipo.id + '">' + equipo.nombre + '</option>');
						equipoVisitante.append('<option value="' + equipo.id + '">' + equipo.nombre + '</option>');
					});
				},
				error : function(xhr, status, error) {
					console.error('Error al cargar los equipos:', error);
				}
			});
		}

		function cargarTorneos() {
			$.ajax({
				url : 'TorneoServlet',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify({ accion : 'listar' }),
				success : function(data) {
					const torneo = $('#torneo');

					torneo.empty();

					data.forEach(function(torneoItem) {
						torneo.append('<option value="' + torneoItem.id + '">' + torneoItem.nombre + '</option>');
					});
				},
				error : function(xhr, status, error) {
					console.error('Error al cargar los torneos:', error);
				}
			});
		}

		function eliminar(id) {
			if (id) {
				$.ajax({
					url : 'PartidoServlet',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify({ id : id, accion : 'borrar' }),
					success : function(response) {
						if (response.status === "error") {
							Swal.fire({ icon : 'error', title : 'Error', text : response.message });
						} else {
							Swal.fire({ icon : 'success', title : '¡Éxito!', text : 'Eliminado correctamente.' })
								.then(function() {
									$('#deleteModal').modal('hide');
									location.reload();
								});
						}
					},
					error : function() {
						Swal.fire({ icon : 'error', title : 'Error', text : 'Ocurrió un error al borrar el partido. Inténtelo nuevamente.' });
					}
				});
			} else {
				Swal.fire({ icon : 'warning', title : 'No se obtuvo el id a borrar', text : 'Por favor, contacte con soporte' });
			}
		}
	</script>

</body>
</html>
