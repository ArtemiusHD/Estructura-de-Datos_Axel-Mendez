package udelp.edu.alumnoestructura.bean;

public class TrianguloEscaleno extends Triangulo{

    private Double lado2;
    private Double lado3;

    public Double getLado3() {
        return lado3;
    }

    public void setLado3(Double lado3) {
        this.lado3 = lado3;
    }

    public Double getLado2() {
        return lado2;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    @Override
    public Double perimetro() {
        return lado + lado2 + lado3;
    }



}
