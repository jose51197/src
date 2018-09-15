/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;

/**
 *
 * @author Oscar
 */
public class Imprimir {
    private String nombre;

    public Imprimir(String pNombre) {
        this.nombre = pNombre;
    }
    
    public boolean crearNuevoArchivo(String extension){
        try {
            PrintWriter out = new PrintWriter(new File("").getAbsolutePath()+"//impresiones//"+ this.nombre + "."+extension);
            out.println("");
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
        
    }
    
    public void guardarTXT(String pTexto, String pCodificacion) {
        
        try(FileWriter fw = new FileWriter("impresiones//"+this.nombre + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("\n+++---+++---+++---+++---+++---+++---+++---\n");
            out.println("Codificacion: " + pCodificacion);
            out.println("Fecha: " + new Date().toString());
            out.println("Texto: " + pTexto);
            out.close();
           
        } catch (IOException e) {
            if (crearNuevoArchivo("txt"))
                guardarTXT(pTexto, pCodificacion);
            e.toString();
            //exception handling left as an exercise for the reader
        }
    }
    
    
    public void guardarXML(String pTexto, String pCodificacion){
        try(FileWriter fw = new FileWriter("impresiones//"+this.nombre + ".xml", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("<codificacion>");
            
            out.println("\t<metodo>" + pCodificacion+ "</metodo>");
            out.println("\t<fecha>" + new Date().toString() + "</fecha>");
            out.println("\t<texto>" + pTexto + "</texto>");
            out.println("</codificacion>");
            out.close();
           
        } catch (IOException e) {
            if (crearNuevoArchivo("xml"))
                guardarXML(pTexto,pCodificacion);
            e.toString();
            //exception handling left as an exercise for the reader
        }
    }
    
    public void guardarPDF(String pTexto, String pCodificacion){
        
        //byte[] entityBytes = this.nombre.getBytes();
        //Files.write("test.pdf", entityBytes);
    }
    
}
