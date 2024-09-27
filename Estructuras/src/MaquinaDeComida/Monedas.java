package MaquinaDeComida;

public class Monedas {
    private String tipoMoneda;
    private int cantidad;
    public Monedas(String tipoMoneda, int cantidad) {
        this.tipoMoneda = tipoMoneda;
        this.cantidad = cantidad;
    }
    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void agregarMonedas(int cantidadAgregar) {
        this.cantidad += cantidadAgregar;
    }
    public void retirarMonedas(int cantidadRetirar) {
        if (cantidad >= cantidadRetirar) {
            cantidad -= cantidadRetirar;
        } else {
            System.out.println("No hay suficientes monedas de este tipo.");
        }
    }
}

