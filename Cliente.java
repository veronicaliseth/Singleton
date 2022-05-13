public class Cliente {
    private static Cliente miInstancia;
    private String nombre;
    private String apellido;
    private int cantidadProducto;

    private Cliente(){}

    public static Cliente getInstancia(){
        miInstancia = new Cliente();
        return miInstancia;
    }
    
    public Cliente(String nombre, String apellido, int cantidadProducto){
        this.nombre=nombre;
        this.apellido=apellido;
        this.cantidadProducto=cantidadProducto;
    }
    
    public void setNmobre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public String getApellido(){
        return apellido;
    }

    public void setCantidadProducto(int cantidadProducto){
        this.cantidadProducto=cantidadProducto;
    }

    public int getCantidadProducto(){
        return cantidadProducto;
    }
}