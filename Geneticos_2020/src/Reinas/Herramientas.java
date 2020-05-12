/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

/**
 *
 * @author AngelNava
 */
public class Herramientas {
    public static void mostrarIstancias(Poblacion p){
        for (int i = 0; i < p.getPoblacion().size(); i++) {
            System.out.println(p.getPoblacion().get(i).toString()); 
        }
    }
}
