package inventario.bl.dto;

public class Clientesdto {
    private int id;
    private String name;
    private String correo;
    private int telefono;
    private String direccion;
    private String nombre;
    private int precio;
    private int cantidad;

    public Clientesdto (){

    }

    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Clientesdto(String name, String correo, int telefono, String direccion, String nombre, int precio,
            int cantidad) {
        this.name = name;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }



    public Clientesdto(int id, String name, String correo, int telefono, String direccion, String nombre, int precio,
            int cantidad) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }
}
