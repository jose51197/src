/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Validable;
import java.util.ArrayList;

/**
 *
 * @author sergiesalas
 */
public class Alfabeto implements Validable{
    private int id;
    private String nombre;
    private ArrayList<String> simbolos;

    public Alfabeto(int id, String nombre, ArrayList<String> simbolos) {
        this.id = id;
        this.nombre = nombre;
        this.simbolos = simbolos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getSimbolos() {
        return simbolos;
    }
    
    @Override
    public boolean validar(Object frase){
        char[] chars = ((String)frase).toCharArray();
        boolean estaba;
        for(int i=0; i<chars.length;i++){
            estaba=false;
            for(int j =0;j<simbolos.size();j++){
                if(simbolos.get(j).equals(String.valueOf(chars[i]))){
                    estaba=true;
                    break;
                }
            }
            if(!estaba){
                return false;
            }
        }
        return true;
        
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSimbolos(ArrayList<String> simbolos) {
        this.simbolos = simbolos;
    }
    
    public int getIndexSimbolo(char c){
        for(int i=0;i<this.simbolos.size();i++){
            if (String.valueOf(c).equals(simbolos.get(i))){
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public String toString(){
        String resultado = "ID: " + Integer.toString(this.id) + "\n";
        resultado += "Nombre: " + this.nombre + "\n";
        resultado += "Simbolos: ";

        for(int i=0;i<this.simbolos.size();i++){
            resultado+=simbolos.get(i);
        }
        return resultado;
    }
}

