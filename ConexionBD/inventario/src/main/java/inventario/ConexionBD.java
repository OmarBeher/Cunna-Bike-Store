package inventario;

import java.sql.*;

public class ConexionBD {

    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/negocio_bicicletas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "tu_contrasena";

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    // Método para agregar una bicicleta
    public static void agregarBicicleta(String modelo, String marca, String tipo, double precio, int cantidad) {
        String query = "INSERT INTO bicicletas (modelo, marca, tipo, precio, cantidad) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, modelo);
            stmt.setString(2, marca);
            stmt.setString(3, tipo);
            stmt.setDouble(4, precio);
            stmt.setInt(5, cantidad);

            stmt.executeUpdate();
            System.out.println("Bicicleta agregada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las bicicletas
    public static void obtenerBicicletas() {
        String query = "SELECT * FROM bicicletas";

        try (Connection conn = getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Modelo: " + rs.getString("modelo") +
                                   ", Marca: " + rs.getString("marca") +
                                   ", Tipo: " + rs.getString("tipo") +
                                   ", Precio: " + rs.getDouble("precio") +
                                   ", Cantidad: " + rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para realizar una venta
    public static void realizarVenta(int idBicicleta, int cantidad) {
        String queryVenta = "INSERT INTO ventas (id_bicicleta, cantidad, fecha) VALUES (?, ?, ?)";
        String queryActualizarInventario = "UPDATE bicicletas SET cantidad = cantidad - ? WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement stmtVenta = conn.prepareStatement(queryVenta); 
             PreparedStatement stmtInventario = conn.prepareStatement(queryActualizarInventario)) {

            conn.setAutoCommit(false);  // Iniciar transacción

            // Insertar la venta
            stmtVenta.setInt(1, idBicicleta);
            stmtVenta.setInt(2, cantidad);
            stmtVenta.setDate(3, Date.valueOf(java.time.LocalDate.now()));  // Fecha de hoy
            stmtVenta.executeUpdate();

            // Actualizar inventario
            stmtInventario.setInt(1, cantidad);
            stmtInventario.setInt(2, idBicicleta);
            stmtInventario.executeUpdate();

            conn.commit();  // Confirmar transacción

            System.out.println("Venta realizada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();  // Rollback en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Ejemplo de agregar una bicicleta
        agregarBicicleta("Bicicleta de montaña", "MarcaX", "Montaña", 200.50, 10);
    
        // Ejemplo de obtener todas las bicicletas
        obtenerBicicletas();
    
        // Ejemplo de realizar una venta
        realizarVenta(1, 2);  // Realizar venta de 2 bicicletas con id 1
    }
}
