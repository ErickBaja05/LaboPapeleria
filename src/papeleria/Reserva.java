package papeleria;

public class Reserva extends Comprobante implements IVA, Cargo {

    private static int contador = 0;
    private String fechaLimite;
    private Vendedor vendedor;

    public Reserva(Producto producto, String fecha, String fechaLimite, Vendedor vendedor) {
        super(++contador,producto, fecha);
        this.fechaLimite = fechaLimite;
        this.vendedor = vendedor;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return String.format("%sValor de crédito: %.2f%nVálido hasta: %s%n%s%n",super.toString(),
                (impuestoIVA()-calculoCargo()),this.fechaLimite, this.vendedor.toString());
    }

    @Override
    public double impuestoIVA() {

        return (this.producto.getPrecio() * (1+IVA));
    }

    @Override
    public double calculoCargo() {

        return producto.getPrecio()*Cargo.cargo;
    }
}
