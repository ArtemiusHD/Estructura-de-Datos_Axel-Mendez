package MaquinaDeComida;

public class Productos {
    private String nombre;
    private String clave;
    private int precio;
    private int cantidad;
    public Productos(String nombre, String clave, int precio, int cantidad) {
        this.nombre = nombre;
        this.clave = clave;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getClave() {
        return clave;
    }
    public int getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void venderProducto() {
        if (cantidad > 0) {
            cantidad--;
        } else {
            System.out.println("Producto no disponible.");
        }
    }
    public void rellenarStock(int cantidadAgregar) {
        this.cantidad += cantidadAgregar;
    }
}

