public class Bloque4 {

// (17)--> DIFERENCIAS ENTRE ESTRUCTURA DE DATOS Y OBJETOS

//  ESTO ESTARÍA MAL HECHO: La clase "Usuario" tiene tanto los datos como la lógica de validación
class Usuario {
    public String nombre;
    public String correo;
    public String password;
    
    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    // Lógica de validación incluida en la clase, lo cual es una mala práctica
    public boolean validarCorreo() {
        return correo.contains("@");
    }

    public boolean validarPassword() {
        return password.length() > 6;
    }
}

// ESTO ESTARÍA BIEN HECHO: La clase "Usuario" solo contiene datos
class Usuarioo {
    private String nombre;
    private String correo;
    private String password;
    
    public Usuarioo(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }
}

// La clase "Validador" maneja la lógica de validación
class Validador {
    public boolean validarCorreo(Usuario usuario) {
        return usuario.getCorreo().contains("@");
    }

    public boolean validarPassword(Usuario usuario) {
        return usuario.getPassword().length() > 6;
    }
}

// (18)--> LEY DE DEMETER

// ESTO ESTARÍA MAL HECHO: La clase "Factura" conoce demasiados detalles internos del objeto "Cliente"
class Factura {
    private Cliente cliente;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public void imprimirFactura() {
        // La clase Factura accede directamente a los detalles internos del cliente y su historial de compras
        String producto = cliente.getHistorialCompras().getProducto().getNombre();
        double precio = cliente.getHistorialCompras().getProducto().getPrecio();
        System.out.println("Factura para " + cliente.getNombre() + ": " + producto + " - " + precio);
    }
}

class Cliente {
    private String nombre;
    private HistorialCompras historialCompras;

    public Cliente(String nombre, HistorialCompras historialCompras) {
        this.nombre = nombre;
        this.historialCompras = historialCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public HistorialCompras getHistorialCompras() {
        return historialCompras;
    }
}

class HistorialCompras {
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }
}

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

// ESTO ESTARÍA BIEN HECHO: La clase "Factura" solo interactúa con métodos públicos del objeto Cliente sin conocer detalles internos
class Factura {
    private Cliente cliente;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public void imprimirFactura() {
        // La clase Factura solo conoce lo que necesita para imprimir la factura
        String producto = cliente.obtenerUltimaCompraProducto();
        double precio = cliente.obtenerUltimaCompraPrecio();
        System.out.println("Factura para " + cliente.getNombre() + ": " + producto + " - " + precio);
    }
}

class Cliente {
    private String nombre;
    private HistorialCompras historialCompras;

    public Cliente(String nombre, HistorialCompras historialCompras) {
        this.nombre = nombre;
        this.historialCompras = historialCompras;
    }

    public String getNombre() {
        return nombre;
    }

    // La clase Cliente proporciona un método directo para obtener el producto y el precio sin exponer detalles internos
    public String obtenerUltimaCompraProducto() {
        return historialCompras.obtenerProductoNombre();
    }

    public double obtenerUltimaCompraPrecio() {
        return historialCompras.obtenerProductoPrecio();
    }
}

class HistorialCompras {
    private Producto producto;

    // Métodos públicos que la clase Cliente utiliza para abstraer los detalles internos
    public String obtenerProductoNombre() {
        return producto.getNombre();
    }

    public double obtenerProductoPrecio() {
        return producto.getPrecio();
    }
}

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
}