package papeleria;
import java.util.InputMismatchException;
import java.util.Scanner;

//import java.lang.Throwable;

public class AppPapeleria {//extends Throwable{
    
    public static void main(String[] args) {
        
        Cuaderno cd1 = new Cuaderno("Cuaderno",1.50,100,"Una linea");
        Cliente cl1 = new Cliente("1234567890","Juan", "juan@juan","Casa de Juan", "Telefono de Juan");
        Vendedor vn1 = new Vendedor("0321456987","Pedro", 8, "Vendedor");
        
        //Comprobante comp1 = new Comprobante(45,cd1,"hoy");
        //System.out.println(comp1.toString());
        
        /*Factura fact1 = new Factura(cd1,"hoy",cl1,vn1);
        System.out.println(fact1.toString());
        fact1.isAnulacion();
        
        Factura fact2 = new Factura(cd1,"ayer",cl1,vn1);
        System.out.println(fact2.toString());
        fact2.isAnulacion();
        
        try {
            
            fact2.finalize();
        }  catch (Throwable e) {
            throw new RuntimeException(e);
        }
        
        System.out.println(fact2);
        
        NotaVenta nv1 = new NotaVenta(cd1,"hoy",cl1);
        System.out.println(nv1);*/
        
        Cuaderno cuad1 = new Cuaderno("Norma", 1.25, 60, "cuadros");
        Lapiz lp1 = new Lapiz("Bic", 0.75, "HB");
        Lapiz lp2 = new Lapiz("Bic", 0.65, "HB");
        Cuaderno cuad2 = new Cuaderno("Norma", 3.1, 60, "Dos lineas");

        /*
        System.out.println(cuad1.equals(lp1));  //false
        System.out.println(lp1.equals(lp2));    //false
        System.out.println(lp2.equals(lp1));    //false
        System.out.println(cuad1.equals(cuad2));    //true
         */
        Scanner sc = new Scanner(System.in);
        Reserva rsv = new Reserva(vn1);
        boolean valid = false;
        while (!valid) {
            try{
                rsv.setProducto(cuad2);
                System.out.println("Ingrese el plazo en días (1-30) para pagar el producto");
                int fecha = Integer.parseInt(sc.nextLine());
                rsv.setFechaLimite(fecha);
            } catch (NumberFormatException e) {
                System.out.println("El plazo en dias ingresado no es un número valido, intente de nuevo");
                continue;
            } catch (IllegalArgumentException e1) {
                System.out.println("La fecha limite está fuera de lo que permitimos en la tienda, intente de nuevo");
                continue;
            }
            valid = true;
        }
        rsv.setPrecioTarifa();
        rsv.setCuotas();
        System.out.println(rsv.toString());

    }
}
