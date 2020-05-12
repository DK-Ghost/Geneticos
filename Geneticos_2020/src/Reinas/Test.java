/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import java.util.LinkedList;

/**
 *
 * @author AngelNava
 */
public class Test {
    
    public static void main(String ags[]){
        
        Genetico g1 = new Genetico(100000,200,2d,10);
        g1.evolucionar();
        Herramientas.mostrarIstancias(g1.getPobActual());
    }
}
