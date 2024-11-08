package udelp.edu.alumnoestructura.bean;

public abstract class Figura {
    protected double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public abstract Double area();

    public  abstract Double perimetro();
}
