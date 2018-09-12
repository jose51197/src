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
public class Alfabeto {
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
    
    
    
}
