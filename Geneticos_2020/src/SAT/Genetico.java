package SAT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author AngelNava
 */
public class Genetico {

    private int nGen;
    private int nIndiv;
    private int tamPob;
    private double probM;
    private Poblacion pobActual;
    private Individuo IndiMejor;
    private ArrayList<Individuo> muestraOrdenada;

    public Genetico(int gen, int tpob, double pmuta, int numr) {    
        this.nGen = gen;
        this.tamPob = tpob;
        this.nIndiv = numr;
        this.probM = pmuta;
        this.pobActual = new Poblacion(tamPob, nIndiv);
    }

    public void evolucionar() {
        Individuo mejor;
        for (int g = 0; g < this.nGen; g++) {

            ArrayList<Individuo> nueva = new ArrayList();
            if (g == 0) {
                mejor = new Individuo(nIndiv);
            } else {
                mejor = new Individuo(IndiMejor.getGenotipo());
            }

            getMejor();

            for (int i = 0; i < this.pobActual.getPoblacion().size(); i++) {
                Individuo hijo;
                // Pasar los 20 mejores y eliminar los 20 peores

                if (i < 20) {
                    hijo = new Individuo(muestraOrdenada.get(i).getGenotipo());
                } else {
                    if (i > pobActual.getPoblacion().size() - 5) {
                        hijo = new Individuo(this.nIndiv);
                    } else {
                        //Seleccion
                        Individuo padre = this.seleccionarTorneo();
                        Individuo madre = this.seleccionarTorneo();
                        //Cruza
                        hijo = this.cruzarMascara(padre, madre);
                    }
                }

                //Muta
                Random r = new Random();
                if (r.nextInt(100) < this.probM) {
                    hijo = this.mutar(hijo);
                }
                //Agregar Hijo
                nueva.add(hijo);
                //Actualizar Mejor
                if (hijo.getFitness() > mejor.getFitness()) {
                    mejor = new Individuo(hijo.getGenotipo());
                    this.IndiMejor = new Individuo(mejor.getGenotipo());
                } else {
                    this.IndiMejor = new Individuo(mejor.getGenotipo());
                }
            }
//            System.out.println("G:" + g + mejor.toString());
            this.pobActual = new Poblacion(nueva);
        }
    }

    public Individuo seleccionarTorneo() {
        Random r = new Random();
        Individuo aux, aux1;
        aux = this.pobActual.getPoblacion().get(r.nextInt(this.pobActual.getPoblacion().size()));
        aux1 = this.pobActual.getPoblacion().get(r.nextInt(this.pobActual.getPoblacion().size()));
        if (aux.getFitness() > aux1.getFitness()) {
            return new Individuo(aux.getGenotipo());
        } else {
            return new Individuo(aux1.getGenotipo());
        }
    }

    public Individuo mutar(Individuo hijo) {
        int[] gen = hijo.getGenotipo();
        Random r = new Random();
        int pos = r.nextInt(gen.length - 2) + 1;
        //Hacer Cambio
        if (gen[pos] == 0) {
            gen[pos] = 1;
        } else {
            gen[pos] = 0;
        }
        Individuo i = new Individuo(gen);
        return i;
    }

    public Individuo cruzarMascara(Individuo padre, Individuo madre) {
        int[] genP = padre.getGenotipo();
        int[] genM = madre.getGenotipo();
        int[] genH = new int[genP.length];
        int[] genH2 = new int[genP.length];

        for (int i = 0; i < genP.length; i++) {
            if (i % 2 == 0) {
                genH[i] = genP[i];
                genH2[i] = genM[i];
            } else {
                genH2[i] = genP[i];
                genH[i] = genM[i];
            }
        }

        Individuo Hijo1 = new Individuo(genH);
        Individuo Hijo2 = new Individuo(genH2);

        if (Hijo1.getFitness() < Hijo2.getFitness()) {
            return Hijo1;
        } else {
            return Hijo2;
        }
    }

    public Poblacion getPobActual() {
        return pobActual;
    }

    private void getMejor() {
        //Generar muestra con los mejores p porcentaje

        muestraOrdenada = new ArrayList();
        Individuo aux[] = new Individuo[pobActual.getPoblacion().size()];

        for (int i = 0; i < pobActual.getPoblacion().size(); i++) {
            aux[i] = pobActual.getPoblacion().get(i);
        }

        Individuo aux2;
        for (int i = 0; i < aux.length - 1; i++) {
            for (int j = 0; j < aux.length - i - 1; j++) {
                if (aux[j + 1].getFitness() > aux[j].getFitness()) {
                    aux2 = aux[j + 1];
                    aux[j + 1] = aux[j];
                    aux[j] = aux2;
                }
            }
        }

        for (int k = 0; k < aux.length; k++) {
            muestraOrdenada.add(new Individuo(aux[k].getGenotipo()));
        }
    }

    public Individuo getIndiMejor() {
        return IndiMejor;
    }
}
