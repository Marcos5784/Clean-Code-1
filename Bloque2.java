public class Bloque2 {

    //1--> LAS FUNCIONES NO DEBEN SER GIGANTES

    public void gestionarCuenta() { // ESTO ESTÁ MAL HECHO
        System.out.println("Bienvenido a tu cuenta");
        System.out.println("Comprobando saldo...");
        double saldo = obtenerSaldo();
        System.out.println("Tu saldo es: " + saldo);
        System.out.println("¿Quieres realizar un depósito?");
        double deposito = obtenerDeposito();
        saldo = saldo + deposito;
        System.out.println("Nuevo saldo: " + saldo);
        System.out.println("¿Te gustaría realizar un retiro?");
        double retiro = obtenerRetiro();
        saldo = saldo - retiro;
        System.out.println("Saldo final: " + saldo);
        System.out.println("Gracias por usar el servicio.");
    }
    
    
    public void gestionarCuentaa() { // ESTO ESTÁ BIEN HECHO
        mostrarBienvenida();
        double saldo = obtenerSaldo();
        mostrarSaldo(saldo);
        double deposito = obtenerDeposito();
        saldo = realizarDeposito(saldo, deposito);
        mostrarSaldo(saldo);
        double retiro = obtenerRetiro();
        saldo = realizarRetiro(saldo, retiro);
        mostrarSaldo(saldo);
        despedirUsuario();
    }
    
    private void mostrarBienvenida() {
        System.out.println("Bienvenido a tu cuenta");
    }
    
    private double obtenerSaldo() {
        System.out.println("Comprobando saldo...");
        // Aquí iría el código para obtener el saldo
        return 1000.00;  // Ejemplo de saldo
    }
    
    private void mostrarSaldo(double saldo) {
        System.out.println("Tu saldo es: " + saldo);
    }
    
    private double obtenerDeposito() {
        System.out.println("¿Quieres realizar un depósito?");
        // Aquí iría el código para obtener el monto a depositar
        return 500.00;  // Ejemplo de monto a depositar
    }
    
    private double realizarDeposito(double saldo, double deposito) {
        return saldo + deposito;
    }
    
    private double obtenerRetiro() {
        System.out.println("¿Te gustaría realizar un retiro?");
        // Aquí iría el código para obtener el monto a retirar
        return 200.00;  // Ejemplo de monto a retirar
    }
    
    private double realizarRetiro(double saldo, double retiro) {
        return saldo - retiro;
    }
    
    private void despedirUsuario() {
        System.out.println("Gracias por usar el servicio.");
    }
    


    //2--> HAZ SOLO UNA COSA, USA DIFERENTES FUNCIONES

    public void procesarNumero(int numero) { // ESTO ESTÁ MAL HECHO
        if (numero > 0) {
            System.out.println("El número es positivo");
            System.out.println("Calculando el cuadrado...");
            System.out.println("Resultado: " + (numero * numero));
        } else {
            System.out.println("El número es negativo o cero");
            System.out.println("Calculando el valor absoluto...");
            System.out.println("Resultado: " + Math.abs(numero));
        }
    }
    

    public void verificarPositivo(int numero) { // ESTO ESTÁ BIEN HECHO
        if (numero > 0) {
            System.out.println("El número es positivo");
        } else {
            System.out.println("El número es negativo o cero");
        }
    }
    
    public void calcularCuadrado(int numero) { // ESTO ESTÁ BIEN HECHO
        System.out.println("Calculando el cuadrado...");
        System.out.println("Resultado: " + (numero * numero));
    }
    
    public void calcularValorAbsoluto(int numero) { // ESTO ESTÁ BIEN HECHO
        System.out.println("Calculando el valor absoluto...");
        System.out.println("Resultado: " + Math.abs(numero));
    }
    


    
    //3--> NO ABUSES DE LOS SWITCH

    public void saludo(String idioma) { // ESTO ESTÁ MAL HECHO
        switch (idioma) {
            case "es": System.out.println("¡Hola!"); break;
            case "en": System.out.println("Hello!"); break;
            case "fr": System.out.println("Bonjour!"); break;
            default: System.out.println("¡Hola!");
        }
    }
    

    public void saludoo(String idioma) { // ESTO ESTÁ BIEN HECHO
        if ("es".equals(idioma)) {
            System.out.println("¡Hola!");
        } else if ("en".equals(idioma)) {
            System.out.println("Hello!");
        } else if ("fr".equals(idioma)) {
            System.out.println("Bonjour!");
        } else {
            System.out.println("¡Hola!");
        }
    }
    
    
    //4--> LOS ARGUMENTOS QUE DEBE TENER UNA FUNCIÓN

    public void nombre(String nombre, String numero, String dir) { // ESTO ESTARÍA MAL HECHO
        System.out.println("Nombre: " + nombre);
    }

    public void nombre(String nombre) { // ESTO ESTARÍA BIEN HECHO
        System.out.println("Nombre: " + nombre);
    }
    
    //5--> EVITA LOS VALORES PARA ACTIVAR O DESACTIVAR UNA FUNCIONALIDAD ESPECÍFICA.

    public void procesar(int numero, boolean esPositivo) { // ESTO ESTÁ MAL HECHO
        if (esPositivo) {
            System.out.println("Número positivo: " + numero);
        } else {
            System.out.println("Número negativo: " + numero);
        }
    }

    public void procesarNumeroPositivo(int numero) { // ESTO ESTÁ BIEN HECHO
        System.out.println("Número positivo: " + numero);
    }
    
    public void procesarNumeroNegativo(int numero) { // ESTO ESTÁ BIEN HECHO
        System.out.println("Número negativo: " + numero);
    }
    
    

    //6--> NO GENERES EFECTOS COLATERALES

    public void realizarOperacion() { // ESTO ESTÁ MAL HECHO
        int resultado = 10 + 5;
        System.out.println("Resultado: " + resultado); // Imprime el resultado, generando un efecto colateral
        almacenarResultado(resultado); // Guarda el resultado en alguna parte
    }
    
    public void almacenarResultado(int resultado) {
        System.out.println("Guardando resultado...");
    }
    
    public int realizarOperacionn() { // ESTO ESTÁ BIEN HECHO
        return 10 + 5; // Devuelve el resultado sin generar efectos colaterales
    }
    
    public void almacenarResultadoo(int resultado) { // ESTO ESTÁ BIEN HECHO
        System.out.println("Guardando resultado...");
    }
    
    
    //7--> NO SEAS REPETITIVO

    public void sumar() { // ESTO ESTÁ MAL HECHO
        int resultado = 5 + 3;
        System.out.println("Resultado de la suma: " + resultado);
    }
    
    public void multiplicar() { // ESTO ESTÁ MAL HECHO
        int resultado = 5 * 3;
        System.out.println("Resultado de la multiplicación: " + resultado);
    }
    

    public void realizarOperacion(String operacion) { // ESTO ESTÁ BIEN HECHO
        int resultado = operar(5, 3, operacion);
        System.out.println("Resultado de la " + operacion + ": " + resultado);
    }
    
    public int operar(int a, int b, String operacion) { // ESTO ESTÁ BIEN HECHO
        if ("suma".equals(operacion)) {
            return a + b;
        } else if ("multiplicación".equals(operacion)) {
            return a * b;
        }
        return 0;
    }
    

}