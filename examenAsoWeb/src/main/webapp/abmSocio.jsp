<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mantenimiento De Datos Socios</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container mt-5">
		<h2>Formulario Socios</h2>
		<form action="socio-servlet" method="POST">
			<input type="hidden" id="id-socio" name="id-socio" value="">
			<input type="hidden" id="ACCION" name="ACCION" value="INSERTAR">
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="nombres" class="form-label">Nombres</label> <input
						type="text" class="form-control" id="nombres" name="nombres"
						placeholder="Nombres" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="apellidos class="form-label">Apellidos</label> <input
						type="text" class="form-control" id="apellidos" name="apellidos"
						placeholder="Apellidos" required>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="email" class="form-label">Email</label> <input
						type="email" class="form-control" id="email" name="email"
						placeholder="Email" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="nro_socio" class="form-label">Nro. Socio</label> <input
						type="text" class="form-control" id="nro_socio"
						placeholder="Nro. Socio" required>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="nro_cedula" class="form-label">Nro.
						C&eacutedula</label> <input type="text" class="form-control"
						id="nro_cedula" name="nro_cedula" placeholder="Nro. Cedula"
						required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="fecha_ingreso" class="form-label">Fecha de
						Ingreso</label> <input type="date" class="form-control" id="fecha_ingreso"
						name="fecha_ingreso" required>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="id_estado_actual" class="form-label">ID Estado
						Actual</label> <select class="form-control" id="id_estado_actual"
						name="id_estado_actual" required>
						<!-- Opciones para el select -->
						<c:forEach var="estado" items="${ESTADOS }">
							<option value="${estado.id}">${estado.descripcion }
							</option>
						</c:forEach>
						<!-- Agrega mÃ¡s opciones segÃºn sea necesario -->
					</select>
				</div>
				<div class="col-md-6 mb-3">
					<label for="fecha_estado_actual" class="form-label">Fecha
						Estado Actual</label> <input type="date" class="form-control"
						id="fecha_estado_actual" name="fecha_estado_actual" required>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<div class="form-check form-switch">
						<input class="form-check-input" type="checkbox" role="switch"
							id="flexSwitchCheckDefault"> <label
							class="form-check-label" for="flexSwitchCheckDefault">Fundador</label>
					</div>
				</div>
				<div class="col-md-6 mb-3">
					<label for="id_usuario_creacion" class="form-label">ID
						Usuario Creaci&oacuten</label> <select class="form-control"
						id="id_usuario_creacion" name="id_usuario_creacion" required>
						<option value="1">Usuario 1</option>
						<option value="2">Usuario 2</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="id_socio_proponente" class="form-label">ID
						Socio Proponente</label> <select class="form-control"
						id="id_socio_proponente" required>
						<c:forEach var="socioProp" items="${SOCIOS }">
							<option value="${socioProp.id}">${socioProp.nombres }
								${socioProp.apellidos }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="id_tipo_socio" class="form-label">ID Tipo Socio</label>
					<select class="form-select"
						aria-label="Seleccione el tipo de socio" id="tipo-socio"
						name="tipo-socio">
						<c:forEach var="tipo" items="${TIPOS}">
							<option value="${tipo.id}">${tipo.descripcion}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<button class="btn btn-primary" type="submit">Guardar</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
