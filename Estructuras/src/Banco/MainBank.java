package Banco;
import java.util.Scanner;
import Queue.NumericPriorityQueue;

public class MainBank {
    private static NumericPriorityQueue colaPrioridad1 = new NumericPriorityQueue();
    private static NumericPriorityQueue colaPrioridad2 = new NumericPriorityQueue();
    private static NumericPriorityQueue colaPrioridad3 = new NumericPriorityQueue();
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Banco banco = new Banco();
        ClienteSinCuenta clienteSinCuenta;
        ClienteConCuenta clienteConCuenta;
        String nombre;
        double saldo;
        String tipoCliente;
        Persona[] clientesAsignados = new Persona[4];
        while (true) {
            System.out.println("""
                Para admitir a un cliente presione: 1
                Para pasar a un cliente a su fila correspondiene presione: 2
                Para atender una caja presione: 3
                Para consultar el estado de las fila presione: 4
                Para salir presione: 5""");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(leer.nextLine());
            System.out.println("----------------------------------------");
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    nombre = leer.nextLine();
                    System.out.print("Ingrese el saldo del cliente: ");
                    saldo = Double.parseDouble(leer.nextLine());
                    System.out.print("¿El cliente tiene cuenta? (s/n): ");
                    tipoCliente = leer.nextLine();
                    if (tipoCliente.equalsIgnoreCase("s")) {
                        System.out.print("Ingrese el número de cuenta: ");
                        String numeroCuenta = leer.nextLine();

                        int prioridad = obtenerPrioridad(numeroCuenta);
                        if (prioridad == -1) {
                            System.out.println("Número de cuenta no reconocido. Intente nuevamente.");
                            continue;
                        }
                        clienteConCuenta = new ClienteConCuenta(nombre, saldo);
                        switch (prioridad) {
                            case 1 -> colaPrioridad1.enqueue(clienteConCuenta, prioridad);
                            case 2 -> colaPrioridad2.enqueue(clienteConCuenta, prioridad);
                            case 3 -> colaPrioridad3.enqueue(clienteConCuenta, prioridad);
                        }
                    } else {
                        clienteSinCuenta = new ClienteSinCuenta(nombre, saldo);
                        banco.agregarCliente(clienteSinCuenta);
                    }
                    System.out.println("Cliente agregado exitosamente.");
                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    Persona cliente = obtenerSiguienteCliente();
                    if (cliente == null) {
                        System.out.println("No hay más clientes en la fila.");
                        System.out.println("----------------------------------------");
                        break;
                    }
                    int cajaAsignada = banco.asignarCaja();
                    if (cajaAsignada == -1) {
                        System.out.println("No hay cajas disponibles en este momento.");
                        System.out.println("----------------------------------------");
                        break;
                    }
                    clientesAsignados[cajaAsignada - 1] = cliente;
                    System.out.println("Cliente asignado a caja " + cajaAsignada + ": " + cliente);
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    System.out.println("Seleccione la caja a atender (1-4):");
                    for (int i = 1; i <= 4; i++) {
                        System.out.println(i + ". Caja " + i);
                    }
                    int cajaSeleccionada = Integer.parseInt(leer.nextLine());
                    if (cajaSeleccionada < 1 || cajaSeleccionada > 4) {
                        System.out.println("Caja no válida.");
                        System.out.println("----------------------------------------");
                        break;
                    }
                    cliente = clientesAsignados[cajaSeleccionada - 1];
                    if (cliente == null) {
                        System.out.println("No hay clientes asignados a la caja " + cajaSeleccionada);
                        System.out.println("----------------------------------------");
                        break;
                    }
                    System.out.println("Atendiendo a: " + cliente + " en caja " + cajaSeleccionada);
                    boolean continuar = true;
                    while (continuar) {
                        System.out.println("¿Desea realizar un depósito o un retiro? (d/r) o (0 para salir): ");
                        String tipoTransaccion = leer.nextLine();
                        if (tipoTransaccion.equalsIgnoreCase("d")) {
                            Deposito deposito = new Deposito();
                            while (true) {
                                System.out.println("Ingrese la denominación a depositar (0 para finalizar): ");
                                System.out.println("Denominaciones aceptadas (0.50,1,2,5,10,20,50,100,200,500,1000)");
                                double montoDepositar = Double.parseDouble(leer.nextLine());
                                if (montoDepositar == 0) {
                                    break;
                                }
                                if (!Transaccion.nominacionValida(montoDepositar)) {
                                    System.out.println("Denominación no existente. Ingrese una denominación válida.");
                                    continue;
                                }
                                String resultado = deposito.realizar(cliente instanceof ClienteConCuenta ? (ClienteConCuenta) cliente : null, banco, montoDepositar);
                                System.out.println(resultado);
                            }
                        } else if (tipoTransaccion.equalsIgnoreCase("r")) {
                            if (!(cliente instanceof ClienteConCuenta)) {
                                System.out.println("El cliente no tiene cuenta, no se puede retirar.");
                                continue;
                            }
                            Retiro retiro = new Retiro();
                            System.out.print("Ingrese la cantidad a retirar: ");
                            double montoRetirar = Double.parseDouble(leer.nextLine());
                            String resultado = retiro.realizar((ClienteConCuenta) cliente, banco, montoRetirar);
                            System.out.println(resultado);
                        } else if (tipoTransaccion.equals("0")) {
                            continuar = false;
                        } else {
                            System.out.println("Tipo de transacción no válido.");
                            System.out.println("----------------------------------------");
                        }
                    }
                    banco.liberarCaja(cajaSeleccionada);
                    clientesAsignados[cajaSeleccionada - 1] = null;
                    break;
                case 4:
                    System.out.println("Estado de las filas:");
                    System.out.println("Fila General: " + banco.mostrarFila());
                    System.out.println("Fila Prioridad 1: " + colaPrioridad1.toString());
                    System.out.println("Fila Prioridad 2: " + colaPrioridad2.toString());
                    System.out.println("Fila Prioridad 3: " + colaPrioridad3.toString());
                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.....");
                    leer.close();
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    private static int obtenerPrioridad(String numeroCuenta) {
        if (numeroCuenta.startsWith("042")) {
            return 1;
        } else if (numeroCuenta.startsWith("022")) {
            return 2;
        } else if (numeroCuenta.startsWith("011")) {
            return 3;
        } else {
            return -1;
        }
    }
    private static Persona obtenerSiguienteCliente() {
        if (!colaPrioridad1.isEmpty()) {
            return (Persona) colaPrioridad1.dequeue();
        } else if (!colaPrioridad2.isEmpty()) {
            return (Persona) colaPrioridad2.dequeue();
        } else if (!colaPrioridad3.isEmpty()) {
            return (Persona) colaPrioridad3.dequeue();
        } else {
            Banco banco = new Banco();
            return banco.siguienteCliente();
        }
    }
}