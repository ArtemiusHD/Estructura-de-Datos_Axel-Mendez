package Nodos;
import java.util.Date;

public class DateNodo {
    private Object valor;
    private Date fecha;
    private DateNodo enlace;

    public DateNodo() {
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DateNodo getEnlace() {
        return enlace;
    }

    public void setEnlace(DateNodo enlace) {
        this.enlace = enlace;
    }
}

