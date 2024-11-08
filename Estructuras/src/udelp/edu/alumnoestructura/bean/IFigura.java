package udelp.edu.alumnoestructura.bean;

public interface IFigura {

    Double perimetro();
    Double area();

    default void imprime(){
        System.out.println("Perimetro: " + perimetro());
        System.out.println("Area: " + area());
    }

}
