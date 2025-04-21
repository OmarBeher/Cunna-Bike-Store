package inventario;

import javax.swing.SwingUtilities;
/*import inventario.dal.ClientDao;
import inventario.dal.Clientes;
import inventario.dal.Refracciones;
import inventario.dal.RefraccionDao;*/

public class Main {
    public static void main(String[] args) {
        // Commenting out the existing content
        /*
        ClientDao clientDao = new ClientDao();

        // Test save() method
        Clientes cliente = new Cliente();
        Clientes insertado = clientDao.save(cliente);
        System.out.println("Inserted: " + insertado);

        // Test getAll() method
        System.out.println("All clients:");
        for (Clientes c : clientDao.getAll()) {
            System.out.println(c);
        }

        // Test update() method
        insertado.setName("Luis Updated");
        Clientes actualizado = clientDao.update(insertado);
        System.out.println("Updated: " + actualizado);

        // Test getAll() method again
        System.out.println("All clients after update:");

        for (Cliente c : clientDao.getAll()) {
            System.out.println(c);
        }

        // Test delete() method
        boolean deleted = clientDao.delete(insertado.getId());
        System.out.println("Deleted: " + deleted);

        // Test getAll() method again
        System.out.println("All clients after delete:");
        for (Cliente c : clientDao.getAll()) {
            System.out.println(c);
        }
        */

        // Launching GestionClientesUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });

        /*ClientDao clientDao = new ClientDao();
        clientDao.getAll();
        System.out.println("ANTES DEL NUEVO REGISTRO");
        Clientes cliente = new Clientes();
        clientDao.save(cliente);
        clientDao.getAll();
        clientDao.update(cliente);
        clientDao.getAll();
        System.out.println("REFRACCIONES");
        RefraccionesDao refraccionDao = new RefraccionDao();
        refraccionDao.getAll();
        Refracciones recraccion2 = new Refracciones();
        refraccionDao.save(refraccion2);
        refraccionDao.getAll();*/
    }
}