/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jose5
 */
public class Generador {
    public List<Character> caracteres;
    public List<Integer> indices;
    public short largo;
    
    public String tiraUno(){
        List<Integer> indicesCopia = new ArrayList();
        Collections.copy(indicesCopia, this.indices);
        
        
       
        return "";
    }
    
    public String tiraDos(){
        List<Integer> indicesCopia = new ArrayList();
        Collections.copy(indicesCopia, this.indices);
       
        return "";
    }
    
    public String tiraTres(){
        List<Integer> indicesCopia = new ArrayList();
        Collections.copy(indicesCopia, this.indices);
        return "";
    }
}
