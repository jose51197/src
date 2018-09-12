/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Jose Gonzalez
 */
public class CodigoTelefonico implements Codificable{
    private ArrayList<ArrayList<String>> simbolosEquivalentes;


    public void distruibuirLetras(Alfabeto alfabeto){
        
        
    }

    @Override
    public String codificar(String entrada, Alfabeto alfabeto) {
        return "codificacion Telefonica";
    }

    @Override
    public String decodificar(String entrada, Alfabeto alfabeto) {
        return "decodificacion Telefonica";
    }

    @Override
    public boolean seleccionar() {
        return true;
    }

    @Override
    public String solicitarDatosExtra() {
        return "nada";
    }
    @Override
    public String toString(){
        return "Tipo de codificacion: Telefonico";
    }
}
