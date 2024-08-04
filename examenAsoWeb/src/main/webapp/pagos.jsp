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
	<div class="container">
        <h1>Formulario de Pago</h1>
        <form id="formularioPago">
            <div class="form-group">
                <label for="socio">Socio:</label>
                <select id="socio" name="socio" class="form-control">
                    	<c:forEach var="socio" items="${SOCIOS }">
							<option value="  ${socio.id}">${socio.nroSocio }--${socio.nombres } ${socio.apellidos }
							</option>
						</c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="concepto">Concepto:</label>
                <select id="concepto" name="concepto" class="form-control">
                    <option value="CUOTASOC">Pago de Cuota</option>
                    <option value="MEDALLA">Compra de Medalla</option>
                    <option value="CENA">Cena Fin de Año</option>
                </select>
            </div>

            <div class="form-group">
                <label for="medioPago">Medio de Pago:</label>
                <select id="medioPago" name="medioPago" class="form-control">
                    <!-- Aquí debes incluir los medios de pago como opciones del select -->
                    <option value="efectivo">Efectivo</option>
                    <option value="tarjeta">Tarjeta de Crédito</option>
                    <!-- Agrega más opciones según sea necesario -->
                </select>
            </div>

            <div class="form-group">
                <label for="monto">Monto a Pagar:</label>
                <input id="monto" name="monto" type="text" class="form-control">
            </div>

            <div id="cuotasTotalesDiv" style="display:none;">
                <div class="form-group">
                    <label for="cuotasTotales">Cuotas a Pagar (Totales):</label>
                    <input id="cuotasTotales" name="cuotasTotales" type="text" class="form-control" readonly>
                </div>
            </div>

            <div id="cuotasParcialesDiv" style="display:none;">
                <div class="form-group">
                    <label for="cuotasParciales">Cuotas a Pagar (Parciales):</label>
                    <input id="cuotasParciales" name="cuotasParciales" type="text" class="form-control">
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Realizar Pago</button>
        </form>
    </div>

	<!-- Aquí debes incluir el código AJAX para consultar las cuotas si el concepto es CUOTASOC -->
	<script>
		document
				.getElementById('concepto')
				.addEventListener(
						'change',
						function() {
							var concepto = this.value;
							if (concepto === 'CUOTASOC') {
								// Aquí debes realizar una solicitud AJAX para consultar las cuotas y actualizar los campos cuotasTotales y cuotasParciales
								// Puedes usar JavaScript puro o una librería como jQuery para realizar la solicitud AJAX.
							} else {
								// Si el concepto no es CUOTASOC, oculta los campos de cuotas
								document.getElementById('cuotasTotalesDiv').style.display = 'none';
								document.getElementById('cuotasParcialesDiv').style.display = 'none';
							}
						});
	</script>

</body>
</html>