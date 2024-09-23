package MaquinaDeComida;
import Queue.CircularQueue;
public class MainComida {
    public static void main(String[] args) {
        int opcionMenu = 0;
        do{
            System.out.println("""
                    Para agregar algun elemento a la maquina (monedas, productos) presione: 1
                    Para realizar alguna compra presione: 2
                    """);
            switch (opcionMenu){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }while (opcionMenu != 3);
    }
}
