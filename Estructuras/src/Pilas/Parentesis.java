package Pilas;
import java.util.Scanner;

public class Parentesis {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresa una operacion: ");
        String cadena = leer.nextLine();
        LinkedStack operadores = new LinkedStack();
        LinkedStack operandos = new LinkedStack();
        LinkedStack acomodamientoPolaca = new LinkedStack();
        LinkedStack pivote = new LinkedStack();
        boolean resultado = validacion(cadena);
        System.out.println("Balance: " + resultado);
        if(resultado){
            String resultadoPolaca = fNotaPolaca(cadena, operadores, operandos, acomodamientoPolaca, pivote);
            System.out.println("resultadoPolaca = " + resultadoPolaca);
            int resultadoOperacion = fOperacion(resultadoPolaca);
            System.out.println("resultadoOperacion = " + resultadoOperacion);
        }else {
            System.out.println("Parentesis no balanceados");
        }
        leer.close();
    }
    public static boolean apertura(char c) {
        return c == '(';
    }
    public static boolean cierre(char c) {
        return c == ')';
    }
    public static boolean validacion(String cadena) {
        LinkedStack stack = new LinkedStack();
        for (char c : cadena.toCharArray()) {
            if (apertura(c)) {
                stack.push(c);
            } else if (cierre(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static int fjerarquiaOp(char operador){
        switch (operador){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    public static String fNotaPolaca(String cadena, LinkedStack operadores, LinkedStack operandos, LinkedStack acomodamientoPolaca, LinkedStack pivote) {
        StringBuilder resultado = new StringBuilder();
        for (char caracter : cadena.toCharArray()) {
            if (Character.isDigit(caracter)) {
                operandos.push(caracter);
                acomodamientoPolaca.push(caracter);
                resultado.append(caracter).append(' ');
            }
            else if (apertura(caracter)) {
                operadores.push(caracter);
            }
            else if (cierre(caracter)) {
                while (!operadores.isEmpty()) {
                    char top = (char) operadores.pop();
                    if (top == '(') {
                        break;
                    }
                    pivote.push(top);
                    acomodamientoPolaca.push(top);
                    resultado.append(top).append(' ');
                }
            }
            else if (fjerarquiaOp(caracter) > 0) {
                while (!operadores.isEmpty()) {
                    char top = (char) operadores.pop();
                    if (fjerarquiaOp(top) < fjerarquiaOp(caracter)) {
                        operadores.push(top);
                        break;
                    } else {
                        acomodamientoPolaca.push(top);
                        resultado.append(top).append(' ');
                    }
                }
                operadores.push(caracter);
            }
        }
        while (!operadores.isEmpty()) {
            char top = (char) operadores.pop();
            acomodamientoPolaca.push(top);
            resultado.append(top).append(' ');
        }
        return resultado.toString().trim();
    }
    public static boolean fVeriNumero (String elemento){
        if(elemento == null || elemento.isEmpty()){
            return false;
        }
        for(int i = 0; i < elemento.length(); i++){
            if(!Character.isDigit(elemento.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static int fOperacion (String polaca){
        LinkedStack pila = new LinkedStack();
        String[] elementos = polaca.split(" ");
        for(String elemento : elementos){
            if(fVeriNumero(elemento)){
                pila.push(Integer.parseInt(elemento));
            }else{
                int b = (int) pila.pop();
                int a = (int) pila.pop();
                switch (elemento.charAt(0)){
                    case '+':
                        pila.push(a + b);
                        break;
                    case '-':
                        pila.push(a - b);
                        break;
                    case '*':
                        pila.push(a * b);
                        break;
                    case '/':
                        pila.push(a / b);
                        
                }
            }
        }
        return (int) pila.pop();
    }
}