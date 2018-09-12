/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose5
 */
public class DaoAlfabetos {
    
    List<Alfabeto> datos;
    
    public DaoAlfabetos(){
        this.datos = new ArrayList<>(); 
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
                this.datos.add(new Alfabeto(Integer.parseInt(columnas[0]), columnas[1],  new ArrayList(){{add(columnas[2]);}} ));
                System.out.println(linea);
            }

            bufferLectura.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
}