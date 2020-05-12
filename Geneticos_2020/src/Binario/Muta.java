package Binario;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class Muta {
    
    public static void aplicarMutaAleatoria(Individuo p){
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);
        if (p.getGenotipo()[pos]==1) {
            p.getGenotipo()[pos]=0;
        }else{
            p.getGenotipo()[pos]=1;
        }
        //Actualizar el genotipo, fenotipo y fitnnes
        p.calcularfitness();
    }
}
