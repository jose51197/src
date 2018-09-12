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

/**
 *
 * @author jose5
 */
public class Imprimir {
    String nombre;
    

    public Imprimir(String pNombre) {
        this.nombre = pNombre;
    }
    
    public void crearNuevoArchivo(String pTexto, String extension){
        try {
            PrintWriter out = new PrintWriter(new File(".").getAbsolutePath()+"//output//"+ this.nombre + "."+extension);
            out.println(pTexto);
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void guardarTXT(String pTexto) {
        
        try(FileWriter fw = new FileWriter("output//"+this.nombre + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(pTexto);
            out.close();
           
        } catch (IOException e) {
            crearNuevoArchivo(pTexto, ".txt");
            e.toString();
            //exception handling left as an exercise for the reader
        }
    }
    
    
    public void guardarXML(){
        
    }
    
    public void guardarPDF(){
        
    }
    
}
