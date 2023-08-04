package modelo;

public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
        this.precio = 1.5;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String creaEtiqueta(){

        return String.format("%s: %.2f",getNombre(),getPrecio());
    }


}
