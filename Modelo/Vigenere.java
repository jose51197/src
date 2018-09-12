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
 * clase que codifica mensajes Vigenere
 */
public class Vigenere implements Codificable{

    private String datosExtra;
    
    //codificador
    @Override
    public String codificar(String entrada, Alfabeto alfabeto) {
        int indexDatosExtra=0;
        int offset=0;
        ArrayList<String> simbolos= alfabeto.getSimbolos();
        String resultado="";
        int indexSimbolos=0;
        for( int i = 0; i<entrada.length(); i++) {
            char c = entrada.charAt(i);
            if(c==' '){
                resultado+=c;
                continue;
            }
            offset=Character.getNumericValue(this.datosExtra.charAt(indexDatosExtra));
            indexDatosExtra++;
            if(indexDatosExtra==this.datosExtra.length()){
                indexDatosExtra=0;
            }
            indexSimbolos=simbolos.indexOf(c)+offset;
            if(indexSimbolos>=simbolos.size()){
                indexSimbolos= indexSimbolos%(simbolos.size());
            }
            resultado+=simbolos.get(indexSimbolos);
            
        }
        return resultado;
    }
    
    //decodificador
    @Override
    public String decodificar(String entrada, Alfabeto alfabeto) {
        int indexDatosExtra=0;
        int offset=0;
        ArrayList<String> simbolos= alfabeto.getSimbolos();
        String resultado="";
        int indexSimbolos=0;
        for( int i = 0; i<entrada.length(); i++) {
            char c = entrada.charAt(i);
            if(c==' '){
                resultado+=c;
                continue;
            }
            offset=-Character.getNumericValue(this.datosExtra.charAt(indexDatosExtra));
            indexDatosExtra++;
            if(indexDatosExtra==this.datosExtra.length()){
                indexDatosExtra=0;
            }
            indexSimbolos=simbolos.indexOf(c)-offset;
            if(indexSimbolos<0){
                indexSimbolos= -indexSimbolos%(simbolos.size());
                if(indexSimbolos!=0){
                    indexSimbolos= simbolos.size()-indexSimbolos;
                }
            }
            resultado+=simbolos.get(indexSimbolos);
            
        }
        return resultado;
    }

    //funcion que de nota que se necesitan datos extra
    @Override
    public boolean seleccionar() {
        return false;
    }

    //funcion que de dice cuales son los datos que se necesitan extra
    @Override
    public String solicitarDatosExtra() {
        return "numero para codificacion";
    }
    
    @Override
    public void setDatosExtra(String datosExtra) {
        this.datosExtra = datosExtra;
    }
    
    @Override
    public String toString(){
        return "Tipo de codificacion: Vigenere";
    }
    
}
