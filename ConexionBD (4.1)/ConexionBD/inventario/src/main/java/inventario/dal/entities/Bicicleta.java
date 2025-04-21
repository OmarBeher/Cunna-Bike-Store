package inventario.dal.entities;

public class Bicicleta {
    private int id;
    private String modelo;
    private String marca;
    private String tipo;
    private double precio;
    private int cantidad;

    // Constructor vacío
    public Bicicleta() {}

    // Constructor completo
    public Bicicleta(int id, String modelo, String marca, String tipo, double precio, int cantidad) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Bicicleta(String modelo, String marca, String tipo, double precio, int cantidad) {
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getId() {
        return id; 
    }

    public void setId(int id) { 
        this.id = id;
    }

    public String getModelo() { 
        return modelo; 
    }
    
    public void setModelo(String modelo) { 
        this.modelo = modelo; 
    }

    public String getMarca() { 
        return marca; 
    }
    public void setMarca(String marca) { 
        this.marca = marca; 
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public double getPrecio() { 
        return precio; 
    }
    public void setPrecio(double precio) { 
        this.precio = precio; 
    }

    public int getCantidad() { 
        return cantidad; 
     }
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad; 
    }
}
