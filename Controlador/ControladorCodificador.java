/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;
import java.util.Date;
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
    private ArrayList<String> metodos;
    private ArrayList<String> salida;
    private String[] impresiones = new String[3];
    private Alfabeto alfabeto;
    private DTOCodificacion dto;
    
    public ControladorCodificador() {
        
        //Codificaciones
        codificaciones.add(new CodigoTelefonico());
        codificaciones.add(new Trasposicion());
        codificaciones.add(new Vigenere());
        
        //Impresiones
        impresiones[0]="PDF";
        impresiones[1]="TXT";
        impresiones[2]="XML";
        
        
        DaoAlfabetos dao= new DaoAlfabetos();
        dao.cargarDatos();
        
        //Definir alfabeto standard
        alfabeto=dao.getAlfabeto(1);
        alfabeto.toString();
    }

    public void setDto(DTOCodificacion dto) {
        this.dto = dto;
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
    
    public String[] getImpresiones(){
        return impresiones;
    }
    
    public void imprimir(){
        if(dto.getEscogido()==null){
            return;
        }
        for(int i=0;i<seleccionadas.size();i++){
            dto.getEscogido().guardarCambios(metodos.get(i),salida.get(i));
        }
    }
    
    
    public DefaultListModel getSeleccionadas(){
       DefaultListModel model = new DefaultListModel();
       for(int i =0;i<seleccionadas.size();i++){
           model.addElement(seleccionadas.get(i).toString());
       }
       return model;
    }
    
    public String codificar(){
        
       if(!alfabeto.validar(dto.getEntrada())){
           return "Alfabeto no valido";
       }
       
       String result="";
       String all="";
       all+=new Date().toString()+"\n";
       metodos=new ArrayList<>();
       salida=new ArrayList<>();
       
       
       
       
       for(int i =0;i<seleccionadas.size();i++){
           result=seleccionadas.get(i).codificar(dto.getEntrada(), alfabeto) + "\n";
           metodos.add(seleccionadas.get(i).toString());
           salida.add(result);
           all+=seleccionadas.get(i).toString() + "\n" +result;
       }
       return all;
    }
    
    public String deCodificar(){
       
       if(seleccionadas.size()==1){
           return seleccionadas.get(0).decodificar(dto.getSalida(), alfabeto);
       }else{
           return "Solo 1 metodo para decodificar";
       }
    }
    
   
    
    private String[] getStringFromArray(ArrayList<Codificable> objects){
       String[] nombres=new String[objects.size()];
       for(int i =0;i<objects.size();i++){
           nombres[i] = objects.get(i).toString();
       }
       return nombres;
    }

}
