
<%@ page import="java.util.List" %>
<%@ page import="py.edu.ucsa.ejb.dto.RolUsuarioDTO" %>
<%
//Obtiene el atributo de sesión "roles"
//List<RolUsuarioDTO> roles = (List<RolUsuarioDTO>) session.getAttribute("ROLES");
Iterable<RolUsuarioDTO> roles = (Iterable<RolUsuarioDTO>) session.getAttribute("ROLES");
boolean tieneRol1 = false;

// recorremos la lista
if (roles != null) {
	for (RolUsuarioDTO rol : roles) {
		if (rol.getIdRol().getId() == 1) {
	tieneRol1 = true;
	break;
		}
	}
}
%>


<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">

	<div class="container-fluid">

		<a class="navbar-brand" href="#">ASO-Web</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">

			<span class="navbar-toggler-icon"></span>

		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav me-auto mb-2 mb-lg-0">

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Inicio</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Expos</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Parametros </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="Opciones-servlet">Opciones</a></li>
						<li><a class="dropdown-item" href="#">Tipos de Movimiento</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Socios </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="PagosServlet">Pagos de
								Cuotas</a></li>
						<li><a class="dropdown-item" href="#">Consultar Cuotas
								Pendientes</a></li>

						<li><a class="dropdown-item" href="socio-servlet">Registrar
								Socios</a></li>
						<%
						if (tieneRol1) {
						%>
						<li><a class="dropdown-item" href="ExposicionServlet">Exposiciones</a></li>
						<%
						}
						%>
						<li><hr class="dropdown-divider"></li>
					</ul></li>
			


				<li class="nav-item"><a class="nav-link disabled"
					aria-disabled="true">Disabled</a></li>

			</ul>

			<form class="d-flex" role="search">

				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">

				<button class="btn btn-outline-success" type="submit">Search</button>

			</form>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="Logout">Cerrar
						Sesi&oacuten</a></li>
			</ul>

		</div>

	</div>

</nav>
