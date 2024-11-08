package udelp.edu.alumnoestructura.bean;

public class Rectangulo implements IFigura{

    private Double base;
    private Double altura;

    public Rectangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    @Override
    public Double perimetro() {
        return (2 * base) + (2 * altura);
    }

    @Override
    public Double area() {
        return base * altura;
    }
}
