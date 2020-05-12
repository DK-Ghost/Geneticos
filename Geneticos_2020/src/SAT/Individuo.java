package SAT;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AngelNava
 */
public class Individuo {
    
    public int[] genotipo;
    public int fitness;
    
    public Individuo(int n){
        this.genotipo = new int[n];
        this.fitness = 0;
        iniciarRandom();
//        iniciarUnos();
        calcularFitness();
    }
    
    public Individuo(int[] gen){
        this.genotipo = gen;
        this.fitness = 0;
        calcularFitness();
    }

    private void calcularFitness() {
        //Recorrer las clausulas
        for (int i = 1; i < Tokenizacion.clausulas.size(); i++) {
            int[] aux = Tokenizacion.clausulas.get(i).getClausula();
            //validar la clausula
            this.fitness += validar(aux);          
        }
    }
    
    private void iniciarUnos(){
        for (int i = 0; i < genotipo.length; i++) {
            this.genotipo[i] = 1;
        }  
    }

    private void iniciarRandom() {
        Random r = new Random();
        for (int i = 0; i < genotipo.length; i++) {
            this.genotipo[i] = r.nextInt(2);
        }
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    private int validar(int[] aux) {
        //Recorrer la clausula
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] < 1) {
                //Si es negada valida con 0
                if (genotipo[abs(aux[i])-1] == 0) {
                return 1;
                }
            }else{
                //Si no es negada valida con 1
                if (genotipo[abs(aux[i])-1] == 1) {
                return 1;
                }
            }  
        }     
        return 0;
    }

    public int getFitness() {
        return fitness;
    }
    
    

    @Override
    public String toString() {
        return "Individuo{fitness=" + fitness + "}";
    }

}
