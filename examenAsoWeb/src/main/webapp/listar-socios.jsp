<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ASO WEB</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="navbar.jsp"%>
<script>

function cargarNuevo(){

	document.getElementById("grillaSocioForm").submit();

}

</script>
  <form id="grillaSocioForm" action="socio-servlet" method="GET" >
	  <input id="ACCION"  name="ACCION" type="hidden" value="NUEVO"/>
	  <input id="ID"  name="ID"  type="hidden" value=""/>
  </form>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">NRO SOCIO</th>
				<th scope="col">NOMBRE Y APELLIDO</th>
				<th scope="col">ESTADO</th>
				<th scope="col">ULTIMA CUOTA PAGADA</th>
				<th scope="col">ACCIONES</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="socio" items="${SOCIOS }">
				<tr>
					<th scope="row"><c:out value="${socio.id }"></c:out></th>
					<td><c:out value="${socio.nroSocio }"></c:out></td>
					<td><c:out value="${socio.nombres } ${socio.apellidos }"></c:out></td>
					<td><c:out value="${socio.estadoActual.descripcion }"></c:out></td>
					<td><c:out value=""></c:out></td>
					<td></td>
				</tr>
			</c:forEach>


		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" align="right">
					<div class="col-auto">
						<button type="button" class="btn btn-primary mb-3" onclick="cargarNuevo();" >Nuevo
							Socio</button>
					</div>
				</td>
			</tr>

		</tfoot>
	</table>
</body>
</html>