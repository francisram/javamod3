
<%@ page import="java.util.List" %>
<%@ page import="py.edu.ucsa.ejb.entities.RolUsuario" %>
<%
//Obtiene el atributo de sesión "roles"
//List<RolUsuarioDTO> roles = (List<RolUsuarioDTO>) session.getAttribute("ROLES");
Iterable<RolUsuario> roles = (Iterable<RolUsuario>) session.getAttribute("ROLES");
boolean tieneRol1 = false;

// recorremos la lista
if (roles != null) {
	for (RolUsuario rol : roles) {
		if (rol.getIdRol().getId() == 1) {
	tieneRol1 = true;
	break;
		}
	}
}
%>


<nav class="navbar navbar-expand-lg  navbar-light bg-primary">

	<div class="container-fluid">

		<a class="navbar-brand" href="#">ASOWEB-JM3</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">

			<span class="navbar-toggler-icon"></span>

		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav me-auto mb-2 mb-lg-0">

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="menu.jsp">Inicio</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Socios </a>
					<ul class="dropdown-menu">
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


			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="Logout">Cerrar
						Sesi&oacuten</a></li>
			</ul>

		</div>

	</div>

</nav>
