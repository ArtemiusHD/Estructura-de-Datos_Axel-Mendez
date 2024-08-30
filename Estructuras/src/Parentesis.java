import java.util.Scanner;
import Acomodamientos.ArrayStack;
public class Parentesis {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresa una operacion: ");
        String cadena = leer.nextLine();
        boolean resultado = validacion(cadena);
        System.out.println("Balance: " + resultado);
    }
    public static boolean apertura(char c) {
        return c == '(';
    }
    public static boolean cierre(char c) {
        return c == ')';
    }
    public static boolean validacion(String cadena) {
        ArrayStack stack = new ArrayStack(cadena.length());
        for (char c : cadena.toCharArray()) {
            if (apertura(c)) {
                stack.push(c);
            }
            else if (cierre(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}