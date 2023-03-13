<%-- 
    Document   : pantalla
    Created on : 13 mar 2023, 9:16:32
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Scraper.Scraper"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Información</title>
        
        <!--BACKGROUND ANIMATION-->
        <style>
            body{
              background: linear-gradient(45deg,#eef0f95b, #C6CEF7, #bbc3eb46, #A7AED1);
              background-size: 400% 400%;
              position: relative;
              animation: cambiar 10s ease infinite;
              overflow-x: hidden; 
              overflow-y: hidden;
            }

            @keyframes cambiar{
              0%{background-position: 0 50%;}
              50%{background-position: 100% 50%;}
              100%{background-position: 0 50%;}
            }
        </style>
        
    </head>
    <body>
        
      <div style="margin-top: 30px; margin-left: 50px; margin-right: 50px;">
        <!--RESERVA AULA-->
        <div class="row card shadow-lg p-1 mb-5 bg-body rounded">
          <div class="col-12">
                        
            <div class="card-body">

                <h3 class="card-title">Reserva Aula G101</h3>
            <!-- Default Table -->
                <table class="table table-striped" style="text-align: center; font-size: 23px;">
                  <thead>
                    <tr>
                      <th scope="col">Lunes</th>
                      <th scope="col">Martes</th>
                      <th scope="col">Miércoles</th>
                      <th scope="col">Jueves</th>
                      <th scope="col">Viernes</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>Brandon Jacob <br> 10:30 - 11:30</td>
                      <td>Brandon Jacob <br> 10:30 - 11:30</td>
                      <td>Brandon Jacob <br> 10:30 - 11:30</td>
                      <td>Brandon Jacob <br> 10:30 - 11:30</td>
                      <td>Brandon Jacob <br> 10:30 - 11:30</td>
                    </tr>
                    <tr>
                      <td>Bridie Kessler <br> 10:30 - 11:30</td>
                      <td>Bridie Kessler <br> 10:30 - 11:30</td>
                      <td>Bridie Kessler <br> 10:30 - 11:30</td>
                      <td>Bridie Kessler <br> 10:30 - 11:30</td>
                      <td>Bridie Kessler <br> 10:30 - 11:30</td>
                    </tr>
                    <tr>
                      <td>Ashleigh Langosh <br> 10:30 - 11:30</td>
                      <td>Ashleigh Langosh <br> 10:30 - 11:30</td>
                      <td>Ashleigh Langosh <br> 10:30 - 11:30</td>
                      <td>Ashleigh Langosh <br> 10:30 - 11:30</td>
                      <td>Ashleigh Langosh <br> 10:30 - 11:30</td>
                    </tr>
                    
                  </tbody>
                </table>

            </div>

            <!-- End Default Table Example -->
        </div>
        </div>

        <div class="row">
          <!-- FECHA Y HORA -->
          <div class="col-1" style="text-align: center; padding: 0%; margin-top: 100px;">
            <h1 id="reloj" style="margin-left: -20px;"></h1>
            <h6 id="fecha" style="margin-left: 20px;"></h6>            
          </div>
          <!-- GUAGUAS -->
          <div class="col-5" style="margin-top: -20px;">
            <div class="card shadow-lg bg-body rounded">
                
                <div class="card-body">

                    <h3 class="card-title">Horario Guaguas</h3>
                <!-- Default Table -->
                    <table class="table table-striped" style="text-align: center; font-size: 23px;">
                      <thead>
                        <tr>
                          <th scope="col-5">Línea [Parada]</th>
                          <th scope="col-5">Destino</th>
                          <th scope="col-1">Tiempo</th>
                        </tr>
                      </thead>
                      <tbody>
                          
                        <%
                            Scraper scraper = new Scraper();
                            
                            ArrayList<HashMap<String,String>> guaguas = scraper.ScrapingTotal();
                            int i=0;
                            for(HashMap<String,String> cada:  guaguas){
                                String[] separar = cada.get("tiempo" + i).split(" ");
                                int cuantoqueda = Integer.parseInt(separar[0]);
                                
                                String[] numparada = cada.get("titulo").split(" ");
                        %>
                        <tr <% if(cuantoqueda <=2) { %> style="background-color: yellow" <% } %> >
                          <td><%=cada.get("linea" + i) + " " + numparada[0]%>  </td>
                          <td><%=cada.get("parada" + i)%> </td>
                          <td><%=cada.get("tiempo" + i)%> </td>
                        </tr>
                        <% i++; } %>
                        <!--<tr>
                          <td>Raheem Lehner</td>
                          <td>Dynamic Division Officer</td>
                          <td>47</td>
                        </tr>-->
                      </tbody>
                    </table>

                </div>

                <!-- End Default Table Example -->
            </div>
        </div>
          <!-- AUSENCIAS -->
          <div class="col-5" style="margin-top: -20px;">
            <div class="card shadow-lg bg-body rounded">
                
                <div class="card-body">

                    <h3 class="card-title">Ausencias</h3>
  
                <!-- Default Table -->
                    <table class="table table-striped"  style="text-align: center; font-size: 23px;">
                      <thead>
                        <tr>
                          <th scope="col">Profesor</th>
                          <th scope="col">Fecha - Hora</th>
                          <th scope="col">Motivo</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Brandon Jacob</td>
                          <td>02/04/2023 10:30 - 11:30</td>
                          <td>Enfermedad</td>
                        </tr>
                        <tr>
                          <td>Bridie Kessler</td>
                          <td>01/04/2023 09:30 - 10:30</td>
                          <td>Otros</td>
                        </tr>
                        <tr>
                          <td>Ashleigh Langosh</td>
                          <td>20/03/2023 08:00 - 14:00</td>
                          <td>Paternidad</td>
                        </tr>
                        <tr>
                          <td>Angus Grady</td>
                          <td>22/03/2023 08:00 - 13:00</td>
                          <td>Asuntos personales</td>
                        </tr>
                        <tr>
                          <td>Raheem Lehner</td>
                          <td>15/03/2023 12:00 - 13:00</td>
                          <td>Desconocido</td>
                        </tr>
                        <tr>
                          <td>Raheem Lehner</td>
                          <td>15/03/2023 12:00 - 13:00</td>
                          <td>Paternidad</td>
                        </tr>
                        <tr>
                          <td>Raheem Lehner</td>
                          <td>15/03/2023 12:00 - 13:00</td>
                          <td>Enfermedad</td>
                        </tr>
                        <tr>
                          <td>Raheem Lehner</td>
                          <td>15/03/2023 12:00 - 13:00</td>
                          <td>Otros</td>
                        </tr>
                      </tbody>
                    </table>

                </div>

                <!-- End Default Table Example -->
            </div>
        </div>
          <!-- QR -->
          <div class="col-1" style="text-align: center; display: inline;">
              <h3 style="margin-top: 40px; margin-left: -10px;">¡Escanéame!</h3>
              <br>
              <img src="assets/img/qr.png" class="rounded float-right shadow-lg" alt="QR" style="width: 160px; margin-left: -10px;">
          </div>
        </div>

      </div>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

      <script>

        const time = document.getElementById('reloj');
        const date = document.getElementById('fecha');
        const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
          "Octubre", "Noviembre", "Diciembre"];
        
        const interval = setInterval(() => {
          const local = new Date();

          let day = local.getDate(),
            month = local.getMonth(),
            year = local.getFullYear();

          time.innerHTML = local.toLocaleTimeString();
          date.innerHTML = `${day} ${meses[month]} ${year}`;
        
        }, 1000);

      </script>

    </body>
</html>
