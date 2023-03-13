/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scraper;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author daniel
 */
public class Scraper {
    
    
    public Scraper(){
        
    }
    
    public ArrayList<HashMap<String,String>> Scraping439() throws IOException{
        URL url = new URL("https://www.guaguas.com/js/ajax/consulta_tiempo_parada.php");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        con.setRequestProperty("authority", "www.guaguas.com");
        con.setRequestProperty("method", "POST");
        con.setRequestProperty("path", "/js/ajax/consulta_tiempo_parada.php");
        con.setRequestProperty("scheme", "https");
        con.setRequestProperty("accept", "*/*");
        con.setRequestProperty("accept-encoding", "gzip, deflate, sdch");
        con.setRequestProperty("accept-language", "es-ES,es;q=0.9");
        con.setRequestProperty("content-length", "11");
        con.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        con.setRequestProperty("origin", "https://www.guaguas.com");
        con.setRequestProperty("referer", "https://www.guaguas.com/lineas/proxima-guagua");
        con.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"110\", \"Not A(Brand\";v=\"24\", \"Google Chrome\";v=\"110\"");
        con.setRequestProperty("sec-ch-ua-mobile", "?0");
        con.setRequestProperty("sec-ch-ua-platform", "Windows");
        con.setRequestProperty("sec-fetch-dest", "empty");
        con.setRequestProperty("sec-fetch-mode", "cors");
        con.setRequestProperty("sec-fetch-site", "same-origin");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.setRequestProperty("x-requested-with", "XMLHttpRequest");
        
        con.setRequestMethod("POST");
        
        con.setDoOutput(true);
        
        
        String parametros = "paradas=439";
                
        OutputStream outputStream = con.getOutputStream();
        outputStream.write(parametros.getBytes());
        outputStream.flush();
        outputStream.close();
        
        // Leer la respuesta del servidor
        InputStream inputStream = con.getInputStream();
        if ("gzip".equals(con.getContentEncoding())) {
            inputStream = new GZIPInputStream(inputStream);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String linea;
        while ((linea = reader.readLine()) != null) {
            builder.append(linea);
        }
        reader.close();

        // Procesar la respuesta con jsoup
        Document doc = (Document) Jsoup.parse(builder.toString());
        Elements bbody = doc.select("body");
        String titulo = "";
        ArrayList<String> lTitulo = new ArrayList();
        
        for(Element tit: bbody){
            Elements span = doc.select("span#resp_linea");
            
            if(span.size() > 0){
                titulo = span.text();
                lTitulo.add(titulo);
            }           
        }
       
        
        
        Elements body = doc.select("tbody");
        Elements rows = body.select("tr");
        
        String nombre = "";
        String destino = "";
        String tiempo = "";    
        
        ArrayList<String> lNombre = new ArrayList();
        ArrayList<String> lDestino = new ArrayList();
        ArrayList<String> lTiempo = new ArrayList();
        
        for(Element row: rows){
            Elements tds = row.select("td");
            if(tds.size() > 0){
                nombre = tds.get(0).text();
                destino = tds.get(1).text();
                tiempo = tds.get(2).text();
                
                lNombre.add(nombre);
                lDestino.add(destino);
                lTiempo.add(tiempo);
            }
        }   
        
        System.out.println("Nombre Linea: " + lTitulo.toString());
        System.out.println("Num Linea: " + lNombre.toString());
        System.out.println("Destino " + lDestino.toString());
        System.out.println("Tiempo " + lTiempo.toString());
        
        
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        HashMap<String, String> hash = new HashMap<>();
        
        hash.put("titulo", lTitulo.get(0));
        
        for(int i=0; i<lNombre.size(); i++){
            
            //hash.put("titulo" + String.valueOf(i), lTitulo.get(i));
                        
            hash.put("linea" + String.valueOf(i), lNombre.get(i));
            hash.put("parada" + String.valueOf(i), lDestino.get(i));
            hash.put("tiempo" + String.valueOf(i), lTiempo.get(i));
            arrayList.add(hash);
        }
        System.out.println(arrayList.size());
        return arrayList;
    }
    
