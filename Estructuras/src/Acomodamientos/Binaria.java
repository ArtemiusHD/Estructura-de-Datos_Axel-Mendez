package Acomodamientos;
import java.util.Scanner;
public class Binaria {
    public static void main(String[] args) {
        List.ArrayList lista = new List.ArrayList();
        Scanner leer = new Scanner(System.in);
        int bajo = 0;
        int adivinanza;
        int alto = 9;
        int medio;
        boolean encontrado = false;
        String respuesta;
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }
        System.out.println("Piensa en un número del 1 al 10.");
        while (bajo <= alto && !encontrado) {
            medio = (bajo + alto) / 2;
            adivinanza = (int) lista.get(medio);
            System.out.println("¿Es tu número " + adivinanza + "?");
            System.out.println("Responde con: 'mayor', 'menor', o 'igual'.");
            respuesta = leer.nextLine().toLowerCase();
            if (respuesta.equals("igual")) {
                System.out.println("Tu numero es: " + adivinanza);
                encontrado = true;
            } else if (respuesta.equals("mayor")) {
                bajo = medio + 1;
            } else if (respuesta.equals("menor")) {
                alto = medio - 1;
            } else {
                System.out.println("Respuesta no válida");
            }
        }
        if (!encontrado) {
            System.out.println("Numero no encontrado");
        }
        leer.close();
    }
}
