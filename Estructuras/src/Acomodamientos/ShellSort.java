package Acomodamientos;

import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        List.ArrayList listaNumeros = new List.ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(50) + 1;
            listaNumeros.add(numero);
        }
        System.out.println("Lista antes de ordenar: ");
        System.out.println(listaNumeros.toString());
        fshellSort(listaNumeros);
        System.out.println("Lista ordenada: ");
        System.out.println(listaNumeros.toString());
    }
    public static void fshellSort(List.ArrayList lista) {
        int n = lista.size();
        int intervalo = n / 2;
        while (intervalo > 0) {
            for (int i = intervalo; i < n; i++) {
                Object temp = lista.get(i);
                int j = i;
                while (j >= intervalo && (int) lista.get(j - intervalo) > (int) temp) {
                    lista.set(j, lista.get(j - intervalo));
                    j -= intervalo;
                }
                lista.set(j, temp);
            }
            intervalo /= 2;
        }
    }
}
