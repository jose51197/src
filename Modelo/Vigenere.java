/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author sergiesalas
 */
public class Vigenere implements Codificable{

    private String datosExtra;
    
    @Override
    public String codificar(String entrada, Alfabeto alfabeto) {
        return "codificacion Vigenere";
    }

    @Override
    public String decodificar(String entrada, Alfabeto alfabeto) {
        return "decodificacion Vigenere";
    }

    @Override
    public boolean seleccionar() {
        return true;
    }

    @Override
    public String solicitarDatosExtra() {
        return "numero para codificacion";
    }

    public void setDatosExtra(String datosExtra) {
        this.datosExtra = datosExtra;
    }
    
    @Override
    public String toString(){
        return "Tipo de codificacion: Vigenere Prueba";
    }
    
}
