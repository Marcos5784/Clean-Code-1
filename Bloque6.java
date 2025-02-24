public class Bloque6 {

//TEST UNITARIOS
// (23)-->
// ESTO ESTARÍA MAL HECHO: No sigue las leyes del TDD
// Código sin test anterior

class Banco {
    public double calcularIntereses(double saldo, double tasa) {
        return saldo * tasa;
    }
}

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        System.out.println(banco.calcularIntereses(1000, 0.05)); 
    }
}

// ESTO ESTARÍA BIEN HECHO: Siguiendo las tres leyes del TDD

// 1--> Escribimos el test primero
@Test
public void testCalcularIntereses() {
    Banco banco = new Banco();
    double resultado = banco.calcularIntereses(1000, 0.05);
    assertEquals(50, resultado, 0.01); // El test fallará por la implementación, todavía no está escrita
}

// 2--> Escribimos lo necesario para el test
class Banco {
    public double calcularIntereses(double saldo, double tasa) {
        return saldo * tasa;
    }
}

// 3--> El test pasa con el código necesario 

@Test
public void testCalcularIntereses() {
    Banco banco = new Banco();
    double resultado = banco.calcularIntereses(1000, 0.05);
    assertEquals(50, resultado, 0.01); // Pasa bien
}


// (24)--> MANTENER LOS TEST LIMPIOS
// ESTO ESTARÍA MAL HECHO: Test desorganizado(desordenado)

@Test
public void testCuentaBancaria() {
    CuentaBancaria cuenta = new CuentaBancaria();
    
    cuenta.depositar(1000);
    double saldo1 = cuenta.obtenerSaldo();
    assertEquals(1000, saldo1);
    
    cuenta.retirar(500);
    double saldo2 = cuenta.obtenerSaldo();
    assertEquals(500, saldo2);
    
    cuenta.retirar(600); // Esto debería fallar porque el saldo es insuficiente
    double saldo3 = cuenta.obtenerSaldo();
    assertEquals(500, saldo3);
    
    // Este test es muy largo y es un poco difícil de mantener en el tiempo
}

// ESTO ESTARÍA BIEN HECHO: Tests organizados y limpios
@Test
public void testDepositar() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.depositar(1000);
    double saldo = cuenta.obtenerSaldo();
    assertEquals(1000, saldo);
}

@Test
public void testRetirarConSaldoSuficiente() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.depositar(1000);
    cuenta.retirar(500);
    double saldo = cuenta.obtenerSaldo();
    assertEquals(500, saldo);
}

@Test
public void testRetirarConSaldoInsuficiente() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.depositar(500);
    cuenta.retirar(600); // Debería fallar debido a saldo insuficiente
    double saldo = cuenta.obtenerSaldo();
    assertEquals(500, saldo); // El saldo sigue siendo el mismo
}


// (25)--> CLEAN TEST
// ESTO ESTARÍA MAL HECHO: Test difícil de leer y de poder comprender

@Test
public void testCuenta() {
    CuentaBancaria cuenta = new CuentaBancaria();
    assertTrue(cuenta.deposito(1000)); // Deposito exitoso
    assertFalse(cuenta.retirar(1500)); // Intento de retiro mayor al saldo
    assertTrue(cuenta.deposito(200)); // Nuevo depósito
    assertEquals(200, cuenta.obtenerSaldo()); // Verificar saldo
}

// ESTO ESTARÍA BIEN HECHO: Test legible

@Test
public void testDepositoExitoso() {
    CuentaBancaria cuenta = new CuentaBancaria();
    boolean resultado = cuenta.deposito(1000);
    assertTrue("El depósito de 1000 debería ser exitoso", resultado);
    assertEquals("El saldo después del depósito debe ser 1000", 1000, cuenta.obtenerSaldo());
}

@Test
public void testRetiroConSaldoInsuficiente() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.deposito(1000);
    boolean resultado = cuenta.retirar(1500);
    assertFalse("El retiro de 1500 no debería ser permitido, saldo insuficiente", resultado);
    assertEquals("El saldo debería seguir siendo 1000", 1000, cuenta.obtenerSaldo());
}

@Test
public void testDepositoAdicional() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.deposito(1000);
    cuenta.deposito(200);
    assertEquals("El saldo final debe ser 1200", 1200, cuenta.obtenerSaldo());
}


// (26)--> UN SOLO ASSERT POR CADA TEST
// ESTO ESTARÍA MAL HECHO: Una carga de asserts en un solo test hacen que sea difícil identificar qué está fallando

@Test
public void testCuentas() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.deposito(1000);
    assertEquals(1000, cuenta.obtenerSaldo());
    cuenta.retirar(500);
    assertEquals(500, cuenta.obtenerSaldo());  // Si falla aquí, no sabemos si es por el depósito o el retiro
    cuenta.retirar(200);
    assertEquals(300, cuenta.obtenerSaldo());
}

// ESTO ESTARÍA BIEN HECHO: Un solo assert por test
@Test
public void testDeposito() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.deposito(1000);
    assertEquals(1000, cuenta.obtenerSaldo());
}

@Test
public void testRetiro() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.deposito(1000);
    cuenta.retirar(500);
    assertEquals(500, cuenta.obtenerSaldo());
}

@Test
public void testRetiroAdicional() {
    CuentaBancaria cuenta = new CuentaBancaria();
    cuenta.deposito(1000);
    cuenta.retirar(500);
    cuenta.retirar(200);
    assertEquals(300, cuenta.obtenerSaldo());
}


// (27)--> UN SOLO CONCEPTO
// ESTO ESTARÍA MAL HECHO: Test que prueba varios conceptos al mismo tiempo

@Test
public void testOperacionesBasicas() {
    Calculadora calculadora = new Calculadora();
    
    // Verificar la suma
    int suma = calculadora.sumar(2, 3);
    
    // Verificar la resta
    int resta = calculadora.restar(5, 3);
    
    // Verificar ambos resultados en el mismo test
    assertEquals(5, suma);  // Prueba de suma
    assertEquals(2, resta); // Prueba de resta
}

// Buena práctica: Cada test verifica un solo concepto

@Test
public void testSuma() {
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.sumar(2, 3));  // Solo prueba la suma
}

@Test
public void testResta() {
    Calculadora calculadora = new Calculadora();
    assertEquals(2, calculadora.restar(5, 3));  // Solo prueba la resta
}


// (28)--> REGLA F.I.R.S.T
// ESTO ESTARÍA MAL HECHO: Test que no es rápido ni repetible

@Test
public void testObtenerDatosDelServicio() {
    ServicioWeb servicioWeb = new ServicioWeb();
    String datos = servicioWeb.obtenerDatos(); // La respuesta del servicio puede cambiar según el entorno o la red
    assertNotNull(datos);
    assertTrue(datos.contains("nombre"));
}

// ESTO ESTARÍA BIEN HECHO: Test rápido, independiente y repetible

@Test
public void testCalcularAreaRectangulo() {
    Geometria geometria = new Geometria();
    double area = geometria.calcularAreaRectangulo(5, 3);
    assertEquals(15, area, 0.001);  // Test rápido, sin dependencias externas, siempre da el mismo resultado
}

@Test
public void testCalcularPerimetroRectangulo() {
    Geometria geometria = new Geometria();
    double perimetro = geometria.calcularPerimetroRectangulo(5, 3);
    assertEquals(16, perimetro, 0.001);  // Test repetible y predecible, sin dependencias externas
}
}