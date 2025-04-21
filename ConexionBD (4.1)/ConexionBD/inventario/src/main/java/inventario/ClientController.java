package inventario;

import inventario.bl.GestorClientes;
import inventario.dal.entities.Clientes;
import java.util.List;

public class ClientController {
    private GestorClientes gestor;

    public ClientController() {
        this.gestor = new GestorClientes();
    }

    public List<Clientes> obtenerClientes() {
        return gestor.obtenerTodosLosClientes();
    }

    public void registrarCliente(String nombre, String correo, int telefono, String direccion) {
        Clientes nuevo = new Clientes(nombre, correo, telefono, direccion);
        gestor.registrarCliente(nuevo);
    }

    // Si necesitas eliminar o buscar clientes por ID:
    public Clientes buscarClientePorId(int id) {
        // podrías agregar esa lógica en GestorClientes y usarla aquí
        return null;
    }

    public void eliminarCliente(int id) {
        // gestor.eliminarCliente(id);
    }
}

