public class Bloque3 {
    
    //1--> USA CÓDIGO QUE EXPLIQUE PROPIAMENTE LO QUE HACE


    public int s(int x, int y) { // ESTO ESTARÍA MAL HECHO
        return x + y;
    }

    public int sumarDosNumeros(int primerNumero, int segundoNumero) {  // ESTO ESTARÍA BIEN HECHO
        return primerNumero + segundoNumero;
    }



    //2--> LOS COMENTARIOS TIENEN QUE DECIR QUÉ HACE EL CÓDIGO Y NO DECIR CÓMO LO HACE

    // Realiza una operación de resta
    public int realizarResta(int x, int y) { // ESTO ESTARÍA MAL HECHO
        return x - y; 
    }

    // Resta dos números
    public int restar(int minuendo, int sustraendo) { // ESTO ESTARÍA BIEN HECHO
        return minuendo - sustraendo;
    }


    
    //3--> A VECES LOS COMENTARIOS NO SON TOTALMENTE NECESARIOS

    // Hace algo con un número
    public int hacerAlgo(int n) { // ESTO ESTARÍA MAL HECHO
        return n * 2;
    }

    // Retorna el cuadrado de un número
    public int calcularCuadrado(int numero) { // ESTO ESTARÍA BIEN HECHO
        return numero * numero;
    }


    
     //4--> LOS COMENTARIOS A VECES NO ESTÁN BIEN


     public int multiplicar(int numero1, int numero2) {  // ESTO ESTARÍA MAL HECHO
        return numero1 * numero2;
    }

    public int m(int a, int b) {  // ESTO ESTARÍA BIEN HECHO
        int r = 0;
        for (int i = 0; i < b; i++) {
            r += a;
        }
        return r;
    }

}