/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binario;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class Seleccion {
    static Individuo seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
        int pos = ran.nextInt(pob.getPoblacion().size());
        return new Individuo(pob.getPoblacion().get(pos).getGenotipo());
    }
}
