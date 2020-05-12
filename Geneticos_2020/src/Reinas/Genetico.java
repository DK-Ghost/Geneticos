package Reinas;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author AngelNava
 */
public class Genetico {

    private int nGen;
    private int nReinas;
    private int tamPob;
    private double probM;
    private Poblacion pobActual;

    public Genetico(int gen, int tpob, double pmuta, int numr) {
        this.nGen = gen;
        this.tamPob = tpob;
        this.nReinas = numr;
        this.probM = pmuta;
        generarPoblacionRandom();
    }

    private void generarPoblacionRandom() {
        this.pobActual = new Poblacion(tamPob, nReinas);
    }

    public void evolucionar() {
        for (int g = 0; g < this.nGen; g++) {

            LinkedList<Individuo> nueva = new LinkedList();
            Individuo mejor = new Individuo(nReinas);

            for (int i = 0; i < this.pobActual.getPoblacion().size(); i++) {
                //Seleccion
                Individuo padre = this.seleccionarTorneo();
                Individuo madre = this.seleccionarTorneo();
                //Cruza
                Individuo hijo = this.cruzarMascara(padre, madre);
                //Muta
                Random r = new Random();
                if (r.nextInt(100) < this.probM) {
                    hijo = this.mutar(hijo);
                }
                //Agregar Hijo
                nueva.add(hijo);
                //Actualizar Mejor
                if (hijo.getFitness()<mejor.getFitness()) {
                    mejor = new Individuo(hijo.getGenotipo());
                }
            }
            System.out.println("G:" + g + mejor.toString());
            this.pobActual = new Poblacion(nueva);
        }
    }
    
    public Individuo seleccionarRand(){
        int[] gen;
        Random r = new Random();
        gen = this.pobActual.getPoblacion().get(r.nextInt(this.pobActual.getPoblacion().size())).getGenotipo();
        return new Individuo(gen);
    }
    
    public Individuo seleccionarTorneo(){
        Random r = new Random();
        Individuo aux, aux1;
        aux = this.pobActual.getPoblacion().get(r.nextInt(this.pobActual.getPoblacion().size()));
        aux1 = this.pobActual.getPoblacion().get(r.nextInt(this.pobActual.getPoblacion().size()));
        if (aux.getFitness() < aux1.getFitness()) {
            return new Individuo(aux.getGenotipo());
        }else{
            return new Individuo(aux1.getGenotipo());
        }
    }
    
    public Individuo cruzarMascara(Individuo padre, Individuo madre){
        int[] genP = padre.getGenotipo();
        int[] genM = madre.getGenotipo();
        int[] genH = new int[genP.length];
        int[] genH2 = new int[genP.length];
        
        for (int i = 0; i < genP.length; i++) {
            if (i % 2 == 0) {
                genH[i] = genP[i];
                genH2[i] = genM[i];
            }else{
                genH2[i] = genP[i];
                genH[i] = genM[i];
            }  
        }
        
        Individuo Hijo1 = new Individuo(genH);
        Individuo Hijo2 = new Individuo(genH2);
        
        if (Hijo1.getFitness() < Hijo2.getFitness()) {
            return Hijo1;
        }else{
            return Hijo2;
        }
    }
    
    public Individuo cruzarPivote(Individuo padre, Individuo madre){
        int[] genP = padre.getGenotipo();
        int[] genM = madre.getGenotipo();
        int[] genH = new int[genP.length];
        int[] genH2 = new int[genP.length];
        
        int pivote;
        pivote = (genP.length)/2;
        
        
        for (int i = 0; i < pivote; i++) {
           genH[i] = genP[i];
           genH2[i] = genM[i];
        }
        for (int i = pivote+1; i < genH.length; i++){
            genH[i] = genM[i];
           genH2[i] = genP[i];
        }
        
        Individuo Hijo1 = new Individuo(genH);
        Individuo Hijo2 = new Individuo(genH2);
        
        if (Hijo1.getFitness() < Hijo2.getFitness()) {
            return Hijo1;
        }else{
            return Hijo2;
        }
    }
    
    public Individuo mutar(Individuo hijo){
        int[] gen = hijo.getGenotipo();
        Random r = new Random();
        int pos =  r.nextInt(gen.length-2)+1;
        //Hacer Cambio
        gen[pos] = r.nextInt(8);
        
        Individuo i = new Individuo(gen);
        return i;               
    }

    public Poblacion getPobActual() {
        return pobActual;
    }

}
