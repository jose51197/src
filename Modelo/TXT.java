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
public class TXT extends Archivo{
    private static final String EXTENSION = ".txt"; 
    
    public TXT(String pNombre, String pCarpeta) {
        super(pNombre, pCarpeta);
    }
    
    public TXT(String pNombre) {
        super(pNombre);
    }
    
    public TXT() {
        super();
    }
    
    
    @Override
    public void guardarCambios(String pTexto, String pCodificacion) {
        
        //Se intenta abrir el archivo para insertar los nuevos datos
        try(FileWriter fw = new FileWriter(this.carpeta+"//"+ this.nombre + EXTENSION, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){

            out.println("Codificacion: " + pCodificacion);
            out.println("Fecha: " + new Date().toString());
            out.println("Texto: " + pTexto);
            out.close();
           
        } catch (IOException e) { 
            System.out.println(e.toString());
            
            if (super.crearArchivo(EXTENSION))           //Si el archivo no existe se crea
                this.guardarCambios(pTexto, pCodificacion);  //Una vez creado, se guardan los datos
            
            
        }
    }
    

}
