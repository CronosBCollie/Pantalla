<%-- 
    Document   : ausencia1
    Created on : 9 mar 2023, 9:41:22
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ausencias</title>
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
                        <b>Ausencias</b>
                    </h1>
                </div>
                <div class="col-md-3 col-sm-12"></div>
                <div class="col-md-6 col-sm-12">
                    <h1 class="text-center"> 
                    </h1>
                    <form method="GET" action="principal.jsp">
                        
                         <div class="mb-3">
                            <label class="form-label">Fecha</label>
                            <input name="fecha" type="date" class="form-control"/>
                        </div>

                        <br>

                        <div class="mb-3">
                            <!--<label class="form-label">Tiempo de ausencia</label>-->
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Intervalo de horas</span>
                                  </div>
                                <input name="timerinit" id="timerinit" type="time" class="form-control">    
                                <input name="timerfin" id="timerfin" type="time" class="form-control">             
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Motivo</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>-</option>
                                <option value="1">Enfermedad</option>
                                <option value="2">Accidente laboral</option>
                                <option value="3">Formación</option>
                                <option value="1">Sin justificar</option>
                                <option value="4">Otro</option>
                              </select>
                        </div>
                        
                        <input type="hidden" name="accion" value="Reservar">   
                        
                        <div class="d-grid gap-2">
                            <input type="submit" value="Enviar" class="btn btn-primary">
                        </div>
                    </form>
                </div>
                <div class="col-md-3 col-sm-12"></div>
            </div>
        </div>
    </body>
</html>
