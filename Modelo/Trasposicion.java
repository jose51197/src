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
 * 
 * clase que se encarga de codificar o decodificar en forma de transposicion
 */
public class Trasposicion implements Codificable{
    
    //codificador
    @Override
    public String codificar(String entrada, Alfabeto alfabeto) {
        try{
        String resultado="";
        String palabraTemp="";
        for( int i = 0; i<entrada.length(); i++) {
            char c = entrada.charAt(i);
            if(c==' '){
                resultado+=palabraTemp+c;
                palabraTemp="";
                continue;
            }
            palabraTemp=c+palabraTemp;
        }
        resultado+=palabraTemp;
        return resultado;
        }
        catch(Exception e){
            return "Vale por una codificacion: Trasposicion";
        }
    }

    //decodificador
    @Override
    public String decodificar(String entrada, Alfabeto alfabeto) {
        try{
        String resultado="";
        String palabraTemp="";
        for( int i = 0; i<entrada.length(); i++) {
            char c = entrada.charAt(i);
            if(c==' '){
                resultado+=palabraTemp+c;
                palabraTemp="";
                continue;
            }
            palabraTemp=c+palabraTemp;
        }
        resultado+=palabraTemp;
        return resultado;
        }
        catch(Exception e){
            return "Vale por una decodificacion: Trasposicion";
        }
    }

    //funcion que de nota que se necesitan datos extra, en este caso no se necesita
    @Override
    public boolean seleccionar() {
        return true;
    }
    
    //funcion que de dice cuales son los datos que se necesitan extra, como no se necesita niguno queda un pklace holder solo para seguir con la interfaz
    @Override
    public String solicitarDatosExtra() {
        return "nada";
    }
    @Override
    public String toString(){
        return "Tipo de codificacion: Trasposicion";
    }

    @Override
    public void setDatosExtra(String datos) {
       
    }
}
