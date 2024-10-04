package Banco;
import java.util.Scanner;
public class MainBank {
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
                        clienteConCuenta = new ClienteConCuenta(nombre, saldo);
                        banco.agregarCliente(clienteConCuenta);
                    } else {
                        clienteSinCuenta = new ClienteSinCuenta(nombre, saldo);
                        banco.agregarCliente(clienteSinCuenta);
                    }
                    System.out.println("Cliente agregado exitosamente.");
                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    Persona cliente = banco.siguienteCliente();
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
                    System.out.println(banco.mostrarFila());
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
    //NOTA: En esta tarea, en el main me apoye de inteligencia artificial y tantito en como dividi las clases para poder meter herencias
}




