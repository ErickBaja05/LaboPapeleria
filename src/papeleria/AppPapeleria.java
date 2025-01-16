package papeleria;
import java.util.InputMismatchException;
import java.util.Scanner;

//import java.lang.Throwable;

public class AppPapeleria {
    //extends Throwable{
    private static final String usuarioAdmin = "admin";
    private static final String contraseniaAdmin = "admin";

    private static Vendedor vendedor1 = new Vendedor("0321456987","Pedro", 8, "Vendedor");
    private static Lapiz lapiz1 = new Lapiz("Staendler",0.8,"HB");
    private static Borrador borrador1 = new Borrador("Borrador",0.5,0.25,"De queso");
    private static Cuaderno cuaderno1 = new Cuaderno("Norma", 3.1, 60, "Dos lineas");
    public static String menuPrincipal(){
        StringBuilder menu = new StringBuilder();
        menu.append("******SISTEMA DE GESTION DE PAPELERIA*****\n");
        menu.append("1. INGRESAR COMO CLIENTE\n");
        menu.append("2. INGRESAR COMO ADMIN (SISTEMA DE INVENTARIO)\n");
        menu.append("3. SALIR\n");
        menu.append("ESCOJA UNA OPCION:");
        return menu.toString();
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       boolean enEjecucion = true;
       while(enEjecucion){
           int op = -1;
           while(op <1 || op > 3){
               try{
                   System.out.println(menuPrincipal());
                   op = sc.nextInt();
                   if((op < 1) || (op > 3)){
                       System.out.println("Ingrese una opcion valida.");
                   }
               }catch(InputMismatchException e){
                   System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                   sc.nextLine();
               }
               switch (op){
                   case 1:
                       int opCliente = -1;
                       while(opCliente <1 || opCliente > 2){
                           try{
                               System.out.println(menuCliente());
                               opCliente = sc.nextInt();
                               if((opCliente < 1) || (opCliente > 2)){
                                   System.out.println("Ingrese una opcion valida.");
                               }
                           }catch(InputMismatchException e){
                               System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                               sc.nextLine();
                           }
                       }
                       if(opCliente == 1){
                           comprarProducto();
                       }else{
                           reservarProducto();
                       }
                       break;
                   case 2:
                       boolean admin = validacionAdmin();
                       if(admin){
                           int opProductoVerificacion = -1;
                           System.out.println(menuValidaciones());
                           while(opProductoVerificacion <1 || opProductoVerificacion > 3){
                               try{
                                   System.out.println("QUE PRODUCTO QUIERE COMPARAR?: ");
                                   opProductoVerificacion = sc.nextInt();
                                   if((opProductoVerificacion < 1) || (opProductoVerificacion > 3)){
                                       System.out.println("Ingrese una opcion valida.");
                                   }
                               }catch(InputMismatchException e){
                                   System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                                   sc.nextLine();
                               }
                           }
                       }else{
                           System.out.println("CREDENCIALES INCORRECTAS.");

                       }
                       break;
                   case 3:
                       enEjecucion = false;

               }

           }
        }


    }
    public static boolean validacionAdmin(){
        boolean Aprobado = false;
        Scanner sc = new Scanner(System.in);
        String nombreUsuario;
        String contrasenia;
        System.out.println("Ingrese el nombre de usuario: ");
        nombreUsuario = sc.nextLine();
        System.out.println("Ingrese la contraseña: ");
        contrasenia = sc.nextLine();
        if(nombreUsuario.equals(usuarioAdmin) && contrasenia.equals(contraseniaAdmin)){
            Aprobado = true;
        }
        return Aprobado;
    }

    public static String menuValidaciones(){
        StringBuilder menu = new StringBuilder();
        menu.append("*****VERIFICACION EXISTENCIA DE PRODUCTOS*******\n");
        menu.append("1. VERIFICAR EXISTENCIA DE LAPIZ\n");
        menu.append("2. VERIFICAR EXISTENCIA DE CUADERNO\n");
        menu.append("3. VERIFICAR EXISTENCIA DE BORRADOR\n");
        menu.append("ESCOJA UNA OPCION: \n");
        return menu.toString();
    }

    public static String menuCliente(){
        StringBuilder menu = new StringBuilder();
        menu.append("****OPCIONES DISPONIBLES********\n");
        menu.append("1. COMPRAR UN PRODUCTO \n");
        menu.append("2. RESERVAR UN PRODUCTO\n");
        menu.append("ESCOJA UNA OPCION:");
        return menu.toString();
    }

    public static void comprarProducto(){
        System.out.println("STILL BEING DEVELOPED");
    }

    public static void reservarProducto(){

        Scanner sc = new Scanner(System.in);
        Reserva rsv = new Reserva(vendedor1);
        boolean valid = false;

        int opProductoReserva = -1;
        System.out.println(mostrarProductosDisponibles());
        while(opProductoReserva <1 || opProductoReserva > 3){
            try{

                System.out.println("Que producto desea reservar?: ");
                opProductoReserva = sc.nextInt();
                if((opProductoReserva < 1) || (opProductoReserva > 3)){
                    System.out.println("Ingrese una opcion valida.");
                }
            }catch(InputMismatchException e){
                System.out.println("SOLO SE ADMITEN VALORES NUMERICOS.");
                sc.nextLine();
            }
        }
        switch (opProductoReserva){
            case 1:
                rsv.setProducto(cuaderno1);
                break;
            case 2:
                rsv.setProducto(lapiz1);
                break;
            case 3:
                rsv.setProducto(borrador1);
                break;
        }
        while(!valid){
            try{
                sc.nextLine();
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
            rsv.setPrecioTarifa();
            rsv.setCuotas();
            System.out.println(rsv);
        }
    }

    public static String mostrarProductosDisponibles(){
        StringBuilder productos = new StringBuilder();
        productos.append("LISTA DE PRODUCTOS DISPONIBLES:\n");
        productos.append("1.").append(cuaderno1.toString());
        productos.append("2.").append(lapiz1.toString());
        productos.append("3.").append(borrador1.toString());
        return productos.toString();
    }
}
