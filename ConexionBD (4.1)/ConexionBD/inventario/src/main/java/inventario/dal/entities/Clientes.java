package inventario.dal.entities;

public class Clientes {
    private int id;
    private String name;
    private String correo;
    private int telefono;
    private String direccion;

    public Clientes(){
        
    }
    
    public Clientes(int id, String name, String correo, int telefono, String direccion) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    
    public Clientes(String name, String correo, int telefono, String direccion) {
        this.name = name;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "Clientes [id=" + id + ", name=" + name + ", correo=" + correo + ", telefono=" + telefono
                + ", direccion=" + direccion + "]";
    }
}
