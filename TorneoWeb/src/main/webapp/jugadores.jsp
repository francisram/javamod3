<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Equipo</th>
					<th>Nacionalidad</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="j" items="${JUGADORES}">
					<tr>
						<th scope="row"><c:out value="${j.id}"></c:out></th>
						<td><c:out value="${j.nombres}"></c:out></td>
						<td><c:out value="${j.apellidos}"></c:out></td>
						<td><c:out value="${j.equipo.nombre}"></c:out></td>
						<td><c:out value="${j.nacionalidad}"></c:out></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<button type="button" class="btn btn-primary mt-3"
			data-bs-toggle="modal" data-bs-target="#addModal">Agregar</button>

		<!-- Modal Agregar -->
		<div class="modal fade" id="addModal" tabindex="-1"
			aria-labelledby="addModalLabel" aria-hidden="true">
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
								<label for="nombre" class="form-label">Nombre del
									Jugador</label> <input type="text" class="form-control" id="nombre"
									name="nombre" required>
							</div>
							<div class="mb-3">
								<label for="apellido" class="form-label">Apellido del
									Jugador</label> <input type="text" class="form-control" id="apellido"
									name="apellido" required>
							</div>
							<div class="mb-3">
								<label for="fecNac" class="form-label">fecha de
									nacimiento</label> <input type="date" class="form-control" id="fecNac"
									name="fecNac">
							</div>
							<div class="mb-3">
								<label for="ficNum" class="form-label">numero de Ficha</label> <input
									type="text" class="form-control" id="ficNum" name="ficNum"
									required>
							</div>
							<div class="mb-3">
								<label for="pais" class="form-label">Nacionalidad</label> <input
									type="text" class="form-control" id="pais" name="pais">
							</div>
							<div class="mb-3">
								<label for="telefono" class="form-label">Telefono</label> <input
									type="text" class="form-control" id="telefono" name="telefono">
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> <input
									type="text" class="form-control" id="email" name="email">
							</div>
							<button type="button" class="btn btn-primary" id="saveButton">Guardar</button>
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
							¿Está seguro que desea eliminar a <span id="delJugNom"></span>?
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
												"ajax" : {
													"url" : "/TorneoWeb/JugadorServlet?ACCION=LISTAR&FORMATO=JSON",
													"dataSrc" : "data"
												},
												"columns" : [
														{
															"data" : "id"
														},
														{
															"data" : "nombres"
														},
														{
															"data" : "apellidos"
														},
														{
															"data" : "equipo"
														},
														{
															"data" : "nacionalidad"
														},
														{
															"data" : null,
															"defaultContent" : '<button type="button" class="btn btn-danger btn-sm delete-btn" data-bs-toggle="modal" data-bs-target="#deleteModal">Eliminar</button>'
														} ]
											});

							// Configura el evento de búsqueda
							$('#searchInput').on('keyup', function() {
								table.search(this.value).draw();
							});

							// Manejo del botón guardar
							$('#saveButton')
									.on(
											'click',
											function() {
												var nombre = $('#nombre').val();
												var apellido = $('#apellido')
														.val();
												var fecNac = $('#fecNac').val();
												var ficNum = $('#ficNum').val();
												var pais = $('#pais').val();
												var telefono = $('#telefono')
														.val();
												var email = $('#email').val();

												if (nombre && apellido
														&& ficNum) {
													table.row.add({
														"nombres" : nombre,
														"apellidos" : apellido,
														"equipo" : ficNum,
														"nacionalidad" : pais
													}).draw(false);

													$('#addModal')
															.modal('hide');
													$('#addForm')[0].reset();
												} else {
													alert("Por favor, complete todos los campos.");
												}
											});

							// Manejo del botón eliminar
							var rowToDelete;
							$('#example tbody')
									.on(
											'click',
											'.delete-btn',
											function() {
												rowToDelete = table.row($(this)
														.parents('tr'));
												var data = rowToDelete.data();
												$('#deleteTeamName').text(
														data.nombres);
											});

							$('#confirmDeleteButton').on('click', function() {
								rowToDelete.remove().draw(false);
								$('#deleteModal').modal('hide');
							});
						});
	</script>
</body>
</html>
