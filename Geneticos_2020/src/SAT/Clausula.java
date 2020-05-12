package SAT;

/**
 *
 * @author AngelNava
 */
public class Clausula {
    private int[] clausula;
    
    public Clausula(int a, int b, int c){
        this.clausula = new int[] {a,b,c};
    }

    public int[] getClausula() {
        return clausula;
    }
    
}
