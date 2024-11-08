package udelp.edu.alumnoestructura.bean;

public abstract class Triangulo  extends Figura{

    private double altura;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase(){
        return lado;
    }

    public void setBase(double lado){
        this.lado = lado;
    }

    @Override
    public Double area() {
        return (lado * altura) / 2;
    }

}
