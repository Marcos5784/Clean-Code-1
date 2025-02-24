public class Bloque7 {

// (29)--> ORGANIZACIÓN DE LAS CLASES
// ESTO ESTARÍA MAL HECHO: La clase tiene una estructura desordenada, con métodos y variables mezclados de forma poco clara

class Coche {
    public String marca;   // Variables públicas al principio
    private int año;       // Variables privadas al final
    private String modelo;
    
    public void arrancar() {
        // Lógica de arranque
    }
    
    public void frenar() {
        // Lógica de freno
    }

    // Métodos privados no relacionados directamente con las funcionalidades públicas
    private void calcularEmisiones() {
        // Lógica interna innecesaria aquí
    }
    
    private void mostrarDetalles() {
        // Lógica interna para mostrar detalles
    }
}

// ESTO ESTARÍA BIEN HECHO: La clase está estructurada de forma clara y organizada

class Coche {
    // Variables públicas (si es necesario tenerlas, aunque es recomendable que sean privadas)
    public String marca;
    
    // Variables privadas, agrupadas al principio
    private int año;       
    private String modelo;
    
    // Métodos públicos a continuación, que exponen el comportamiento del coche
    public void arrancar() {
        // Lógica de arranque
    }
    
    public void frenar() {
        // Lógica de freno
    }
    
    // Métodos privados al final, solo utilizados dentro de la clase
    private void calcularEmisiones() {
        // Lógica interna
    }
    
    private void mostrarDetalles() {
        // Lógica interna para mostrar detalles
    }
}


// (30)--> LAS CLASES DEBEN SER PEQUEÑAS
// ESTO ESTARÍA MAL HECHO: La clase crece demasiado y mezcla responsabilidades

class GestionPedido {
    private String numeroPedido;
    private String fecha;
    private String cliente;
    private double total;

    public void actualizarNumeroPedido(String numero) {
        this.numeroPedido = numero;
    }

    public void actualizarFecha(String nuevaFecha) {
        this.fecha = nuevaFecha;
    }

    public void actualizarCliente(String nuevoCliente) {
        this.cliente = nuevoCliente;
    }

    public void actualizarTotal(double nuevoTotal) {
        this.total = nuevoTotal;
    }

    // Función que realiza múltiples tareas no relacionadas
    public void procesarPedido() {
        // Lógica de procesamiento de pedidos (p.ej., calcular total, enviar confirmación, etc.)
    }
    
    public void enviarConfirmacion() {
        // Lógica para enviar una confirmación de pedido
    }

    public void aplicarDescuento() {
        // Lógica para aplicar un descuento al pedido
    }
}

// ESTO ESTARÍA BIEN HECHO: Clases pequeñas, cada una enfocada solo en una tarea

class GestionNumeroPedido {
    private String numeroPedido;

    public void actualizarNumeroPedido(String numero) {
        this.numeroPedido = numero;
    }
}

class GestionFecha {
    private String fecha;

    public void actualizarFecha(String nuevaFecha) {
        this.fecha = nuevaFecha;
    }
}

class GestionCliente {
    private String cliente;

    public void actualizarCliente(String nuevoCliente) {
        this.cliente = nuevoCliente;
    }
}

class GestionTotal {
    private double total;

    public void actualizarTotal(double nuevoTotal) {
        this.total = nuevoTotal;
    }
}

class EnviarConfirmacion {
    public void enviar() {
        // Lógica para enviar una confirmación de pedido
    }
}

class AplicarDescuento {
    public void aplicar() {
        // Lógica para aplicar un descuento al pedido
    }
}


// (31)--> PRINCIPIO DE RESPONSABILIDAD ÚNICA
// ESTO ESTARÍA MAL HECHO: Clase con múltiples responsabilidades, lo que hace difícil de mantener

class Pedido {
    private String numeroPedido;
    private double total;
    
    public void agregarProducto(String producto, double precio) {
        // Lógica para agregar producto al pedido
    }

    public void calcularTotal() {
        // Lógica para calcular el total del pedido
    }

    public void enviarConfirmacion() {
        // Lógica para enviar una confirmación, lo cual debería estar en otra clase
    }
}

// ESTO ESTARÍA BIEN HECHO: Cada clase tiene una única responsabilidad

class Pedido {
    private String numeroPedido;
    private double total;
    
    public void agregarProducto(String producto, double precio) {
        // Lógica para agregar producto al pedido
    }

    public void calcularTotal() {
        // Lógica para calcular el total del pedido
    }
}

class ConfirmacionPedido {
    public void enviarConfirmacion(String numeroPedido) {
        // Lógica para enviar una confirmación de pedido
    }
}


// (32)--> COHESIÓN
// ESTO ESTARÍA MAL HECHO: La clase no es cohesiva

class Empleado {
    private String nombre;
    private String puesto;
    private double salario;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void realizarOperacionBancaria(double monto) {
        // Lógica que no tiene nada que ver con el concepto de Empleado
    }

    public void realizarEvaluacionDesempeno() {
        // Lógica que también no tiene mucho sentido en esta clase
    }
}

// ESTO ESTARÍA BIEN HECHO: Cada método trabaja sobre las variables de instancia de la clase

class Empleado {
    private String nombre;
    private String puesto;
    private double salario;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void actualizarPuesto(String nuevoPuesto) {
        this.puesto = nuevoPuesto;
    }

    public void actualizarSalario(double nuevoSalario) {
        this.salario = nuevoSalario;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public String obtenerPuesto() {
        return this.puesto;
    }
    
    public double obtenerSalario() {
        return this.salario;
    }
}


// (33)--> ORGANIZA TU CÓDIGO PARA QUE ESTÉ PREPARADO PARA EL CAMBIO
// ESTO ESTARÍA MAL HECHO: Dependencia directa de detalles de implementación

class Pago {
    private String metodoPago;

    public Pago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void procesarPago() {
        if (metodoPago.equals("tarjeta")) {
            // lógica para pagar con tarjeta
        } else if (metodoPago.equals("paypal")) {
            // lógica para pagar con PayPal
        } else {
            // lógica para otro método de pago
        }
    }
}

// ESTO ESTARÍA BIEN HECHO: El código depende de abstracciones y no de detalles de implementación

interface MetodoPago {
    void procesarPago();
}

class PagoConTarjeta implements MetodoPago {
    public void procesarPago() {
        // lógica para pagar con tarjeta
    }
}

class PagoConPayPal implements MetodoPago {
    public void procesarPago() {
        // lógica para pagar con PayPal
    }
}

class Pago {
    private MetodoPago metodoPago;

    public Pago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void procesarPago() {
        metodoPago.procesarPago();
    }
}



// (34)--> SEPARA LA CONSTRUCCIÓN DE UN SIST. DE SU USO
// ESTO ESTARÍA MAL HECHO: La creación de objetos y la lógica de negocio están mezcladas, lo que dificulta el testing

class CarroCompra {
    private Pago pago;

    public CarroCompra() {
        // Instanciación dentro de la lógica de negocio
        this.pago = new PagoConTarjeta();  // PagoConTarjeta es creado directamente aquí
    }

    public void realizarCompra() {
        pago.procesarPago();  // El acoplamiento entre CarroCompra y Pago es fuerte
    }
}

class PagoConTarjeta {
    public void procesarPago() {
        // Lógica para procesar el pago con tarjeta
    }
}

// ESTO ESTARÍA BIEN HECHO: Se utiliza inyección de dependencias para separar la creación de objetos

class CarroCompra {
    private Pago pago;

    public CarroCompra(Pago pago) {
        this.pago = pago;  // El objeto Pago se inyecta, desacoplando la construcción
    }

    public void realizarCompra() {
        pago.procesarPago();
    }
}

interface Pago {
    void procesarPago();
}

class PagoConTarjeta implements Pago {
    public void procesarPago() {
        // Lógica para procesar el pago con tarjeta
    }
}

class PagoConPayPal implements Pago {
    public void procesarPago() {
        // Lógica para procesar el pago con PayPal
    }
}

// En otro lugar del código, se inyecta la dependencia
Pago pago = new PagoConTarjeta();  // O también se podría inyectar un PagoConPayPal
CarroCompra carroCompra = new CarroCompra(pago);



// (35)--> UTILIZA COPIAS DE LOS OBJETOS PARA PODER TRABAJAR CON CONCURRENCIA
// ESTO ESTARÍA MAL HECHO: Modificar un objeto compartido entre hilos sin control de concurrencia

class Banco {
    private int saldo;

    public void realizarTransferencia(int cantidad) {
        saldo -= cantidad;  // El saldo puede ser modificado por varios hilos a la vez, lo que causa problemas
    }

    public int obtenerSaldo() {
        return saldo;
    }
}

class HiloTransferencia extends Thread {
    private Banco banco;

    public HiloTransferencia(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void run() {
        banco.realizarTransferencia(50);  // Problema si dos hilos modifican 'saldo' simultáneamente
    }
}

// ESTO ESTARÍA BIEN HECHO: Crear una copia del objeto para evitar problemas de concurrencia

class Banco {
    private final int saldo;

    public Banco(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public Banco realizarTransferencia(int cantidad) {
        return new Banco(saldo - cantidad);  // Retornamos una nueva instancia con el saldo actualizado
    }

    public int obtenerSaldo() {
        return saldo;
    }
}

class HiloTransferencia extends Thread {
    private Banco banco;

    public HiloTransferencia(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void run() {
        banco = banco.realizarTransferencia(50);  // Se crea una nueva instancia de Banco con el saldo actualizado
    }
}
}