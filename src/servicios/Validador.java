package servicios;

public class Validador {

    public static boolean estaEntre(int numero,int min, int max){

        return min >= numero && max <= numero;
    }

    public static boolean tieneContenido(String texto){

        return !texto.isBlank();

    }

}
