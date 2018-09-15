/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Codificable;
import Modelo.CodigoTelefonico;
import Modelo.Trasposicion;
import Modelo.Vigenere;
import java.util.Scanner;

/**
 *
 * @author oscortes12
 */
public class Consola {
    Codificable codificador;
    
    public void desplegarOpciones(){
        String texto;
        int opcion;
        
        Scanner lector = new Scanner(System.in);
        
        
        System.out.println("Menu v0.1");
        
        while(true){
            System.out.println("Elija el metodo de codificación.");
            System.out.println("1) Telefono");
            System.out.println("2) Vigenere");
            System.out.println("3) Transposicion");
            System.out.println("0) Salir del programa");

            opcion = Integer.parseInt( lector.nextLine());
            
            if (opcion == 0)
                break;
   
            System.out.println("Ingrese el texto");
            texto =  lector.nextLine();


            definirCodificador(opcion);


            System.out.println("¿Va a codificar o decodificar?");
            System.out.println("1) Codificar");
            System.out.println("2) Decodificar");

            opcion = Integer.parseInt( lector.nextLine());
            if (opcion == 1)
                System.out.println("Codificando");
            else if (opcion == 2)
                System.out.println("Decodificando");
        }
        
    }
    
    public boolean definirCodificador(int pValor){
        switch (pValor){
            case 1:
                this.codificador = new CodigoTelefonico();
                break;
            case 2:
                this.codificador = new Vigenere();
                break;
            case 3:
                this.codificador = new Trasposicion();
                break;
            default:
               return false;
        }
        return true;
    }
}
