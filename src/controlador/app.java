package controlador;

import modelo.Meteo;
import modelo.Persona;
import modelo.Producto;
import servicios.Aleatorio;
import servicios.Validador;
import servicios.Entrada;

import java.util.Scanner;

public class app {


    private static final int MIN_PERSONAS = 1;
    private static final int MAX_PERSONAS = 6;
    private static final int NUM_PERSONAS = 3;
    public static Scanner sc = new Scanner(System.in);

    public static Persona [] personasArray;

    private static void inicializar() {

        personasArray = new Persona[NUM_PERSONAS];

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

    private static void muestraPersonas(Persona[] arrayPersonas) {

        if(arrayPersonas.length == 1){
            System.out.printf("Los datos de la persona guardada es:\n");
        }else System.out.printf("Datos de las %d personas guardadas\n", arrayPersonas.length);

        for (Persona p : arrayPersonas) {
            System.out.println(p.presentar());
        }
    }

    private static void ejercicio7() {


        for(int i = 0; i < personasArray.length; i++) {
            System.out.printf("%d.Introduce nombre de la persona:", i+1);
            String nombre = sc.nextLine();

            int edad;
            boolean esValido;

            do {
                edad = Entrada.pideEntero("Introduce una edad:");
                esValido = Validador.estaEntre(edad,0,99);
                if(!esValido){
                    System.out.println("Por favor, introduzca un valor correcto\n");
                }
            } while (!esValido);

            personasArray[i] = new Persona(nombre,edad);
        }

        muestraPersonas(personasArray);

    }

    private static int preguntaPersonas() {

        boolean esValido;
        int numPersonas;

        do {
            numPersonas = Entrada.pideEntero("¿Cuántas personas quieres añadir?");
            esValido = Validador.estaEntre(numPersonas,MIN_PERSONAS,MAX_PERSONAS);
            if(!esValido){
                System.out.printf("Por favor, introduce un valor correcto entre %d y %d\n",MIN_PERSONAS,MAX_PERSONAS);
            }
        }while(!esValido);

        return numPersonas;
    }

    private static void ejercicio8() {

        int numPersonas = preguntaPersonas();

        Persona[] personasArray2 = new Persona[numPersonas];

        for(int i = 0; i < personasArray2.length; i++) {
            System.out.println("Introduce nombre de la persona:");
            String nombre = sc.nextLine();

            int edad;
            boolean esValido;

            do {
                edad = Entrada.pideEntero("Introduce una edad:");
                esValido = Validador.estaEntre(edad,0,99);
                if(!esValido){
                    System.out.println("Por favor, introduzca un valor correcto\n");
                }
            } while (!esValido);

            personasArray2[i] = new Persona(nombre,edad);
        }

        muestraPersonas(personasArray2);
    }

    private static void muestraLanzamientos(int lanzamientos) {

        int cara = 0;
        int cruz = 0;
        for(int i = 0; i < lanzamientos; i++){
            Aleatorio.generaAleatorioBooleano();
            if(Aleatorio.generaAleatorioBooleano()){
                cara++;
            }else cruz++;
        }
        System.out.printf("Han salido %d caras y %d cruces", cara,cruz);

    }

    private static void ejercicio11() {

        int numLanzamientos;
        do {
            numLanzamientos = Entrada.pideEntero("¿Cúantas veces quieres lanzar la moneda?");
        }while(!Validador.mayorQueCero(numLanzamientos));

        muestraLanzamientos(numLanzamientos);

    }

    private static void ejercicio13() {

        Meteo meteo = new Meteo(500,10,10);
        System.out.println(meteo);

    }

    public static void main(String[] args) {

        inicializar();

        /*System.out.println("-----Ejercicio 1-4-----");
        ejercicio1();
        System.out.println("-----Ejercicio 5-----");
        ejercicio5();
        System.out.println("-----Ejercicio 7-----");
        ejercicio7();
        System.out.println("-----Ejercicio 8-----");
        ejercicio8();
        System.out.println("-----Ejercicio11-----");
        ejercicio11();*/
        System.out.println("-----Ejercicio13-----");
        ejercicio13();


    }



}
