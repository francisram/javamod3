
<%@ page import="java.util.List" %>

<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">

	<div class="container-fluid">

		<a class="navbar-brand" href="#">Torneo So'o</a>

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
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Jugadores</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="JugadorServlet">Gestion de Jugadores</a></li>
						
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Equipos </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="EquipoServlet">Gestion de Equipos</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Partidos </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="PartidoServlet">Gestion de Partidos</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Torneo </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="TorneoServlet">Gestion de Torneo</a></li>
					</ul></li>

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
