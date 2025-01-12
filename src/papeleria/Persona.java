package papeleria;

public abstract class Persona {

    protected String cedula;
    protected String nombre;



    public Persona(String cedula, String nombre) {

        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {

        return this.cedula;
    }

    public void setCedula(String cedula) {

        this.cedula = cedula;
    }

    public String getNombre() {

        return this.nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public String toString() {

        return String.format("Nombre: %s%nCedula: %s%n", this.nombre,this.cedula);
    }
}
