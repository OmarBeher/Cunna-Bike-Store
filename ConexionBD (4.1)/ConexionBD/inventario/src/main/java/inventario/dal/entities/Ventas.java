package inventario.dal.entities;

import java.sql.Date;

public class ventas {
    int id;
    int id_bicicleta;
    int cantidad;
    Date fecha;

    public ventas(){}

     public int getId() {
          return id;
        }
        public void setId(int id) {
          this.id = id;
        }
        public int getId_bicicleta() {
          return nombre;
        }
        public void setId_bicicleta(String nombre) {
          this.nombre = nombre;
        }
        public Date getFecha() {
          return precio;
        }
        public void setFecha(int precio) {
          this.precio = precio;
        }
        public int getCantidad() {
          return cantidad;
        }
        public void setCantidad(int cantidad) {
          this.cantidad = cantidad;
        }
        public ventas(int id, int id_bicicleta, Date fecha, int cantidad) {
          this.id = id;
          this.id_bicicleta = id_bicicleta;
          this.fecha = fecha;
          this.cantidad = cantidad;
        }
        public ventas(int id_bicicleta, Date fecha, int cantidad) {
          this.nombre = nombre;
          this.precio = precio;
          this.cantidad = cantidad;
        }
}