    public ArrayList<HashMap<String,String>> Scraping419() throws IOException{
        URL url = new URL("https://www.guaguas.com/js/ajax/consulta_tiempo_parada.php");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        con.setRequestProperty("authority", "www.guaguas.com");
        con.setRequestProperty("method", "POST");
        con.setRequestProperty("path", "/js/ajax/consulta_tiempo_parada.php");
        con.setRequestProperty("scheme", "https");
        con.setRequestProperty("accept", "*/*");
        con.setRequestProperty("accept-encoding", "gzip, deflate, sdch");
        con.setRequestProperty("accept-language", "es-ES,es;q=0.9");
        con.setRequestProperty("content-length", "11");
        con.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        con.setRequestProperty("origin", "https://www.guaguas.com");
        con.setRequestProperty("referer", "https://www.guaguas.com/lineas/proxima-guagua");
        con.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"110\", \"Not A(Brand\";v=\"24\", \"Google Chrome\";v=\"110\"");
        con.setRequestProperty("sec-ch-ua-mobile", "?0");
        con.setRequestProperty("sec-ch-ua-platform", "Windows");
        con.setRequestProperty("sec-fetch-dest", "empty");
        con.setRequestProperty("sec-fetch-mode", "cors");
        con.setRequestProperty("sec-fetch-site", "same-origin");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.setRequestProperty("x-requested-with", "XMLHttpRequest");
        
        con.setRequestMethod("POST");
        
        con.setDoOutput(true);
        
        
        String parametros = "paradas=419";
                
        OutputStream outputStream = con.getOutputStream();
        outputStream.write(parametros.getBytes());
        outputStream.flush();
        outputStream.close();
        
        // Leer la respuesta del servidor
        InputStream inputStream = con.getInputStream();
        if ("gzip".equals(con.getContentEncoding())) {
            inputStream = new GZIPInputStream(inputStream);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String linea;
        while ((linea = reader.readLine()) != null) {
            builder.append(linea);
        }
        reader.close();

        // Procesar la respuesta con jsoup
        Document doc = (Document) Jsoup.parse(builder.toString());
        Elements bbody = doc.select("body");
        String titulo = "";
        ArrayList<String> lTitulo = new ArrayList();
        
        for(Element tit: bbody){
            Elements span = doc.select("span#resp_linea");
            
            if(span.size() > 0){
                titulo = span.text();
                lTitulo.add(titulo);
            }           
        }
       
        
        
        Elements body = doc.select("tbody");
        Elements rows = body.select("tr");
        
        String nombre = "";
        String destino = "";
        String tiempo = "";    
        
        ArrayList<String> lNombre = new ArrayList();
        ArrayList<String> lDestino = new ArrayList();
        ArrayList<String> lTiempo = new ArrayList();
        
        for(Element row: rows){
            Elements tds = row.select("td");
            if(tds.size() > 0){
                nombre = tds.get(0).text();
                destino = tds.get(1).text();
                tiempo = tds.get(2).text();
                
                lNombre.add(nombre);
                lDestino.add(destino);
                lTiempo.add(tiempo);
            }
        }   
        
        System.out.println("Nombre Linea: " + lTitulo.toString());
        System.out.println("Num Linea: " + lNombre.toString());
        System.out.println("Destino " + lDestino.toString());
        System.out.println("Tiempo " + lTiempo.toString());
        
        
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        HashMap<String, String> hash = new HashMap<>();
        
        hash.put("titulo", lTitulo.get(0));
        
        for(int i=0; i<(lNombre.size()); i++){
            
            //hash.put("titulo" + String.valueOf(i), lTitulo.get(i));
                        
            hash.put("linea" + String.valueOf(i+Scraping439().size()), lNombre.get(i));
            hash.put("parada" + String.valueOf(i+Scraping439().size()), lDestino.get(i));
            hash.put("tiempo" + String.valueOf(i+Scraping439().size()), lTiempo.get(i));
            arrayList.add(hash);
        }
        System.out.println(arrayList.size());
        return arrayList;
    }
    
    public ArrayList<HashMap<String,String>> ScrapingTotal() throws IOException{
        
        ArrayList<HashMap<String,String>> total = new ArrayList();
        total.addAll(Scraping439());
        total.addAll(Scraping419());
        
        
        ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
        // Agregar elementos a la lista

        // Creamos el comparador
        Comparator<HashMap<String, String>> comparador = new Comparator<HashMap<String, String>>() {
        @Override
        public int compare(HashMap<String, String> map1, HashMap<String, String> map2) {
            for(int i=0; i<total.size(); i++){
                return map1.get("tiempo"+i).compareTo(map2.get("tiempo"));
            }
            return 0;
        }
        };

        // Ordenamos el ArrayList
        Collections.sort(lista, comparador);

        
        return total;
    }
    
}
