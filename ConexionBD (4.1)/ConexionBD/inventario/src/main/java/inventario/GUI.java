package inventario;
import inventario.bl.GestorClientes;
import inventario.dal.entities.Clientes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import inventario.bl.dto.Clientesdto;

public class GUI extends JFrame {
    private GestorClientes gestionClientes;
    private JTextArea textArea;

    public GUI() {
        gestionClientes = new GestorClientes();
        setTitle("Gestión de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton btnLoadClients = new JButton("Cargar Clientes");
        btnLoadClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadClients();
            }
        });
        buttonPanel.add(btnLoadClients);

        JButton btnAddClient = new JButton("Agregar Cliente");
        btnAddClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });
        buttonPanel.add(btnAddClient);

        JButton btnUpdateClient = new JButton("Actualizar Cliente");
        btnUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClient();
            }
        });
        buttonPanel.add(btnUpdateClient);

        JButton btnDeleteClient = new JButton("Eliminar Cliente");
        btnDeleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });
        buttonPanel.add(btnDeleteClient);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }

    private void loadClients() {
        List<Clientesdto> clientes = gestionClientes.getAllClientes();
        textArea.setText("");
        for (Clientesdto cliente : clientes) {
            textArea.append(cliente.toString() + "\n");
        }
    }

    private void addClient() {
        String name = JOptionPane.showInputDialog(this, "Name:");
        String correo = JOptionPane.showInputDialog(this, "Correo:");
        String telefono = JOptionPane.showInputDialog(this, "Telefono:");
        String direccion = JOptionPane.showInputDialog(this, "Direccion:");
        Clientes cliente = new Clientes();
        Clientesdto savedCliente = gestionClientes.agregarCliente(cliente);
        if (savedCliente != null) {
            JOptionPane.showMessageDialog(this, "Cliente agregado: " + savedCliente);
            loadClients();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente.");
        }
    }

    private void updateClient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID del Cliente a actualizar:"));
        String name = JOptionPane.showInputDialog(this, "Nuevo Nombre: ");
        String correo = JOptionPane.showInputDialog(this, "Nuevo Correo: ");
        String telefono = JOptionPane.showInputDialog(this, "Nuevo Telefono: ");
        String direccion = JOptionPane.showInputDialog(this, "Nueva Direccion: ");
        Clientes cliente = new Clientes();
        cliente.setId(id);
        Clientesdto updatedCliente = gestionClientes.agregarCliente(cliente);
        if (updatedCliente != null) {
            JOptionPane.showMessageDialog(this, "Cliente actualizado: " + updatedCliente);
            loadClients();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar cliente.");
        }
    }

    private void deleteClient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID del Cliente a eliminar:"));
        boolean deleted = gestionClientes.eliminarCliente(id);
        if (deleted) {
            JOptionPane.showMessageDialog(this, "Cliente eliminado.");
            loadClients();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar cliente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
