package MaquinaDeComida;
import Queue.CircularQueue;
import java.util.Scanner;
public class MainComida {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcionMenu = 0;
        int opcionSubMenu = 0;
        int precioProducto = 0;
        double montoIngresado = 0;
        double moneda = 0;
        String claveProducto = null;
        CircularQueue[] productos = new CircularQueue[10];
        CircularQueue[] monedas = new CircularQueue[5];
        String[] nombresProductos = {"Coca Cola", "Fanta", "Squirt", "Boing", "Pepsi", "Galletas", "Chocolate", "Fuze Tea", "Papas", "Chetos"};
        String[] clavesProductos = {"A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2"};
        int[] preciosProductos = {15, 14, 14, 13, 14, 12, 10, 15, 12, 12};
        String[] tiposMonedas = {"10 pesos", "5 pesos", "2 pesos", "1 peso", "0.50 pesos"};
        for (int i = 0; i < productos.length; i++) {
            productos[i] = new CircularQueue(10);
        }
        for (int i = 0; i < monedas.length; i++) {
            monedas[i] = new CircularQueue(15);
        }
        do {
            System.out.println("""
                Para rellenar el stock de productos o de monedas presiona: 1
                Para comprar un producto presiona: 2
                Para salir presiona: 3""");
            opcionMenu = leer.nextInt();
            leer.nextLine();
            switch (opcionMenu) {
                case 1:
                    do {
                        System.out.println("""
                                Para rellenar productos presiona: 1
                                Para rellenar monedas presiona: 2
                                Para  consultar el inventario presiona : 3
                                Para regresar al menú principal presiona: 4""");
                        opcionSubMenu = leer.nextInt();
                        leer.nextLine();
                        switch (opcionSubMenu) {
                            case 1:
                                for (int i = 0; i < productos.length; i++) {
                                    while (!productos[i].isFull()) {
                                        productos[i].enqueue(nombresProductos[i]);
                                    }
                                }
                                System.out.println("Productos rellenados.");
                                break;
                            case 2:
                                for (int i = 0; i < monedas.length; i++) {
                                    while (!monedas[i].isFull()) {
                                        monedas[i].enqueue(tiposMonedas[i]);
                                    }
                                }
                                System.out.println("Monedas rellenadas.");
                                break;
                            case 3:
                                System.out.println("Inventario de productos:");
                                for (int i = 0; i < productos.length; i++) {
                                    System.out.println(clavesProductos[i] + " - " + nombresProductos[i] + ": " + productos[i].getSize() + " en stock.");
                                }

                                System.out.println("\nInventario de monedas:");
                                for (int i = 0; i < monedas.length; i++) {
                                    System.out.println(tiposMonedas[i] + ": " + monedas[i].getSize() + " en stock.");
                                }
                                break;
                            case 4:
                                System.out.println("Regresando al menú principal...");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }

                    } while (opcionSubMenu != 4);
                    break;

                case 2:
                    System.out.println("Seleccione el producto a comprar ingresando su clave (A1, A2, B1, etc.):");
                    for (int i = 0; i < productos.length; i++) {
                        if (!productos[i].isEmpty()) {
                            System.out.println(clavesProductos[i] + ": " + nombresProductos[i] + " - $" + preciosProductos[i]);
                        }
                    }
                    claveProducto = leer.nextLine();
                    int indiceProducto = -1;
                    for (int i = 0; i < clavesProductos.length; i++) {
                        if (clavesProductos[i].equals(claveProducto)) {
                            indiceProducto = i;
                            break;
                        }
                    }
                    if (indiceProducto == -1 || productos[indiceProducto].isEmpty()) {
                        System.out.println("Producto no disponible.");
                        break;
                    }
                    precioProducto = preciosProductos[indiceProducto];
                    montoIngresado = 0;
                    while (montoIngresado < precioProducto) {
                        System.out.println("Ingrese monedas de 10, 5, 2, 1, 0.50 pesos:");
                        moneda = leer.nextDouble();
                        if (moneda == 10) {
                            monedas[0].enqueue("10 pesos");
                        } else if (moneda == 5) {
                            monedas[1].enqueue("5 pesos");
                        } else if (moneda == 2) {
                            monedas[2].enqueue("2 pesos");
                        } else if (moneda == 1) {
                            monedas[3].enqueue("1 peso");
                        } else if (moneda == 0.50) {
                            monedas[4].enqueue("0.50 pesos");
                        } else {
                            System.out.println("Moneda no reconocida.");
                            continue;
                        }
                        montoIngresado += moneda;
                        System.out.println("Monto ingresado: $" + montoIngresado);
                    }
                    productos[indiceProducto].dequeue();
                    System.out.println("Producto vendido: " + nombresProductos[indiceProducto]);
                    System.out.println("Monto total pagado: $" + montoIngresado);
                    if (montoIngresado > precioProducto) {
                        System.out.println("Cambio devuelto: $" + (montoIngresado - precioProducto));
                    }
                    break;
                case 3:
                    System.out.println("Cerrando máquina...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionMenu != 3);
        leer.close();
    }
}
