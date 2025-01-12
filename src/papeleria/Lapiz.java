package papeleria;

public class Lapiz extends Producto {

    private String dureza;

    public Lapiz(String nombre, double precio, String dureza) {

        super(nombre, precio);
        this.dureza = dureza;
    }

    public String getOscuror() {

        return this.dureza;
    }

    public void setOscuror(String negror) {

        this.dureza = negror;
    }

    @Override
    public String toString() {

        return String.format("%sDureza del lapiz: %s%n",super.toString(),this.dureza);
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(!super.equals(obj)) {
            
            return false;
        }
        
        if(!(obj instanceof Lapiz)) {
            
            return false;
        }
        
        Lapiz fantasma = (Lapiz) obj;
        
        return this.dureza.equals(fantasma.dureza);
    }
}
