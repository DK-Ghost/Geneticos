package Geneticos_2020;

import Binario.GeneticoV1;
import Binario.GeneticoV2;
import Binario.Individuo;
import Binario.Poblacion;
import Extras.GeneradorInstancias;
import java.util.LinkedList;

/**
 *
 * @author DK Ghost
 */
public class Main {

    public static void main(String args[]) {  

//        GeneticoV2 gen = new GeneticoV2(33,0.25,50);
//        gen.evoluvionar();
//        LinkedList<Individuo> m = new LinkedList(); 
//        Poblacion p  = new Poblacion(gen.getPobactual());
//        m = p.generarMuestraMejores(25);
//                
//        System.out.println("Muestra\n");
//        
//        for(int i = 0; i < m.size(); i++) {
//            System.out.println(m.get(i).toString());
//        }

       int[][] m = GeneradorInstancias.generarMartrizInst(10,10 );

    }

}
