package servicios;

import controlador.app;

public class pideDatos {

    public static int pideNumero(String mensaje){

        System.out.println(mensaje);
        int numero = Integer.parseInt(app.sc.nextLine());

        return numero;
    }

}
