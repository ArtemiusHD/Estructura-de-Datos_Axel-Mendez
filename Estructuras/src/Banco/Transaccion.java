package Banco;

public class Transaccion {
    private static final double[] DENOMINACIONES = {0.50,1,2,5,10,20,50,100,200,500,1000};
    public static boolean nominacionValida (double denominacion){
        for(double deno : DENOMINACIONES){
            if(deno == denominacion){
                return true;
            }
        }
        return false;
    }
}
