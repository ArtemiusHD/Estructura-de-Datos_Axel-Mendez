package Pilas;
import java.util.Stack;
import java.util.Random;
public class ExamenParcial {
    public static void main(String[] args) {
        System.out.println("*** Ejercicio 2 ***");
        fMeterNumerosPilas();
    }

    public static void fMeterNumerosPilas() {
        Stack<Integer> pila = new Stack<>();
        Random randomizador = new Random();
        int numeroRandom;
        int respuesta;
        do {
            numeroRandom = randomizador.nextInt(100) + 1;
            pila.push(numeroRandom);
        } while (numeroRandom != 50);
        System.out.println(pila);
        respuesta = fRespuestaSuma(pila);
        System.out.println("respuesta = " + respuesta);
    }
    private static int fRespuestaSuma (Stack<Integer> pila){
        int respuesta = 0;
        while (!pila.isEmpty()){
        respuesta += pila.pop();
        }
        return respuesta;
    }
}
