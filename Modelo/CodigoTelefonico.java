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
 * clase que codifica de tipo codigo telefonico
 */
public class CodigoTelefonico implements Codificable{
    private ArrayList<ArrayList<String>> simbolosEquivalentes;

    // funcion que segun el alfabeto distribuye los simbolos en las teclas
    private void distribuirLetras(Alfabeto alfabeto){
        int indexSimbolos=0;
        this.simbolosEquivalentes=new ArrayList<>();
        ArrayList<String> simbolos= alfabeto.getSimbolos();
        int distribucion=simbolos.size()/8;
        int overflow=8-(simbolos.size()%8);
        int indexAux=0;
        for(int i=0;i<=7;i++){
            simbolosEquivalentes.add(new ArrayList<>());
            indexAux=distribucion;
            if(i>=overflow){
                indexAux++;
            }
            while(indexAux!=0){
                simbolosEquivalentes.get(i).add(simbolos.get(indexSimbolos));
                indexAux--;
                indexSimbolos++;
            }
        }
    }
    
    //dado una char devuelve su posicion en las teclas del telefono
    private String obtenerValor (char entrada){
        if (entrada==' '){
            return "*";
        }
        if (entrada=='\n'){
            return "";
        }
        for(int i=0;i<=7;i++){
            ArrayList<String> lista= this.simbolosEquivalentes.get(i);
            for(int j=0;j<lista.size();j++){
                if(lista.get(j).equals(String.valueOf(entrada))){
                    return ' '+Integer.toString(i+2)+Integer.toString(j+1)+' ';
                }
            }
        }
        return "";
    }

    //codificador
    @Override
    public String codificar(String entrada, Alfabeto alfabeto) {
        try{
        distribuirLetras(alfabeto);
        String resultado="";
        for( int i = 0; i<entrada.length(); i++) {
            char c = entrada.charAt(i);
            resultado+= obtenerValor(c);
        }
        return resultado;
        }
        catch(Exception e){
            return "Vale por una codificacion:Codigo Telefonico";
        }
    }

    //decoficador
    @Override
    public String decodificar(String entrada, Alfabeto alfabeto) {
        System.out.println("llegue");
        try{
        distribuirLetras(alfabeto);
        String resultado="";
            
        for( int i = 0; i<entrada.length(); i++) {
            char c = entrada.charAt(i);
            if(c==' ' || c=='\n'){
                continue;
            }
            if(c=='*'){
                resultado+=' ';
                continue;
            }
            resultado+=simbolosEquivalentes.get(Character.valueOf(c)-2).get(Character.valueOf(entrada.charAt(i+1))-1);
            
            i++;
        }
        return resultado;
        }
        catch(Exception e){
            return "Vale por una decodificacion: Codigo Telefonico";
        }
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

    @Override
    public void setDatosExtra(String datos) {
        
    }
}
