import java.io.*;
import java.util.*;
public class Pago {
    String nombre, apellido;
    int efectivo=0;
    int precioProducto[];
    double cambio=0;
    Calendar fecha = Calendar.getInstance();
    Cliente clientes = Cliente.getInstancia();

    public  void sistemaApartado(){
        Scanner entrada = new Scanner(System.in);
        int apartado;
        boolean descuento=false;

        System.out.println("¿Desea hacer un sistema de apartado?"+"(1):Si   (2):No");
        apartado=entrada.nextInt();
        if(apartado==1){
            descuento=true;
            System.out.println("Tiene 15 dias para recoger el producto");
            entrada.nextLine();
            System.out.println("Ingrese su nombre: ");
            nombre=entrada.nextLine();
            clientes.setNmobre(nombre);
            System.out.println("Ingrese su apellido: ");
            apellido=entrada.nextLine();
            clientes.setApellido(apellido);
        }
        formaPago(descuento);
        
    }
    public  void formaPago(boolean descuento){
        Scanner entrada = new Scanner(System.in);
        int tipoPago;
        do{
         System.out.println("Eliga el tipo de pago:");
         System.out.println("(1):Tarjeta----(2):Efectivo");
         tipoPago=entrada.nextInt();
        }while(tipoPago==0);

        switch(tipoPago){
            case 1:pagoTarjeta(descuento);
            break;
            case 2:pagoEfectivo(descuento);
            break;
        }
    }

    public  void pagoTarjeta(boolean descuento){
        Scanner entrada = new Scanner(System.in);
        String numeroCuenta;
        String nip;
        int cantidadProducto,acumulador=0;

        System.out.println("---ELIGIO EL PAGO CON TARJETA---");
       do{
           System.out.println("Ingrese la cantidad de productos");
           cantidadProducto=entrada.nextInt();
           precioProducto = new int[cantidadProducto];
           for(int i=0; i < cantidadProducto; i++) {
            System.out.println("Ingrese el precio del producto " +(i+1));
            precioProducto[i]=entrada.nextInt();

            acumulador+=precioProducto[i];
           }
           if(descuento==true){
             acumulador=acumulador/2;
            }
           System.out.println("Total a pagar: "+acumulador);
           clientes.setCantidadProducto(cantidadProducto);
        }while(cantidadProducto==0);

        do{
            System.out.println("Ingrese su numero de cuenta");
            numeroCuenta=entrada.next();
        }while(numeroCuenta.length()!=16);
        
        do{
            System.out.println("Ingrese su nip");
            nip=entrada.next();
        }while(nip.length()!=4);
        
        System.out.println("--SU PAGO FUE REALIZADO CON EXITO!");
        ticket(cantidadProducto,efectivo, acumulador, precioProducto,cambio, nombre, apellido, descuento);
        
    }

    public  void pagoEfectivo(boolean descuento){
        int cantidadProducto,acumulador=0;

        Scanner entrada = new Scanner(System.in);
        System.out.println("---ELIGIO EL PAGO EN EFECTIVO---");
        do{
            System.out.println("Ingrese la cantidad de productos a comprar");
            cantidadProducto=entrada.nextInt();
            precioProducto = new int[cantidadProducto];
            for(int i=0; i <cantidadProducto; i++){
                System.out.println("Ingrese el precio del producto "+(i+1));
                precioProducto[i]=entrada.nextInt();
                acumulador=precioProducto[i] + acumulador;
            }
            if(descuento==true){
                acumulador=acumulador/2;
            }
            System.out.println("Total a pagar: "+acumulador);
            clientes.setCantidadProducto(cantidadProducto);
        }while(cantidadProducto==0);
        System.out.println("Ingrese el dinero en efectivo");
        efectivo=entrada.nextInt();
        if(efectivo > acumulador){
            cambio=(efectivo) - (acumulador);
            System.out.println("Cambio: "+cambio);
            System.out.println("--SU PAGO SE REALIZO CON EXITO!");
            ticket(cantidadProducto,efectivo,acumulador,precioProducto,cambio,nombre,apellido,descuento);
        }
        else if(efectivo == acumulador) {
            cambio = efectivo -acumulador;
            System.out.println("Cambio: "+cambio);
            System.out.println("--SU PAGO SE REALIZO CON EXITO!--");
            ticket(cantidadProducto,efectivo,acumulador,precioProducto,cambio,nombre,apellido,descuento);
        }
        else if(efectivo < acumulador || efectivo < 0){
            System.out.println("No se pudo hacer el cobro");

        }
    }

    public void ticket(int cantidadProducto,int efectivo,int acumulador,int[] precioProducto,double cambio, String nombre,String apellido,boolean descuento){
        
        try {
            PrintWriter escribir = new PrintWriter("Ticket.txt");
            escribir.println("------TIENDA GRENOUILLE------");
            escribir.printf("\t\t%tD\n",fecha);
            if(descuento){
                escribir.println("\tSistema de apartado");
                escribir.println("\tTiene 15 dias para recoger el producto");
                escribir.println("\tNombre :"+ nombre +" "+ apellido);
                escribir.println("\tCantidad de productos: "+cantidadProducto);
                for(int i=0;i<precioProducto.length;i++)
                escribir.println("\tPrecio producto: "+precioProducto[i]);
                escribir.println("\tTotal a pagar: "+acumulador);
                escribir.println("\tEfecctivo: "+efectivo);
                escribir.println("\tCambio: "+cambio);
            }
            else{
                escribir.println("\tCantidad de productos: "+cantidadProducto);
                for(int i=0;i<precioProducto.length;i++)
                escribir.println("\tPrecio producto: "+precioProducto[i]);
                escribir.println("\tTotal a pagar: "+acumulador);
                escribir.println("\tEfecctivo: "+efectivo);
                escribir.println("\tCambio: "+cambio);
            }
            
            escribir.close();
        } catch (Exception err) {
            System.out.println("Erro en el archivo" + err);
        }
    }

}