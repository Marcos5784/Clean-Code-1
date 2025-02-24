public class Bloque5 {

// (19)--> USO DE EXCEPCIONES EN LUGAR DE CODIGO DE RETORNO
// ESTO ESTARÍA MAL HECHO: Usar códigos de retorno para indicar si un archivo se encuentra o no
class GestorArchivos {
    public int leerArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            return -1; // Error, no encuentra el archivo
        }
        return 0; // Archivo ahora sí leido
    }
}

// ESTO ESTARÍA BIEN HECHO: Lanzar una excepción cuando el archivo no se encuentra
class GestorArchivos {
    public void leerArchivo(String nombreArchivo) throws FileNotFoundException {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo no fue encontrado: " + nombreArchivo);
        }
        // Lógica para leer el archivo.
    }
}


// (20)--> ESCRIBIR PRIMERO; try-catch-finally

// ESTO ESTARÍA MAL HECHO: No manejar el estado en el catch al interactuar con la BBDD
class BaseDeDatos {
    public void consultar() {
        try {
            // Intentar realizar consulta a la BBDD
            throw new Exception("Error en la consulta");
        } catch (Exception e) {
            // No se asegura de que la BBDD quede en un estado consistente
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// ESTO ESTARÍA BIEN HECHO: Asegurar que el estado de la BBDD esté limpio y consistente
class BaseDeDatos {
    public void consultar() {
        try {
            // Intentar realizar consulta a la BBDD
            throw new Exception("Error en la consulta");
        } catch (Exception e) {
            // Manejar el error y asegurar la integridad
            System.out.println("Error: " + e.getMessage());
            // Si es necesario, hacer un rollback o acciones correctivas
        } finally {
            // Asegurar que la conexión a la BBDD se cierre correctamente
            System.out.println("Cerrando conexión a la BBDD.");
        }
    }
}


// (21)--> USAR EXCEPCIONES UNCHECKED
// ESTO ESTARÍA MAL HECHO: Forzar a capturar o declarar la excepción (checked exception)
class Servidor {
    public void iniciar() throws InterruptedException {
        // Intento de iniciar el servidor
        throw new InterruptedException("Error al iniciar el servidor");
    }
}

// ESTO ESTARÍA BIEN HECHO: Usar excepciones unchecked (RuntimeException)
class Servidor {
    public void iniciar() {
        / Intento de iniciar el servidor
        throw new RuntimeException("Error al iniciar el servidor");
    }
}


// (22)--> NO DEVOLVER NULL
// ESTO ESTARÍA MAL HECHO: Devolver null puede dar un NullPointerException
class Producto {
    public Categoria obtenerCategoria() {
        return null; // Puede causar un error al intentar acceder 
    }
}

// ESTO ESTARÍA BIEN HECHO: No devolver null, usar un valor por defecto
class Producto {
    public Categoria obtenerCategoria() {
        return new Categoria("Categoría no disponible"); // Valor por defecto en vez de null
    }
}
}