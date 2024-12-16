package ExamenFinal;
import ArbolesBinarios.ArbolBinario;

public class EjercicioCuatro {
        public static void main(String[] args) {
            ArbolBinario arbol = new ArbolBinario();
            int[] numeros = {67, 43, 50, 11, 55,70, 92, 5 , 13, 50, 56, 68, 74, 90, 95};
            for (int numero : numeros) {
                arbol.add(numero);
            }
            System.out.println("Recorrido Preorden:");
            arbol.preorden();
            System.out.println("\nRecorrido Inorden:");
            arbol.inorden();
            System.out.println("\nRecorrido Postorden:");
            arbol.postorden();
        }
    }

