<%-- 
    Document   : consultarguagua
    Created on : 9 mar 2023, 9:43:15
    Author     : Manuel
--%>


<%@page import="java.util.Collections"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Scraper.Scraper"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiempo de espera (Guaguas Municipales)</title>
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
                    <h1 class="text-center">Tiempo de espera (Guaguas Municipales)</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <table class="table table-striped text-center">
                        <thead>
                            <th>LINEA</th>
                            <th>DESTINO</th>
                            <th>PARADA</th>
                        </thead>
                        <tbody>
                            
                        </tbody>
                    </table>
                </div>
            </div>
            <%
                                Scraper scraper = new Scraper();
                                ArrayList<HashMap<String,String>> contenido439 = scraper.Scraping439();
                                ArrayList<HashMap<String,String>> contenido419 = scraper.Scraping419();
                                
                                ArrayList<HashMap<String,String>> total = scraper.ScrapingTotal();
                                
                                
                                int num = contenido439.size();
                                String info = "";
                                int i = 0;
                                for(HashMap<String,String> cada:  total){
                                    String[] separar = cada.get("tiempo" + i).split(" ");
                                    int cuantoqueda = Integer.parseInt(separar[0]);
                                %>
                                <p> 
                                    <%=cada.get("titulo")%> 
                                </p>
                                <p> 
                                    <%=cada.get("linea" + i)%> 
                                </p>   
                                <p> 
                                    <%=cada.get("parada" + i)%> 
                                </p>
                                    
                                <p> 
                                    <%=cada.get("tiempo" + i)%> 
                                </p>
                                <%  i++; } 
                                
                                
                                %>
                                
                        </p>
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
    
        <script>
            setInterval(function() {
            location.reload();
            }, 5000);
        </script>
    </body>
</html>
