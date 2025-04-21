package inventario;
import java.util.ArrayList;
import java.util.List;

import inventario.bl.dto.Clientesdto;
import inventario.dal.ClientDao;
import inventario.dal.entities.Clientes;
import inventario.dal.entities.Refracciones;
import inventario.dal.entities.refracciones;
import inventario.dal.entities.ventas;

public class GestorClientes {
    ClientDao clienteDao = new ClientDao();

    public Clientesdto agregarCliente(Clientes cliente) {
        

        Clientes savedClient = clienteDao.save(cliente);

       
        return new Clientesdto();
    }

    public boolean eliminarCliente(int id) {
        return false;
    }

    public Clientesdto agregaRefraccion(Clientes cliente, refracciones refraccion) {
        
        // Se realiza el Mapping a partir de las entities Cliente y Domicilio hacia el Dto para el Cliente en el PL.

        Clientesdto dto = new Clientesdto();
        dto.setName(cliente.getName());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        dto.setId(refraccion.getId());
        dto.setNombre(refraccion.getNombre);
        dto.setCantidad(refraccion.getCantidad());
        dto.setPrecio(refraccion.getPrecio());

        // update en cliente para agregar o asociar el domicilio en la BD a traves de la DAL

        return dto;
    }

    public void eliminarRefraccion(Clientes cliente, refracciones refraccion) {
        // Implementation for deleting an address from a client
    }

    public void autenticacion(String username, String password) {
        // Implementation for accessing a client
    }

    public List<Clientesdto> getAllClients() {
         // Obtener todos los clientes desde la base de datos
        List<Clientes> clientes = clienteDao.getAll();
        
        // Crear una lista para almacenar los ClienteDto
        List<Clientesdto> clienteDtos = new ArrayList<>();
        
        // Mapear cada Cliente a ClienteDto
        for (Clientes cliente : clientes) {
            Clientesdto dto = new Clientesdto();
            dto.setName(cliente.getName());
            dto.setCorreo(cliente.getCorreo());
            dto.setTelefono(cliente.getTelefono());
            // Asumiendo que quieres mostrar la dirección también:
            dto.setNombre("");  // Esto depende de si tienes la relación con el domicilio
            dto.setCantidad(0);
            dto.setPrecio(0);
            
            clienteDtos.add(dto);
        }
        
        return clienteDtos;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
