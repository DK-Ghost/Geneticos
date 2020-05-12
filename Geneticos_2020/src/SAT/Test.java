package SAT;

import javax.swing.JOptionPane;

/**
 *
 * @author AngelNava
 */
public class Test {
    public static void main(String ag[]){
        Tokenizacion.leerDatos();
        int fit; 
        
       do{
       Genetico g = new Genetico( 15000, 150, 4, 100); 
       g.evolucionar();
          
          
       System.out.println("G: " +g.getIndiMejor().toString()); 
       if(g.getIndiMejor().getFitness()> 544){
           Tokenizacion.guardarSolucion(g.getIndiMejor(),"Prueba_2A");
       }
       
       fit = g.getIndiMejor().getFitness();
       
       }while(fit<550 );
       
       JOptionPane.showMessageDialog(null, "Listo", "", JOptionPane.ERROR_MESSAGE);
       
    }
} 
