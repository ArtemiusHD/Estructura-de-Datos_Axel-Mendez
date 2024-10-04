package Banco;

public class Caja {
    private int numero;
    private boolean estado;
    public Caja(int numero){
        this.numero = numero;
        this.estado = false;
    }
    public int getNumero(){
        return numero;
    }
    public boolean isEstado(){
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
