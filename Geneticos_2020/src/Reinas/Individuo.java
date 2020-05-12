package Reinas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author AngelNava
 */
public class Individuo {

    private int[] genotipo;
    private int fitness;

    public Individuo(int n) {
        //Inicializar un Individuo con genotipo tamaño n (Random)
        this.genotipo = new int[n];
        inicializarRand();
        calcularFitness();
    }

    public Individuo(int[] g) {
        //Inicializar un Individuo en base a un genotipo
        this.genotipo = g;
        calcularFitness();
    }

    public void calcularFitness() {
        //Calcular el grado de bondad
        //Calcular ataques horizontales
        int cont = 0;
        for (int i = 0; i < genotipo.length; i++) {
            for (int j = 0; j < genotipo.length; j++) {
                if (i != j) {
                    if (this.genotipo[i] == this.genotipo[j]) {
                        cont += 1;
                    }
                    if (this.genotipo[i] - i == this.genotipo[j] - j) {
                        cont += 1;
                    }
                    if (this.genotipo[i] + i == this.genotipo[j] + j) {
                        cont += 1;
                    }
                }
            }
        }
        //Calcular ataques diagonales
        this.fitness = cont;
    }

    public void inicializarRand() {
        //Crear genotipo random
        Random r = new Random();
        for (int i = 0; i < this.genotipo.length; i++) {
            this.genotipo[i] = r.nextInt(this.genotipo.length);
        }
    }

    public void iniRandSinChoques() {
        //Crear Genotipo sin choques horizontales
        ArrayList<Integer> reinas = new ArrayList();
        for (int i = 0; i < this.genotipo.length; i++) {
            reinas.add(i);
        }

        Random r = new Random();
        int pos;

        for (int i = 0; i < this.genotipo.length; i++) {
            pos = r.nextInt(reinas.size());
            genotipo[i] = reinas.get(pos);
            reinas.remove(pos);
        }
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        return "Individuo{" + "genotipo =" + Arrays.toString(genotipo) + " , fitness =" + fitness + "}";
    }

}
