package Pilas;
import java.util.Random;
import java.util.Stack;
public class ExamenParcialEj3 {
    public static void main(String[] args) {
        System.out.println("*** Ejercicio 3 ***");
        Stack<Integer> pila = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();
        Random randomizador = new Random();
        int numeroRandom = 0;
        int resultado = 0;
        while (pila.size() != 10){
            numeroRandom = randomizador.nextInt(100)+1;
            pila.push(numeroRandom);
        }
        System.out.println(pila);
        pila2 = fSuma(pila);
        System.out.println("pila2 = " + pila2);
        resultado = frealizarOperaciones(pila2);
    }
    public static Stack<Integer> fSuma(Stack<Integer> pila) {
        Stack<Integer> resultadoPila = new Stack<>();
        for (int i = 0; i < 10; i += 2) {
            int elemento1 = pila.pop();
            int elemento2 = pila.pop();
            int suma = elemento1 + elemento2;
            resultadoPila.push(suma);
        }
        return resultadoPila;
    }
    public static int frealizarOperaciones(Stack<Integer> pila) {
        int resultado = 0;
        int valor1 = pila.pop();
        int valor2 = pila.pop();
        System.out.println(resultado = (valor1 - valor2) * pila.peek());
        pila.pop();
        System.out.println(resultado += pila.peek());
        pila.pop();
        System.out.println(resultado -= pila.pop());
        return resultado;
    }
}

