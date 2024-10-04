package Banco;
public class Deposito extends Transaccion {
    public String realizar(ClienteConCuenta cliente, Banco banco, double monto) {
        if (Transaccion.nominacionValida(monto)) {
            cliente.setSaldo(cliente.getSaldo() + monto);
            banco.setDineroBanco(banco.getDineroBanco() + monto);
            return "Depósito exitoso. El nuevo saldo del cliente es $"
                    + String.format("%.2f", cliente.getSaldo());
        } else {
            return "Denominación no válida.";
        }
    }
}

