/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
    public final String ALFABETO_ESTANDAR = "1;Standard;a;b;c;d;e;f;g;h;i;j;k;l;m;n;o;p;q;r;s;t;u;v;w;r;s;t;u;v;w;x;y;z; ;A;B;C;D;E;F;G;H;I;J;K;L;M;N;O;P;Q;R;S;T;U;V;W;X;Y;Z";
    public final String NOMBRE_ARCHIVO = "alfabetos.txt";
    
    
    public DaoAlfabetos(){
        this.datos = new ArrayList<>();
    }
    
    public void cargarDatos() {
        this.datos = new ArrayList<>();
        BufferedReader bufferLectura;
        
        try {
            bufferLectura = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
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
            crearArchivo();
            cargarDatos();
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
        
        actualizarArchivo(pAlfabeto);
        
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
        
        //actualizarArchivo();
        //Elimnar de un db el alfabeto
        return false;
    }
    
    public boolean agregarDatos(Alfabeto pAlfabeto){
        if (getAlfabeto(pAlfabeto.getId()) == null)
            return false;
        this.datos.add(pAlfabeto);
        
        actualizarArchivo(pAlfabeto);
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
    
    
    private void actualizarArchivo(Alfabeto pAlfabeto){
        String datosTXT = parserAlfabeto(pAlfabeto);
      
        try {
            FileWriter fw = new FileWriter(NOMBRE_ARCHIVO, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(datosTXT);
       
        } catch (IOException e) {
            System.out.println(e.toString());
            crearArchivo();
            actualizarArchivo(pAlfabeto);
        } 
    }
    
    private void crearArchivo(){
        try {
            PrintWriter out = new PrintWriter(NOMBRE_ARCHIVO);
            out.println(ALFABETO_ESTANDAR);
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private String parserAlfabeto(Alfabeto pAlfabeto){
        String datosTXT = "";
        
        datosTXT += Integer.toString(pAlfabeto.getId());
        datosTXT += ";" + pAlfabeto.getNombre();

        //Guarda cada caracteres dentro del csv
        for (String caracterActual : pAlfabeto.getSimbolos())
            datosTXT += ";" + caracterActual;

        datosTXT += "\n";
        
        return datosTXT;
    }
    

    public List<Alfabeto> getDatos() {
        return this.datos;
    }
    
}