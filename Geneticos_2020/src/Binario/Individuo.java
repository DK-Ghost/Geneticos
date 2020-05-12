package Binario;

import static java.lang.Math.pow;
import java.util.Random;

/**
 * @author DK Ghost
 */
public class Individuo {

    private int genotipo[];
    private long fenotipo;
    private long fitness;

    public Individuo(int n) {
        this.genotipo = new int[n];
        InicializarRandom();
        calcularfitness();
    }

    public Individuo(int[] aux) {
        this.genotipo = aux.clone();
        calcularfitness();
    }

    public void InicializarRandom() {
        Random r = new Random();
        for (int i = 0; i < this.genotipo.length; i++) {
            this.genotipo[i] = r.nextInt(2);
        }
    }

    public void calcularfitness() {
        calcularfenotipo();
        //Evaluar el fenotipo en la funcion deseada(fitness [(2x^2)+x+1])     
//        this.fitness = (2 * this.fenotipo * this.fenotipo) + this.fenotipo + 1;
        //Evalaua el fenoptipo en la funvcion deseada(x^2)-2x
        this.fitness = (this.fenotipo * this.fenotipo) +2 * this.fenotipo+5;
//        this.fitness = this.fenotipo+1;
    }

    private void calcularfenotipo() {
        //Decodificacion del genotipo
        this.fenotipo = 0;

        for (int i = 0; i < this.genotipo.length; i++) {
            if (this.genotipo[i] == 1) {
                this.fenotipo += pow(2, this.genotipo.length - i - 1);
            }
        }
    }

    public long getFenotipo() {
        return fenotipo;
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public long getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return "Individuo{" + "fenotipo = " + fenotipo + ", fitness = " + fitness + '}';
    }
    
    

}
