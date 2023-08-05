package servicios;

public class Validador {

    public static boolean estaEntre(int numero,int min, int max){

        return numero >= min && numero <= max;
    }

    public static boolean tieneContenido(String texto){

        return !texto.isBlank();

    }

}
