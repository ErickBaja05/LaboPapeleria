package papeleria;

public class NotaVenta extends Comprobante {

    private static int contador = 0;
    private Cliente cliente;
    //no hay impuestos


    public NotaVenta(Producto producto, String fecha, Cliente cliente) {


        super(++contador,producto, fecha);
        this.cliente = cliente;
    }
}
