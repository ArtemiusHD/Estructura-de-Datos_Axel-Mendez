import udelp.edu.alumnoestructura.bean.*;

import java.sql.SQLOutput;

public class Principal {
    public static void main(String[] args) {

        Cuadrado c = new Cuadrado(10);
        System.out.println("Perimetro: " + c.perimetro());
        System.out.println("Area: " + c.area());

        Triangulo t = new TrianguloEquilatero();
        t.setBase(3);
        t.setAltura(5);

        System.out.println();
        System.out.println("Perimetro: " + t.perimetro());
        System.out.println("Area: " + t.area());

        t = new TrianguloIsoceles(3D,5D,10D);

        System.out.println();
        System.out.println("Perimetro: " + t.perimetro());
        System.out.println("Area: " + t.area());

        Rectangulo r = new Rectangulo(2D , 5D);

        System.out.println();
        r.imprime();

        int radio = 2;
        IFigura circulo = new IFigura() {
            @Override
            public Double perimetro() {
                return 2 * Math.PI * radio;
            }

            @Override
            public Double area() {
                return Math.PI * Math.pow(radio , 2);
            }
        };

        System.out.println();
        circulo.imprime();

    }
}
