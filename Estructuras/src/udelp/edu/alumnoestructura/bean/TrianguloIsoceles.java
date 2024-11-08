package udelp.edu.alumnoestructura.bean;

public class TrianguloIsoceles extends Triangulo{

    private Double lado2;

    public TrianguloIsoceles(Double base, Double lado2, Double altura){
        this.lado2 = lado2;
        this.lado = base;
        this.setAltura(altura);
    }

    public Double getLado2() {
        return lado2;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public Double perimetro() {
        return lado + (lado2 * 2);
    }

}
