<%-- 
    Document   : consultarausencia
    Created on : 9 mar 2023, 9:42:24
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de ausencias</title>
        <link rel="icon" type="image/x-icon" href="administracion.png">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
    <!-- Instanciar objeto Java -->
    <body>
        <div class="container">
            <div class="row">
                
            </div>
            <div class="row">
                <div class="col-12">
                    <h1 class="text-center">Listado de ausencias</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <table class="table table-striped text-center">
                        <thead>
                            <th>DOCENTE</th>
                            <th>FECHA</th>
                            <th>HORA</th>
                            <th>MOTIVO</th>                            
                        </thead>
                        <tbody>
                            
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Boton insertar -->
            <div class="row">
                <div class="col-12">
                    <form action="formulario.jsp" method="GET">
                        <div class="d-grid gap-2">
                            <input type="submit" value="Volver" class="btn btn-success">
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>
                        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    
    </body>
</html>
