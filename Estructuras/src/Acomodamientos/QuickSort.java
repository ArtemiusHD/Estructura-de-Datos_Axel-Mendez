package Acomodamientos;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        List.ArrayList listaNumeros = new List.ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(50) + 1;
            listaNumeros.add(numero);
        }
        System.out.println("Lista antes de ordenar: ");
        System.out.println(listaNumeros.toString());
        fquickSort(listaNumeros, 0, listaNumeros.size() - 1);
        System.out.println("Lista ordenada: ");
        System.out.println(listaNumeros.toString());
    }
    public static void fquickSort(List.ArrayList lista, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = fparticion(lista, inicio, fin);
            fquickSort(lista, inicio, indicePivote - 1);
            fquickSort(lista, indicePivote + 1, fin);
        }
    }
    public static int fparticion(List.ArrayList lista, int inicio, int fin) {
        int pivote = (int) lista.get(fin);
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if ((int) lista.get(j) <= pivote) {
                i++;
                Object temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }
        Object temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fin));
        lista.set(fin, temp);
        return i + 1;
    }
    //NOTA: Esta tarea junto con la de shell sort y binaria estan inspirados en algunos ejercicios que vi en youtube al momento de investigar sobre la busqueda y los acomodamientos, no son iguales, pero si parecidos
}