package ExamenSegundoParcial;
import java.util.ArrayList;
import java.util.Random;

public class EjercicioUno {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();
        double mediana;
        double suma = 0;
        int maxFrecuencia = 0;
        int mitad = 0;
        int moda = 0;
        double media = 0;
        for (int i = 0; i < 50; i++) {
            lista.add(random.nextInt(100) + 1);
        }
        System.out.println(lista);
        for (int numero : lista) {
            suma += numero;
        }
        media = suma / lista.size();
        System.out.println("Media: " + media);
        moda = lista.get(0);
        for (int i = 0; i < lista.size(); i++) {
            int frecuencia = 0;
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).equals(lista.get(i))) {
                    frecuencia++;
                }
            }
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = lista.get(i);
            }
        }
        System.out.println("Moda: " + moda);
        lista.sort(Integer::compareTo);
        mitad = lista.size() / 2;
        if (lista.size() % 2 == 0) {
            mediana = (lista.get(mitad - 1) + lista.get(mitad)) / 2;
        } else {
            mediana = lista.get(mitad);
        }
        System.out.println("Mediana: " + mediana);
    }
}

