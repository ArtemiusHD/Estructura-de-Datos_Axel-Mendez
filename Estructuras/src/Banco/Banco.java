package Banco;
import Queue.LinkedQueue;
public class Banco {
    private LinkedQueue filaClientes;
    private Caja[] cajas;
    private double dineroBanco;
    public static final double TOPE_BANCO = 500000;
    public Banco() {
        filaClientes = new LinkedQueue();
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i + 1);
        }
        dineroBanco = 500000;
    }
    public void agregarCliente(Persona cliente) {
        filaClientes.enqueue(cliente);
    }
    public Persona siguienteCliente() {
        return (Persona) filaClientes.dequeue();
    }
    public int asignarCaja() {
        for (Caja caja : cajas) {
            if (!caja.isEstado()) {
                caja.setEstado(true);
                return caja.getNumero();
            }
        }
        return -1;
    }
    public void liberarCaja(int numeroCaja) {
        if (numeroCaja > 0 && numeroCaja <= cajas.length) {
            cajas[numeroCaja - 1].setEstado(false);
        }
    }
    public double getDineroBanco() {
        return dineroBanco;
    }
    public void setDineroBanco(double dineroBanco) {
        this.dineroBanco = dineroBanco;
    }
    public String mostrarFila() {
        return filaClientes.toString();
    }
}

