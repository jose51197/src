/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author oscortes12
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public abstract class Archivo {
    protected String nombre;
    protected String carpeta;
    

    public Archivo(String pNombre, String pCarpeta) {
        this.nombre = pNombre;
        this.carpeta = pCarpeta;
    }
    
    public Archivo(String pNombre) {
        this(pNombre, "Impresiones");
  
    }
    
    public Archivo() {
        this("Bitacora", "Impresiones");
  
    }
    
    protected boolean crearArchivo(String pExtension){
        File tCarpeta = new File(this.carpeta);
        if (!tCarpeta.exists())
            crearCarpeta(tCarpeta);
            
        try {
            PrintWriter out = new PrintWriter(new File("").getAbsolutePath()+"//"+ this.carpeta +"//"+ this.nombre + pExtension);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
        
    }
    
    protected boolean crearCarpeta(File pCarpeta){
        try{
            pCarpeta.mkdir();
        } 
        catch(SecurityException e){
            System.out.println(e.toString());
            return false;
        } 
        return true;
    }
    
    
    public abstract void guardarCambios(String pTexto, String pCodificacion);
    
    
}
