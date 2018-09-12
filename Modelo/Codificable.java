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
 * interfaz que debe ser implementada en todos los algoritmos para codificar.
 */
public interface Codificable {
    public String codificar(String entrada, Alfabeto alfabeto);
    public String decodificar(String entrada, Alfabeto alfabeto);
    public boolean seleccionar();
    public String solicitarDatosExtra();
    public void setDatosExtra(String datos);
}
