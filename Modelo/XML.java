/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author oscortes12
 */
public class XML extends Archivo{
    private static final String EXTENSION = ".xml"; 
    
    public XML(String pNombre, String pCarpeta) {
        super(pNombre, pCarpeta);
    }
    
    public XML(String pNombre) {
        super(pNombre);
    }
    
    public XML() {
        super();
    }

    @Override
    public void guardarCambios(String pTexto, String pCodificacion) {
        try(FileWriter fw = new FileWriter(this.carpeta + "//"+this.nombre + EXTENSION, true);
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
            if (crearArchivo(EXTENSION))
                guardarCambios(pTexto,pCodificacion);
            e.toString();
            //exception handling left as an exercise for the reader
        }
    }
    
}
