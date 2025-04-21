package inventario;

public class Application {
    // Lanza la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear controlador
            ClientController clientController = new ClientController();

            // Pasar el controlador a la GUI (si está diseñada para recibirlo)
            GUI gui = new GUI(clientController);
            gui.setVisible(true);
        });
}
