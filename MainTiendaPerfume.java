import java.util.*;
public class MainTiendaPerfume{

    public static void main(String[] args){
        //creando arreglo de promociones de navidad
        String pNombre[] = {"Kalvin ","Koena ","JoyDior"};
        int    pPrecio[] = {800,800,800};
        String pCodigo[] = {"123443536227","234583636331","434309238042"};
        //creando arreglo kit perfume
        String kNombre[] = {"Channel ","Channel ","GoodGirl", "Jadore  "};
        int    kPrecio[] = {1100,1100,1100,1100};
        String kCodigo[] = {"345453436746","848546356565","454545534235","432432343234"};
        String kContenido[] = {"3 frascos 15ml c/u","kit maquillaje","3 frascos 15ml c/u","3 frascos 15ml c/u"};
        //Scanner entrada = new Scanner(System.in);
        //PerfumeHombre arreglo1[] = new PerfumeHombre[5];
        //PerfumeMujer arreglo2[] = new PerfumeMujer[5];

        //leerArchivo1(arreglo1, entrada);
        //leerArchivo2(arreglo2, entrada);
    
        Menu(pNombre,pPrecio,pCodigo,kNombre,kPrecio,kCodigo,kContenido);
        
    }

    public static void Menu(String[] pNombre, int[] pPrecio, String[] pCodigo, String[] kNombre, int[] kPrecio, String[] kCodigo, String[] kContenido) {
        Scanner entrada= new Scanner(System.in);
        Pago pagos = new Pago();
        int opcion;

        System.out.println("-----BIENVENIDO A LA TIENDA DE PERFUMES GRENOUILLE-----");
        System.out.println("Eliga un catalogo");
        System.out.println("(1):Promocion navidad  (2):Kit de mujeres  ");
        opcion=entrada.nextInt();

        switch(opcion){
            case 1: 
                    System.out.println("-------Promocion Navidad-------");
                    System.out.println("Marca\tPrecio\tCodigo");
                    for(int i=0; i<pNombre.length; i++){
                        System.out.println(pNombre[i]+"\t"+pPrecio[i]+"\t"+pCodigo[i]);
                    }
                   pagos.sistemaApartado();
            break;
            case 2:
                System.out.println("-------Kit Perfume------");
                System.out.println("Marca\tPrecio\tCodigo\t\tContenido");
                for(int i=0; i<kNombre.length; i++){
                    System.out.println(kNombre[i]+" "+kPrecio[i]+" "+kCodigo[i]+" "+kContenido[i]);
                }
                pagos.sistemaApartado();
            break;
            default: System.out.println("Opcion invalida");
        }
    }
}