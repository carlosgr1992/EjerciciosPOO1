package controlador;

import modelo.Persona;
import modelo.Producto;
import org.w3c.dom.ls.LSOutput;
import servicios.Validador;
import servicios.pideDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {

    private static final int NUM_PERSONAS = 3;
    public static Scanner sc = new Scanner(System.in);
    public static List<Persona> personas;
    public static Persona [] persona;

    private static void inicializar() {

        if(personas == null){
            personas = new ArrayList<Persona>();
        }

        persona = new Persona[NUM_PERSONAS];

    }


    private static void ejercicio1() {

        Persona carlos = new Persona("Carlos García", 31);
        System.out.println(carlos.presentar());

        Persona pSinNombre = new Persona(25);
        System.out.println(pSinNombre.presentar());
    }

    private static void ejercicio5() {

        Producto platano = new Producto("plátano");

        System.out.println(platano.creaEtiqueta());

        Producto jamon = new Producto("jamón");
        Producto aceite = new Producto("aceite 5L",32.99);
        Producto arroz = new Producto("arroz",1.25);
        Producto gel = new Producto("gel de ducha",2.70);

        Producto[] miCarro = {jamon,aceite,arroz,gel};

        for(int i = 0; i < miCarro.length; i++){
            System.out.println(miCarro[i].creaEtiqueta());
        }
    }

    private static void muestraPersonas() {

        for (Persona p : persona) {
            System.out.println(p.presentar());
        }
    }

    private static void ejercicio7() {


        for(int i = 0; i < persona.length; i++) {
            System.out.println("Introduce nombre de la persona:");
            String nombre = sc.nextLine();

            int edad = 0;
            do {
                edad = pideDatos.pideNumero("Introduce una edad:");
            } while (Validador.estaEntre(edad, 0, 99));

            persona[i] = new Persona(nombre,edad);
        }

        muestraPersonas();

    }

    private static void ejercicio8() {



    }

    public static void main(String[] args) {

        inicializar();

        System.out.println("-----Ejercicio 1-4-----");
        ejercicio1();
        System.out.println("-----Ejercicio 5-----");
        ejercicio5();
        System.out.println("-----Ejercicio 7-----");
        ejercicio7();
        System.out.println("-----Ejercicio 8-----");
        ejercicio8();

    }

}
