package Banco;

public class ClienteConCuenta extends Persona{
    public ClienteConCuenta(String nombre, double saldo){
        super(nombre, saldo);
    }
    public String toString(){
        return "Cliente: " + nombre + " Tiene cuenta, Saldo: $" + String.format("%.2f" , saldo);
    }
}
