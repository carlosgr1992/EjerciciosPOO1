package modelo;

public class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(int edad) {
        this.edad = edad;
        this.nombre = "Sin nombre";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String presentar(){

        return String.format("Hola, soy %s y tengo %d años",getNombre(),getEdad());

    }
}
