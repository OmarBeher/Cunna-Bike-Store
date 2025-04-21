package inventario.dal.entities;

public class refracciones {
        int id;
        String nombre;
        int precio;
        int cantidad;

        public refracciones(){
          
        }

        public int getId() {
          return id;
        }
        public void setId(int id) {
          this.id = id;
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
        public refracciones(int id, String nombre, int precio, int cantidad) {
          this.id = id;
          this.nombre = nombre;
          this.precio = precio;
          this.cantidad = cantidad;
        }
        public refracciones(String nombre, int precio, int cantidad) {
          this.nombre = nombre;
          this.precio = precio;
          this.cantidad = cantidad;
        }
    }
