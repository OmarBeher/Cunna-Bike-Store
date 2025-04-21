package inventario.dal;

import inventario.dal.entities.Bicicleta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BicicletaDao {

    public List<Bicicleta> getAll() {
        List<Bicicleta> lista = new ArrayList<>();
        String query = "SELECT * FROM bicicletas";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Bicicleta b = new Bicicleta();
                b.setId(rs.getInt("id"));
                b.setModelo(rs.getString("modelo"));
                b.setMarca(rs.getString("marca"));
                b.setTipo(rs.getInt("tipo"));
                b.setPrecio(rs.getDouble("precio"));
                b.setCantidad(rs.getInt("cantidad"));
                lista.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void insertar(Bicicleta b) {
        String query = "INSERT INTO bicicletas (modelo, marca, tipo, precio, cantidad) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, b.getModelo());
            stmt.setString(2, b.getMarca());
            stmt.setString(3, b.getTipo());
            stmt.setDouble(4, b.getPrecio());
            stmt.setInt(5, b.getCantidad());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Puedes agregar métodos update() y delete() si los necesitas
    @Override
    public Bicicleta update(Bicicleta bicicletas){
        try {
            String sql = "UPDATE bicicleta SET marca=?, modelo=?, tipo=? WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, b.getModelo());
            stmt.setString(2, b.getMarca());
            stmt.setString(3, b.getTipo());
            stmt.setDouble(4, b.getPrecio());
            stmt.setInt(5, b.getCantidad());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return bicicletas;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
