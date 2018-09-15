/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author sergiesalas
 * lo usare para la decodificacion
 */
public class DTOCodificacion {
    private int idAlfabeto;
    private String entrada;
    private String salida;
    private int opcionImprimir;
    private Archivo escogido;

    public Archivo getEscogido() {
        return escogido;
    }
    
    
    
    public void setImpresion(int opcion, JRootPane root){
        String nombre = JOptionPane.showInputDialog(root, "Nombre archivo","");
        if(nombre==null){
            escogido=null;
        }
        switch(opcion){
            case 0: escogido = new PDF(nombre);break;
            case 1: escogido = new TXT(nombre);break;
            case 2: escogido = new XML(nombre);break;
        }
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
}
