package SAT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author CRUZLEIJA
 */
public class Tokenizacion {

    public static ArrayList<Clausula> clausulas;

    public static ArrayList<Clausula> leerDatos() {
        clausulas = new ArrayList<>();
        String texto, aux;
        LinkedList<String> lista = new LinkedList();

        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("./"));
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), " ");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    int[] vector = new int[lista2.size()];

                    for (int x = 0; x < lista2.size(); x++) {
                        vector[x] = Integer.parseInt(lista2.get(x));
                    }

                    // a la coleccion de patrones se agrega una nueva clausula
                    
                    clausulas.add(new Clausula(vector[0],vector[1],vector[2]));
                    lista2.clear();
                }

            }
            return clausulas;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        }
        return null;
    }
    
    public static void guardarSolucion(Individuo in,String nomb){
        try{
        String aux;
        aux = Integer.toString(in.getFitness());
        FileWriter fw = new FileWriter("C:/Users/AngelNava/Documents/NetBeansProjects/Geneticos_2020/"+nomb+aux+".txt");
        
        for (int i = 0; i < in.getGenotipo().length; i++) {
            fw.write(in.getGenotipo()[i]+" ");
        }
        fw.close();
        }catch (Exception e){
            System.out.println("Error");
        }
        
    }

}
