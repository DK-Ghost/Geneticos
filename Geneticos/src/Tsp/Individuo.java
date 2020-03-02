
package Tsp;

import java.util.ArrayList;
import java.util.Random;

public class Individuo{

    public static int[][] matrizDistancias;

    private int [] genotipo;
    private int fitness;

    public Individuo(int ci, int n){
        genotipo = new int[n];
        genotipo[0]=ci;
        inicializarAleatoriamente();
        calcularFitness();
        
    }
    public Individuo(int[] genotipo){
        this.genotipo = genotipo.clone();
        calcularFitness();


    }
    public void calcularFitness(){
        if(matrizDistancias!=null){
            this.fitness = 0;
            // recorremos el genotipo 
            for(int x=0; x<this.genotipo.length-2;x++){
                int d = matrizDistancias[this.genotipo[x]][this.genotipo[x+1]];  
                this.fitness+= d;

            }
            this.fitness+= matrizDistancias[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];

        }
        
    }
    public void inicializarAleatoriamente(){
        ArrayList<Integer> ciudades = new ArrayList<>();
        for(int x =0; x < genotipo.length; x++){
            ciudades.add(x);
        }
        ciudades.remove(this.genotipo[0]);
        Random ran = new Random();
        // llenar los espacios vacios restantes del genotipo 
        for(int x=1; x<genotipo.length;x++){
            int pos = ran.nextInt(ciudades.size());
            int c = ciudades.get(pos);
            this.genotipo[x] = c;
            // eliminamos de las ciudades
            ciudades.remove(pos);
        }

    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }
    
    


}