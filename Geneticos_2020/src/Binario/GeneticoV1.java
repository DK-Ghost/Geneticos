package Binario;

/**
 *
 * @author Alumno
 */
public class GeneticoV1 {

    private int num_G;
    private double pMuta;
    private Poblacion pobactual;
    private int tamPob;

    public GeneticoV1(int num_G, double pMuta, int tamañoPoblacion) {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamañoPoblacion;
        //Generamos poblacion actual con aleatorio
        this.pobactual = new Poblacion(this.tamPob);
    }

    public void evoluvionar() {
        //Proceso evolutivo donde se generan nuevas poblaciones
        int mascara[] = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        for (int g = 0; g < this.num_G; g++) {
            Poblacion nueva = new Poblacion();
            //Se agregan los individuos de la poblacion
            Individuo mejor = new Individuo(new int[31]);

            for (int i = 0; i < this.tamPob; i++) {
                //Proceso de seleccion 
                Individuo madre = Seleccion.seleccionAleatoria(this.pobactual);
                Individuo padre = Seleccion.seleccionAleatoria(this.pobactual);
                //Proceso de Cruza
                Individuo hijo = Cruza.cruzaPorMascara(mascara, madre, padre);
                //Proceso de Mutacion
                if (Math.random() < this.pMuta) {
                    //muta por referencia al hijo
                }
                // el hijo generado se agrega a la nueva poblacion
                nueva.getPoblacion().add(hijo);
                if (hijo.getFitness() > mejor.getFitness()) {
                    mejor = new Individuo(hijo.getGenotipo());
                }
            }
            System.out.println("G:" + g + mejor.toString());

            //El hijo generado se agreaga a la mueva poblacion
            //Actualizar la poblacion actual
            this.pobactual = new Poblacion(nueva);
        }
    }
}
