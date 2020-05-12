package Extras;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class GeneradorInstancias {
    
    public static int[][] generarMartrizInst(int n, int tope){
        int[][] matriz = new int[n][n];
        int aux;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && matriz[i][j] ==0 ) break;
                aux=0;
                while(aux == 0){
                    aux = r.nextInt(tope+1);
                }
                matriz[i][j] = aux;
                matriz[j][i] = aux;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j]+"  ");
            }
            System.out.println("");
        }
        return null;
    }
    
    public static void guardarMatriz(int[][] m){
        
    }
    
    public static int[][] cargarMatriz(){
        return null;
    }
}
