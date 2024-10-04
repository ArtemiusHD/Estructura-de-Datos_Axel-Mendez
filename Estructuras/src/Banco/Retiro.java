package Banco;

public class Retiro extends Transaccion {
    public String realizar(ClienteConCuenta cliente, Banco banco, double cantidad) {
        if (cliente.getSaldo() >= cantidad && banco.getDineroBanco() >= cantidad) {
            cliente.setSaldo(cliente.getSaldo() - cantidad);
            banco.setDineroBanco(banco.getDineroBanco() - cantidad);
            return "Retiro exitoso. El nuevo saldo del cliente es $" + String.format("%.2f", cliente.getSaldo());
        } else {
            return "No se puede retirar";
        }
    }
}