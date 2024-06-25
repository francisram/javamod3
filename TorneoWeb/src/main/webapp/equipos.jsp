<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo de Tabla con DataTables y Formulario</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
</head>
<body>
<%@ include file="navbar.jsp"%>
    <div class="container mt-5">
        <h1 class="mb-4">Buscador</h1>
        <form id="searchForm">
            <div class="mb-3">
                <label for="searchInput" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="searchInput" placeholder="Buscar por nombre">
            </div>
        </form>
        
        <table id="example" class="display table table-striped" style="width:100%">
            <thead>
                <tr>
                    <th>Nombre del Equipo</th>
                    <th>Slogan</th>
                    <th>Capitán</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Equipo 1</td>
                    <td>Somos los mejores</td>
                    <td>Juan Pérez</td>
                    <td><button type="button" class="btn btn-danger btn-sm delete-btn" data-bs-toggle="modal" data-bs-target="#deleteModal">Eliminar</button></td>
                </tr>
                <tr>
                    <td>Equipo 2</td>
                    <td>Unidos ganamos</td>
                    <td>María García</td>
                    <td><button type="button" class="btn btn-danger btn-sm delete-btn" data-bs-toggle="modal" data-bs-target="#deleteModal">Eliminar</button></td>
                </tr>
                <!-- Más filas de ejemplo -->
            </tbody>
        </table>

        <button type="button" class="btn btn-primary mt-3" data-bs-toggle="modal" data-bs-target="#addModal">
            Agregar
        </button>

        <!-- Modal Agregar -->
        <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addModalLabel">Agregar Equipo</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="addForm">
                            <div class="mb-3">
                                <label for="teamName" class="form-label">Nombre del Equipo</label>
                                <input type="text" class="form-control" id="teamName">
                            </div>
                            <div class="mb-3">
                                <label for="slogan" class="form-label">Slogan</label>
                                <input type="text" class="form-control" id="slogan">
                            </div>
                            <div class="mb-3">
                                <label for="captain" class="form-label">Capitán</label>
                                <input type="text" class="form-control" id="captain">
                            </div>
                            <button type="button" class="btn btn-primary" id="saveButton">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Eliminar -->
        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deleteModalLabel">Confirmar Eliminación</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p>¿Está seguro que desea eliminar a <span id="deleteTeamName"></span>?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-danger" id="confirmDeleteButton">Eliminar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

    <script>
        $(document).ready(function() {
            var table = $('#example').DataTable();

            $('#searchInput').on('keyup', function() {
                table.search(this.value).draw();
            });

            $('#saveButton').on('click', function() {
                var teamName = $('#teamName').val();
                var slogan = $('#slogan').val();
                var captain = $('#captain').val();

                if(teamName && slogan && captain) {
                    table.row.add([
                        teamName,
                        slogan,
                        captain,
                        '<button type="button" class="btn btn-danger btn-sm delete-btn" data-bs-toggle="modal" data-bs-target="#deleteModal">Eliminar</button>'
                    ]).draw(false);

                    $('#addModal').modal('hide');
                    $('#addForm')[0].reset();
                } else {
                    alert("Por favor, complete todos los campos.");
                }
            });

            var rowToDelete;
            $('#example tbody').on('click', '.delete-btn', function() {
                rowToDelete = table.row($(this).parents('tr'));
                var data = rowToDelete.data();
                $('#deleteTeamName').text(data[0]);
            });

            $('#confirmDeleteButton').on('click', function() {
                rowToDelete.remove().draw(false);
                $('#deleteModal').modal('hide');
            });
        });
    </script>
</body>
</html>
	