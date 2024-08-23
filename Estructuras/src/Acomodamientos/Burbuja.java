package Acomodamientos;

public class Burbuja {
    public static void burbuja(int[] arreglo) {
        int n = arreglo.length;
        int i = 0;
        while (i < n - 1) {
            int j = 0;
            while (j < n - i - 1) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int guarda = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = guarda;
                }
                j++;
            }
            i++;
        }
    }
}
