/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import Modelo.Imprimir;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose5
 */
public class DaoAlfabetos {
    
    private List<Alfabeto> datos;
    Imprimir imprimir;
    
    public DaoAlfabetos(){
        this.datos = new ArrayList<>();
        this.imprimir = new Imprimir("alfabetos");
    }
    
    public void cargarDatos() {
        this.datos = new ArrayList<>();
        BufferedReader bufferLectura;
        
        try {
            bufferLectura = new BufferedReader(new FileReader("alfabetos.txt"));
            String linea;
            
            while((linea = bufferLectura.readLine()) != null){
                String columnas[] = linea.split(";");
                //Pendiente a cambiar
                ArrayList tCaracteres = new ArrayList<>();
                for (int lecturaCaracter = 2; lecturaCaracter < columnas.length; lecturaCaracter++)
                    tCaracteres.add(columnas[lecturaCaracter]);
                this.datos.add(new Alfabeto(Integer.parseInt(columnas[0]), columnas[1], tCaracteres ));
                System.out.println(linea);
            }

            bufferLectura.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public boolean actualizarDatos(int pId, Alfabeto pAlfabeto){
    
        for(Alfabeto alfabetoActual : this.datos){
            if (alfabetoActual.getId() == pId){
                alfabetoActual.setNombre(pAlfabeto.getNombre());
                alfabetoActual.setSimbolos(pAlfabeto.getSimbolos());
                return true;
            }
       
        }
        
        actualizarArchivo();
        
        //Guardar datos en un txt
        return false;
    }
    
    public boolean borrarDatos(int pId){
        for(Alfabeto alfabetoActual : this.datos){
            if (alfabetoActual.getId() == pId){
                this.datos.remove(alfabetoActual);
                return true;
            }
       
        }
        
        actualizarArchivo();
        
        //Guardar datos en un txt
        return false;
    }
    
    public boolean agregarDatos(Alfabeto pAlfabeto){
        if (getAlfabeto(pAlfabeto.getId()) == null)
            return false;
        this.datos.add(pAlfabeto);
        
        actualizarArchivo();
        //Guardar datos en un txt
        return true;
    }
    
    public Alfabeto getAlfabeto(int pId){
        for(Alfabeto alfabetoActual : this.datos){
            if (alfabetoActual.getId() == pId)
                return alfabetoActual;
        }
        
        return null;
    }
    
    
    private void actualizarArchivo(){
        String datosTXT = "";
        
        for(Alfabeto alfabetoActual : this.datos){
            datosTXT += Integer.toString(alfabetoActual.getId());
            datosTXT += ";" + alfabetoActual.getNombre();
            
            //Guarda cada caracteres dentro del csv
            for (String caracterActual : alfabetoActual.getSimbolos())
                datosTXT += ";" + caracterActual;
           
            datosTXT += "\n";
        }
        

        try(FileWriter fw = new FileWriter("alfabeto.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(datosTXT.substring(0, datosTXT.length()-1));
            out.close();
           
        } catch (IOException e) {
            System.out.println(e.toString());
            crearArchivo(datosTXT.substring(0, datosTXT.length()-1));
        }

    }
    
    private void crearArchivo(String pDatos){
        try {
            PrintWriter out = new PrintWriter("alfabeto.txt");
            out.println(pDatos);
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    

    public List<Alfabeto> getDatos() {
        return this.datos;
    }
    
}