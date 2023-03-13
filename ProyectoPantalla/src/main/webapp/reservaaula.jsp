<%-- 
    Document   : reservaaula
    Created on : 9 mar 2023, 9:44:18
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva de aula</title>
        <link rel="icon" type="image/x-icon" href="administracion.png">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>

    <body>

        <div class="container" style="position: center">
            <div class="row">
                <div class="g-col-4 g-col-md-4">
                    <h1 class="text-center">
                        <br>
                        <b>Reservar aula G-101</b>
                    </h1>
                </div>
                <div class="col-md-3 col-sm-12"></div>
                <div class="col-md-6 col-sm-12">
                    <h1 class="text-center"> 
                       <!--<%
                        GestionAlumnos gestion = new GestionAlumnos();
                        String accion = request.getParameter("accion");
                        
                        Alumnos al = null;
                        String action = "insertar";
                        
                        if(accion != null && accion.equals("editar")){
                            action = "editar";
                            %> Editar registro <%
                        } else {
                            if(accion == null){
                                %> Insertar registro <%
                            }
                        }
                        %>
                        
                        <% 
                        int id = -1;
                        if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
                        if(id != -1){
                            al = gestion.obtenerAlumno(id);
                        } else {
                            al = new Alumnos("", "", 0, "", 0, "", false);
                        }
                        %>-->
                        
                    </h1>
                    <form method="GET" action="principal.jsp">
                        <!--<%
                           if(id != -1 && accion.equals("editar")) {
                        %>
                        <input type="hidden" name="id" value="<%= id %>"/>
                        <%
                            } 
                         %>-->
                         <div class="mb-3">
                            <label class="form-label">Fecha</label>
                            <input name="fecha" type="date" class="form-control"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Hora</label>
                            <input name="timer" id="timer" type="time" class="form-control">             
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Asunto</label>
                            <!--<input name="asunto" type="text" class="form-control"/>-->
                            <textarea name="asunto" type="text" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                        
                        
                        <input type="hidden" name="accion" value="Reservar">   
                        
                        <div class="d-grid gap-2">
                            <!--<%
                                if(accion != null && accion.equals("editar")){
                            %> 
                                    <input type="submit" value="Editar" class="btn btn-warning">
                            <%
                               } else {
                            %> -->
                                    <input type="submit" value="Reservar" class="btn btn-primary">
                            <!--<%
                                }
                            %>-->
                        </div>
                    </form>
                </div>
                <div class="col-md-3 col-sm-12"></div>
            </div>
        </div>
    </body>

    </html>
