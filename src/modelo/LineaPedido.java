package modelo;

public class LineaPedido {

    private Producto producto;
    private int numProductos;

    public LineaPedido(Producto producto, int numProductos) {
        this.producto = producto;
        this.numProductos = numProductos;
    }

    public double getTotal(){

        return producto.getPrecio() * numProductos;

    }

    public Producto getProducto() {
        return producto;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public String muestraLinea(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d \t %s \t %.2f",getNumProductos(),getProducto().getNombre(),getTotal()));
        return sb.toString();
    }
}
