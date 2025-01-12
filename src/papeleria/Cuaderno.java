package papeleria;

public class Cuaderno extends Producto {

    private int nroHojas;
    private String linea;

    public Cuaderno(String nombre, double precio, int nroHojas, String linea) {

        super(nombre, precio);
        this.nroHojas = nroHojas;
        this.linea = linea;
    }

    public int getNroHojas() {

        return this.nroHojas;
    }

    public void setNroHojas(int nroHojas) {

        this.nroHojas = nroHojas;
    }

    public String getLinea() {

        return this.linea;
    }

    public void setLinea(String linea) {

        this.linea = linea;
    }

    @Override
    public String toString() {

        return String.format("%sNro de hojas: %d%nTipo de linea: %s%n",super.toString(),this.nroHojas,this.linea);
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(!super.equals(obj)) {
            
            return false;
        }
        
        if(!(obj instanceof Cuaderno)) {
            
            return false;
        }
        
        Cuaderno fantasma = (Cuaderno)obj;
        return this.nroHojas == fantasma.nroHojas;
    }
}
