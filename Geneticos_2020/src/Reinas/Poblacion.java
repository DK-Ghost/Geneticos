package Reinas;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author AngelNava
 */
public class Poblacion {

    private LinkedList<Individuo> poblacion;

    public Poblacion(int tam, int n) {
        //Crear una poblacion aleatora
        this.poblacion = new LinkedList();
        for (int i = 0; i < tam; i++) {
            this.poblacion.add(new Individuo(n));
        }
    }

    public Poblacion(LinkedList<Individuo> pob) {
        //Crear una poblacion en base a otra
        this.poblacion = pob;
    }

    public LinkedList<Individuo> generarMuestraMejor(int p) {
        //Generar muestra con los mejores p porcentaje
        int cantidad = this.poblacion.size() * p / 100;
        LinkedList<Individuo> muestra = new LinkedList();
        Individuo aux[] = new Individuo[this.poblacion.size()];

        for (int i = 0; i < this.poblacion.size(); i++) {
            aux[i] = this.poblacion.get(i);
        }

        Individuo aux2;
        for (int i = 0; i < aux.length - 1; i++) {
            for (int j = 0; j < aux.length - i - 1; j++) {
                if (aux[j + 1].getFitness() < aux[j].getFitness()) {
                    aux2 = aux[j + 1];
                    aux[j + 1] = aux[j];
                    aux[j] = aux2;
                }
            }
        }

        for (int k = 0; k < cantidad; k++) {
            muestra.add(new Individuo(aux[k].getGenotipo()));
        }

        return muestra;
    }

    public LinkedList<Individuo> generarMuestraRandom(int p) {
        //Generar Muestra Random con p porcentaje de individuos
        int cantidad = this.poblacion.size() * p / 100;
        Random r = new Random();
        LinkedList<Individuo> muestra = new LinkedList();
        int pos;

        for (int i = 0; i < cantidad; i++) {
            pos = r.nextInt(this.poblacion.size());
            muestra.add(this.poblacion.get(pos));
            muestra.add(new Individuo(this.poblacion.get(pos).getGenotipo()));
        }

        return muestra;
    }

    public LinkedList<Individuo> getPoblacion() {
        return poblacion;
    }

}
