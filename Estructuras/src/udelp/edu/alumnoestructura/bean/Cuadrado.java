package udelp.edu.alumnoestructura.bean;

public class Cuadrado extends Figura {

    public double getLado(){
        return lado;
    }

    public void setLado(int i){
        this.lado = lado;
    }

    public Double perimetro(){
        return lado * 4;
    }

    public Double area(){
        return lado * lado;
    }

    public Cuadrado (double lado){
        this.lado = lado;
    }
}
