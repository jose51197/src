/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Codificador;
import java.util.ArrayList;

/**
 *
 * @author jose5
 */
public class ControladorCodificador {
    private static Codificador vista;
    private static ArrayList<Codificable> codificaciones= new ArrayList<>();
    //private static ArrayList<Codificacion> codificaciones;
    
    public static void main(String[] args) {
        vista = new Codificador();
        vista.setVisible(true);
        //Aqui se meten las codificaciones
        codificaciones.add(new CodigoTelefonico());
        codificaciones.add(new Trasposicion());
        codificaciones.add(new Vigenere());
    }
    
    public void seleccionar(){
        
    }
    
    public void codificar(){
        
    }
    
    public void deCodificar(){
        
    }
    
    public void imprimir(){
        
    }
    
    
}
