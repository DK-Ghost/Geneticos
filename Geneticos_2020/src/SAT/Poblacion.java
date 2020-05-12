package SAT;

import java.util.ArrayList;

/**
 *
 * @author AngelNava
 */
public class Poblacion {
    
    ArrayList<Individuo> poblacion;
    
    public Poblacion(int tam, int n){
        poblacion = new ArrayList();
        for (int i = 0; i < tam; i++) {
            poblacion.add(new Individuo(n));
        }
    }
    
    public Poblacion(ArrayList<Individuo> pob) {
        //Crear una poblacion en base a otra
        this.poblacion = pob;
    }

    public ArrayList<Individuo> getPoblacion() {
        return poblacion;
    }
 
}
