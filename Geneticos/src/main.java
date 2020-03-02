
import Binario.GeneticoV1;
import Extras.GeneradorInstancias;
import Tsp.Individuo;

public class main {

  public static void main(String[] args) {
    try {
      Individuo.matrizDistancias = GeneradorInstancias.cargarMatriz();
      Individuo i = new Individuo(3, 5);
      System.out.println();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    }
}