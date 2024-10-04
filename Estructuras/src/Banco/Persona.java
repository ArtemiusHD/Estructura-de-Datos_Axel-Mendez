package Banco;

public class Persona {
    protected String nombre;
    protected  double saldo;
    public Persona (String nombre, double saldo){
        this.nombre = nombre;
        this. saldo = saldo;
    }
    public String getNombre(){
        return nombre;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
}