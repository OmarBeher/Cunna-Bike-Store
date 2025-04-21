package inventario.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import inventario.dal.entities.ventas;

public class VentaDao {
    private Connection connection;

    public VentaDao() {
        DbConnection db = new DbConnection();
        db.connect();
        this.connection = db.getConnection();
    }

    public List<Ventas> getAll() {
        List<Ventas> ventas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ventas";
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Ventas venta = new Ventas();
                venta.setId_bicileta(rs.getInt("id_bicicleta"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setCantidad(rs.getInt("cantidad"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venta;
    }

    @Override
    public Cliente save(Cliente cliente){
        try {
            String sql = "INSERT INTO cliente (id, id_bicicleta, cantidad, fecha) VALUES(0,?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getId());
            stmt.setString(2, cliente.getId_bicicleta());
            stmt.setInt(3, cliente.getCantidad());
            stmt.setDate(4, cliente.getFecha());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                cliente.setId(rs.getInt(1));
                return venta;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Cliente update(Ventas venta){
        try {
            String sql = "UPDATE ventas SET id_bicicleta=?, cantidad=?, fecha=? WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cliente.getId());
            stmt.setString(2, cliente.getId_bicicleta());
            stmt.setInt(3, cliente.getCantidad());
            stmt.setDate(4, cliente.getFecha());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return venta;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id){
        try {
            String sql = "DELETE FROM ventas WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Ventas venta){
        return delete(cliente.getId());
    }
}