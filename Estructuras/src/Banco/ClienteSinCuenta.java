package Banco;

public class ClienteSinCuenta extends Persona{
    public ClienteSinCuenta (String nombre , double saldo){
        super(nombre , saldo);
    }
    public String toString(){
        return "Cliente: " + nombre + " No tiene cuenta, Saldo: $" + String.format("%.2f" , saldo);
    }
}
