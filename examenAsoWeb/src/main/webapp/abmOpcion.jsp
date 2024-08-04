<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro de Parametro</title>
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
		<form action="Opciones-servlet" method="post">
			<input type="hidden" id="id-opcion" name="id-opcion" value="${OPCION != null && OPCION.id != null ?	OPCION.id : ''}">
			<br> <br> 
			<input type="hidden" id="ACCION" name="ACCION" value="${OPCION != null && OPCION.id != null ?	'ACTUALIZAR' : 'INSERTAR'}">
			<br> <br>
			<div class="form-group">
				<label for="dominio">Dominio:</label> <select class="form-control"
					id="dominio" name="dominio">
					<c:forEach var="dominio" items="${DOMINIOS }">
						<option value="${dominio.id}">${dominio.descripcion }</option>
						<option value="${dominio.id}" ${dominio.id == OPCION.dominio.id ? 'selected="selected"' : ''}>
							${dominio.descripcion}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="codigo">Código:</label> <input type="text"
					class="form-control" id="codigo" name="codigo"
					value="${OPCION.codigo != null  ? OPCION.codigo : ''}"
					>
			</div>
			<div class="form-group">
				<label for="descripcion">Descripción:</label>
				<textarea class="form-control" id="descripcion" name="descripcion"
					rows="3"> ${OPCION.descripcion != null  ? OPCION.descripcion : ''}</textarea>
			</div>
			<div class="form-group">
				<label for="estado">Estado:</label> <select class="form-control"
					id="estado" name="estado">
					<option value="A"  
					<c:if test="${OPCION.estado == 'A'}">
   						 selected
					</c:if>
					>Activo
					</option>
					<option value="I" <c:if test="${OPCION.estado == 'I'}">
   						 selected
					</c:if>>Inactivo</option>
				</select>
			</div>
			<div class="form-group">
				<label for="padre">Opción Padre:</label> <select
					class="form-control" id="padre" name="padre">
					<option value="null">NINGUNO</option>
					<c:forEach var="opcion" items="${OPCIONES }">
						<option value="${opcion.id}">${opcion.descripcion } (Dominio : ${opcion.dominio.descripcion})</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>