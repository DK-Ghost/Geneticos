package Binario;

import java.util.LinkedList;
import java.util.Random;
import Binario.Individuo;

/**
 *
 * @author DK Ghost
 */
public class Poblacion {

    public LinkedList<Individuo> poblacion;
    private int i;

    //Creacion aleatoria de la poblacion
    public Poblacion(int i) {
        this.i = i;
        this.poblacion = new LinkedList();
        inicializarAleatoreamente();
    }

    //Creacion de poblacion en base a muestreo
    public Poblacion(LinkedList<Individuo> muestra, int i) {
        this.i = i;
        this.poblacion = new LinkedList();
        for (int j = 0; j < muestra.size(); j++) {
            this.poblacion.add(new Individuo(muestra.get(j).getGenotipo()));
        }
        //Ver como se resolvera 
    }
    
    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList();
        //Crear una nueva poblacion en base a otra
        for (Individuo aux: n.getPoblacion()) {
            this.poblacion.add(new Individuo(aux.getGenotipo()));
        }
        this.i = n.getPoblacion().size();
    }
    
    public Poblacion(){
        this.poblacion = new LinkedList();
    }

    private void inicializarAleatoreamente() {
        // un proceso iterativo con respecto a i
        for (int x = 0; x < this.i; x++) {
            poblacion.add(new Individuo(31));
        }
    }
    //Generar Muestra Aleatorea

    public LinkedList<Individuo> generarMuestra(int p) {
        int c = (this.i * p / 100);
        int pa;
        Random r = new Random();
        LinkedList<Individuo> muestra = new LinkedList();
        for (int j = 0; j < c; j++) {
            pa = r.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));
        }
        return muestra;
    }
    
    public LinkedList<Individuo> generarMuestraMejores(int p) {
        int cantidad = (this.i * p / 100);
        LinkedList<Individuo> muestra = new LinkedList();
         int i, j;
         Individuo[] pob = new Individuo[this.poblacion.size()];
         Individuo aux;
         
        //Paso el Linked List a un arreglo
        for (int k = 0; k < this.poblacion.size(); k++) {
            pob[k] = this.poblacion.get(k);
        }
        
        //Ordeno el arreglo de Individuos deacuerdo a su fitness
        for (i = 0; i < pob.length - 1; i++) {
            for (j = 0; j < pob.length - i - 1; j++) {
                if (pob[j+1].getFitness()< pob[j].getFitness()) {
                    aux = pob[j+1];
                    pob[j+1] = pob[j] ;
                    pob[j] = aux;
                }
            }
        }
        
        //Paso el arreglo ordenado a una linkedList muestra
        for (int k = 0; k < cantidad; k++) {
            muestra.add(new Individuo(pob[k].getGenotipo()));
        }
        
        return muestra;
    }

    public LinkedList<Individuo> getPoblacion() {
        return poblacion;
    }
  
}
