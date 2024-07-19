<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ejemplo de Tabla con DataTables y Formulario</title>
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
					<th>Nombre del Equipo</th>
					<th>Slogan</th>
					<th>Capitán</th>
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
			onfocus="cargarJugadores();">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="addModalLabel">Agregar Equipo</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form id="addForm">
							<div class="mb-3">
								<label for="teamName" class="form-label">Nombre del
									Equipo</label> <input type="text" class="form-control" id="teamName">
							</div>
							<div class="mb-3">
								<label for="slogan" class="form-label">Slogan</label> <input
									type="text" class="form-control" id="slogan">
							</div>
							<div class="mb-3">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th scope="col">Jugador</th>
											<th scope="col">Seleccionar</th>
											<th scope="col">Capitán</th>
										</tr>
									</thead>
									<tbody id="jugadoresTableBody">
										<!-- Las filas de los jugadores se añadirán aquí -->
									</tbody>
								</table>
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
							¿Está seguro que desea eliminar a <span id="deleteTeamName"></span>?
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
		$(document)
				.ready(
						function() {
							var table = $('#example')
									.DataTable(
											{
												ajax : {
													url : 'EquipoServlet',
													type : 'POST',
													contentType : 'application/json',
													data : function(d) {
														return JSON.stringify({
															accion : 'listar'
														});
													},
													dataSrc : ''
												},
												columns : [
														{
															data : 'id',
															render : function(
																	data, type,
																	row) {
																return data ? data
																		: '';
															}
														},
														{
															data : 'nombre',
															render : function(
																	data, type,
																	row) {
																return data ? data
																		: '';
															}
														},
														{
															data : 'slogan',
															render : function(
																	data, type,
																	row) {
																return data ? data
																		: '';
															}
														},
														{
															data : 'capitan.nombres',
															render : function(
																	data, type,
																	row) {
																return data ? data
																		: '';
															}
														},
														{
															data : null,
															render : function(
																	data, type,
																	row) {
																return '<button type="button" class="btn btn-danger btn-sm delete-btn"  data-bs-toggle="modal" data-bs-target="#deleteModal">Eliminar</button>';
															},
															orderable : false
														} ]
											});

							$('#searchInput').on('keyup', function() {
								table.search(this.value).draw();
							});

							var rowToDelete;
							$('#example tbody').on(
									'click',
									'.delete-btn',
									function() {
										rowToDelete = table.row($(this)
												.parents('tr'));
										var data = rowToDelete.data();
										//console.log(data);
										$('#deleteTeamName').text(
												'¿Estás seguro de que deseas eliminar a '
														+ data.nombre + ' ?');
										$('#confirmDeleteButton').attr(
												'onclick',
												'eliminar(' + data.id + ');');
									});

						});

		function registrar() {

			let teamName = $('#teamName').val();
			let slogan = $('#slogan').val();
			let jugadoresSeleccionados = [];
			let capitan = $('input[name="capitan"]:checked').val();

			$('#jugadoresTableBody input[type="checkbox"]:checked').each(
					function() {
						jugadoresSeleccionados.push($(this).val());
					});

			if (teamName && slogan && jugadoresSeleccionados.length > 0) {
				$
						.ajax({
							url : 'EquipoServlet',
							type : 'POST',
							contentType : 'application/json',
							data : JSON.stringify({
								teamName : teamName,
								slogan : slogan,
								capitan : capitan,
								jugadores : jugadoresSeleccionados,
								accion : 'inscribir'
							}),
							success : function(response) {
								//console.log(response);
								if (response.status === "error") {
									Swal.fire({
										icon : 'error',
										title : 'Error',
										text : response.message
									});
								} else {
									Swal
											.fire(
													{
														icon : 'success',
														title : '¡Éxito!',
														text : 'El equipo se ha registrado correctamente.'
													}).then(function() {
												$('#addModal').modal('hide');
												$('#addForm')[0].reset();
												location.reload();
											});
								}
							},
							error : function() {
								Swal
										.fire({
											icon : 'error',
											title : 'Error',
											text : 'Ocurrió un error al registrar el equipo. Inténtelo nuevamente.'
										});
							}
						});
			} else {
				Swal.fire({
					icon : 'warning',
					title : 'Campos incompletos',
					text : 'Por favor, complete todos los campos.'
				});
			}
		}

		/*

		$(document).ready(function() {
			var table = $('#example').DataTable();

			$('#searchInput').on('keyup', function() {
				table.search(this.value).draw();
			});

			var rowToDelete;
			$('#example tbody').on('click', '.delete-btn', function() {
				rowToDelete = table.row($(this).parents('tr'));
				var data = rowToDelete.data();
				$('#deleteTeamName').text(data[0]);
			});
			
		});
		 */
		function cargarJugadores() {
			$
					.ajax({
						url : 'JugadorServlet',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify({
							accion : 'listarLosSinEquipo'
						}),
						success : function(data) {
							//const jugadoresDiv = $('#jugadores');
							const jugadoresTableBody = $('#jugadoresTableBody');

							jugadoresTableBody.empty();

							data
									.forEach(function(jugador) {
										var rowHtml = '<tr>'
												+ '<td>'
												+ jugador.nombres
												+ ' '
												+ jugador.apellidos
												+ '</td>'
												+ '<td>'
												+ '<div class="form-check">'
												+ '<input type="checkbox" id="jugador_' + jugador.id + '" value="' + jugador.id + '" class="form-check-input">'
												+ '<label for="jugador_' + jugador.id + '" class="form-check-label"></label>'
												+ '</div>'
												+ '</td>'
												+ '<td>'
												+ '<div class="form-check">'
												+ '<input type="radio" id="capitan_' + jugador.id + '" name="capitan" value="' + jugador.id + '" class="form-check-input">'
												+ '<label for="capitan_' + jugador.id + '" class="form-check-label">Será Capitán</label>'
												+ '</div>' + '</td>' + '</tr>';

										jugadoresTableBody.append(rowHtml);
									});
						}

						,
						error : function(xhr, status, error) {
							console.error('Error al cargar los jugadores:',
									error);
						}
					});
		}

		function eliminar(x) {

			let valor = x;
			//console.log(valor);
			if (valor) {
				$
						.ajax({
							url : 'EquipoServlet',
							type : 'POST',
							contentType : 'application/json',
							data : JSON.stringify({
								id : valor,
								accion : 'borrar'
							}),
							success : function(response) {
								//console.log(response);
								if (response.status === "error") {
									Swal.fire({
										icon : 'error',
										title : 'Error',
										text : response.message
									});
								} else {
									Swal.fire({
										icon : 'success',
										title : '¡Éxito!',
										text : 'Eliminado correctamente.'
									}).then(function() {
										$('#addModal').modal('hide');
										$('#addForm')[0].reset();
										location.reload();
									});
								}
							},
							error : function() {
								Swal
										.fire({
											icon : 'error',
											title : 'Error',
											text : 'Ocurrió un error al borrar el jugador. Inténtelo nuevamente.'
										});
							}
						});
			} else {
				// Mostrar SweetAlert de advertencia
				Swal.fire({
					icon : 'warning',
					title : 'No se obtuvo el id a borrar',
					text : 'Por favor, contacte con soporte'
				});
			}
		}
	</script>

</body>
</html>
