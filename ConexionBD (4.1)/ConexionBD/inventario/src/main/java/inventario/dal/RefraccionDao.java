package inventario.dal;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import inventario.dal.entities.refracciones;

public class RefraccionDao {
    private Connection connection;

    public RefraccionDao() {
        DbConnection db = new DbConnection();
        db.connect();
        this.connection = db.getConnection();
    }

    public List<refracciones> getAll() {
        List<Refracciones> refracciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM refracciones";
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Refracciones refraccion = new Refracciones();
                refraccion.setNombre(rs.getString("nombre"));
                refraccion.setPrecio(rs.getInt("precio"));
                refraccion.setCantidad(rs.getInt("cantidad"));
                refracciones.add(refraccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return refraction;
    }

    public int save(Refracciones refraccion){
        try {
        // definimos la setencia SQL
        String sql = "INSERT INTO refracciones VALUES(0,?,?,?)";
        //Creacion de la setencia (Statement)
        PreparedStatement stmt = this.connectionD.prepareStatement(sql);
        stmt.setString(1, domicilio.getId());
        stmt.setString(2, domicilio.getNombre);
        stmt.setString(3, domicilio.getPrecio());
        stmt.setString(4, domicilio.getCantidad());
        stmt.execute();

        return -1;
        } catch (SQLException ex){
            System.err.println(ex.getStackTrace());
        }
        return -1;
    }

    /**
     * 
     * @param refraccion
     */
    public void update(Refracciones refraccion){
        try{
            String sql = "UPDATE ventas SET cantidad = ?, nombre = ? WHERE id = ?";
            PreparedStatement stmt = this.connectionD.prepareStatement(sql);
            stmt.setString(1, domicilio.getId());
            stmt.setString(2, domicilio.getNombre);
            stmt.setString(3, domicilio.getPrecio());
            stmt.setString(4, domicilio.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id){
        try {
            String sql = "DELETE FROM refracciones WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, nombre);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean delete(Refracciones refraccion){
        return delete(refraccion.getId());
    }
}