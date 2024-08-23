package Acomodamientos;

public class Insercion {
    public static void insercion(int[] arreglo) {
        int n = arreglo.length;
        int i = 1;
        while (i < n) {
            int k = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > k) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = k;
            i++;
        }
    }
}
