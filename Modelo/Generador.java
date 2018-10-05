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
    public List<Character> caracteres;
    public List<Integer> indices;
    public int largo;
    
    public String tiraUno(int pLargo){
        String textoGenerado = "";
        List<Integer> indicesCopia = new ArrayList();
        Collections.copy(indicesCopia, this.indices);
        Random rand = new Random();
        int randIndex;
        char last, current;
        
        randIndex = rand.nextInt(indices.size() + 1);
        last = this.caracteres.get( indices.get(randIndex) );
            
        textoGenerado+= last;
            
        indices.remove(randIndex);
            
        for (int agregados = 1; agregados < pLargo; agregados++){
            randIndex = rand.nextInt(indices.size() + 1);
            current = this.caracteres.get( indices.get(randIndex) );
            
            if (current == last + 1 ){
                if (indices.size() == 1) 
                    textoGenerado = current + textoGenerado;
                else
                    continue;
            }
            last = current;
            textoGenerado+= this.caracteres.get( indices.get(randIndex) );
            indices.remove(randIndex);
        }
        
        return textoGenerado;
    }
    
    public String tiraDos(int pLargo){
        String textoGenerado = "";
        List<Integer> indicesCopia = new ArrayList();
        Collections.copy(indicesCopia, this.indices);
        Random rand = new Random();
        int randIndex;
        
        for (int agregados = 0; agregados < pLargo; agregados++){
            randIndex = rand.nextInt(indices.size() + 1);
            textoGenerado+= this.caracteres.get( indices.get(randIndex) );
            indices.remove(randIndex);
        }
        
        return textoGenerado;
    }
    
    public String tiraTres(int pLargo){
        String textoGenerado = "";
        List<Integer> indicesCopia = new ArrayList();
        Collections.copy(indicesCopia, this.indices);
        Random rand = new Random();
        int randIndex;
        
        for (int agregados = 0; agregados < pLargo; agregados++){
            randIndex = rand.nextInt(indices.size() + 1);
            textoGenerado+= this.caracteres.get( indices.get(randIndex) );
        }
        
        return textoGenerado;
    }
}
