/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jose5
 */
public class Generador {
    public List<String> caracteres;
    public List<Integer> indices;
    public int largo;
    
    public Generador (Alfabeto pAlfabeto){
        this.caracteres = pAlfabeto.getSimbolos();
        this.largo = this.caracteres.size();
        this.indices = new ArrayList() {{ for (int i = 0; i < largo; i++) add(i); }};
        
        System.out.println("Iniciado");
        
        System.out.println("No repetidos ni consecutivos");
        System.out.println(tiraUno(largo));
        
        
        System.out.println("Redneck");
        System.out.println(tiraTres(largo));
        
        System.out.println("No repetidos");
        System.out.println(tiraDos(largo));
        
        
    }
    
    public String tiraUno(int pLargo){
        String textoGenerado = "";
        ArrayList<Integer> indicesCopia = new ArrayList(this.indices);
        Random rand = new Random();
        int randIndex;
        char last, current;
        
        randIndex = rand.nextInt(indicesCopia.size());
        last = this.caracteres.get( indicesCopia.get(randIndex) ).charAt(0);
            
        textoGenerado+= last;
        indicesCopia.remove( indicesCopia.get(randIndex));
            
        for (int agregados = 1; agregados < pLargo; agregados++){
            randIndex = rand.nextInt(indicesCopia.size());
            current = this.caracteres.get( indicesCopia.get(randIndex) ).charAt(0);
            
            if (current == last + 1 ){
                if (indicesCopia.size() == 1) 
                    textoGenerado = current + textoGenerado;
                else
                    continue;
            }
            
            last = current;
            textoGenerado+= current ;
            indicesCopia.remove( indicesCopia.get(randIndex));
        }
        
        return textoGenerado;
    }
    
    public String tiraDos(int pLargo){
        String textoGenerado = "";
        ArrayList<Integer> indicesCopia = new ArrayList(this.indices);
      
        Random rand = new Random();
        int randIndex;
        
        for (int agregados = 0; agregados < pLargo; agregados++){
            randIndex = rand.nextInt(indicesCopia.size());
            textoGenerado+= this.caracteres.get( indicesCopia.get(randIndex) );
            indicesCopia.remove( indicesCopia.get(randIndex));
        }
        
        return textoGenerado;
    }
    
    public String tiraTres(int pLargo){
        String textoGenerado = "";
        ArrayList<Integer> indicesCopia = new ArrayList(this.indices);
     
        Random rand = new Random();
        int randIndex;
        
        for (int agregados = 0; agregados < pLargo; agregados++){
            randIndex = rand.nextInt(indicesCopia.size());
            textoGenerado+= this.caracteres.get( indicesCopia.get(randIndex) );
        }
        
        return textoGenerado;
    }
}
