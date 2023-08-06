package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
     private final List<LineaPedido> listaLineasDePedido;
    private final LocalDateTime fechaPedido;

    public Pedido(List<LineaPedido> listaLineasDePedido, LocalDateTime fechaPedido) {
        if (listaLineasDePedido == null) {
            this.listaLineasDePedido = new ArrayList<>();
        } else {
            this.listaLineasDePedido = listaLineasDePedido;
        }
        this.fechaPedido = fechaPedido;
    }

    public List<LineaPedido> getListaLineasDePedido() {
        return listaLineasDePedido;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public double sumaTotalFactura(){

        return listaLineasDePedido.stream().mapToDouble(lineaPedido -> lineaPedido.getTotal()).sum();

    }

    public String muestraCabeceraFacturaTotal(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("FACTURA (%s)",fechaPedido.format(FORMATO)));
        sb.append("\n************************************");
        sb.append("\nUds \t Producto \t Subtotal");

        return sb.toString();
    }

    public String muestraLineasTotal(){

        StringBuilder sb = new StringBuilder();

        listaLineasDePedido.forEach(lineaPedido -> sb.append(String.format("\n%d \t %s \t %.2f",lineaPedido.getNumProductos(),lineaPedido.getProducto().getNombre(),lineaPedido.getTotal())));
        sb.append("\n-------------------------------------");
        sb.append(String.format("\n\t\tTOTAL: %.2f",sumaTotalFactura()));

        return sb.toString();
    }
}
