package Acomodamientos;

public class Secuencia {
    public static void secuencia(int[] arreglo) {
        int n = arreglo.length;
        int i = 0;
        while (i < n - 1) {
            int peque = i;
            int j = i + 1;
            while (j < n) {
                if (arreglo[j] < arreglo[peque]) {
                    peque = j;
                }
                j++;
            }
            int temp = arreglo[i];
            arreglo[i] = arreglo[peque];
            arreglo[peque] = temp;
            i++;
        }
    }
}
