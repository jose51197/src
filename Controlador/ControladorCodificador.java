/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Codificador;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author jose5
 */
public class ControladorCodificador {
    private ArrayList<Codificable> codificaciones= new ArrayList<>();
    private ArrayList<Codificable> seleccionadas = new ArrayList<>();
    private Alfabeto alfabeto;
    
    public ControladorCodificador() {
        codificaciones.add(new CodigoTelefonico());
        codificaciones.add(new Trasposicion());
        codificaciones.add(new Vigenere());
        DaoAlfabetos dao= new DaoAlfabetos();
        dao.cargarDatos();
        alfabeto=dao.getAlfabeto(1);
        alfabeto.toString();
    }
    
    
    public void seleccionar(int i,JRootPane root){
        Codificable seleccionado = codificaciones.get(i);
        if (!seleccionado.seleccionar()){
            String datos = JOptionPane.showInputDialog(root, seleccionado.solicitarDatosExtra(),"");
            if(datos==null){
                return;
            }
            
            seleccionado.setDatosExtra(datos);
        }
        seleccionadas.add(seleccionado);
    }
    
    public String[] getCodificaciones(){
       return getStringFromArray(codificaciones);
    }
    
    
    public DefaultListModel getSeleccionadas(){
       DefaultListModel model = new DefaultListModel();
       for(int i =0;i<seleccionadas.size();i++){
           model.addElement(seleccionadas.get(i).toString());
       }
       return model;
    }
    
    public String codificar(String text){
       String result="";
       for(int i =0;i<seleccionadas.size();i++){
           result+=seleccionadas.get(i).codificar(text, alfabeto) + "\n";
       }
       return result;
    }
    
    public String deCodificar(String text){
       return "por implementar";
    }
    
    public void imprimir(String texto){
       
    }
    
    private String[] getStringFromArray(ArrayList<Codificable> objects){
       String[] nombres=new String[objects.size()];
       for(int i =0;i<objects.size();i++){
           nombres[i] = objects.get(i).toString();
       }
       return nombres;
    }

}
