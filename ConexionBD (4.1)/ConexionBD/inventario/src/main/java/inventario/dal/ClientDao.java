package inventario.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import inventario.dal.entities.Clientes;
import inventario.bl.dto.Clientesdto;
import inventario.dal.DBConnection;

public class ClientDao implements EntityDAO<Clientes>{

    private Connection connection;

    public ClientDao() {
        DBConnection db = new DBConnection();
        db.connect();
        this.connection = db.getConnection();
    }

    @Override
    public List<Clientes> getAll() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("name"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                lista.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // o usar logging
        }
        return lista;
    }

    public List<Clientes> getByExample(Clientes cliente){
        List<Clientes> foundClientes = new ArrayList<>();
        try {
            String sql = "SELECT * from cliente WHERE username=? or name=? or lastname=? or age=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getCorreo());
            stmt.setInt(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Clientes found = new Clientes();
                found.setId(rs.getInt(1));
                found.setName(rs.getString(2));
                found.setCorreo(rs.getString(3));
                found.setTelefono(rs.getInt(4));
                found.setDireccion(rs.getString(5));
                foundClientes.add(found);
                //System.out.println(found.toString());
            }
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en la consulta: " + e.getMessage());
            e.printStackTrace();
        }
        return foundClientes;
    }

    @Override
    public Clientes save(Clientes cliente){
        try {
            String sql = "INSERT INTO cliente (name, correo, telefono, direccion) VALUES(?,?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getCorreo());
            stmt.setInt(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                cliente.setId(rs.getInt(1));
                return cliente;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Clientes update(Clientes cliente){
        try {
            String sql = "UPDATE cliente SET name=?, correo=?, telefono=?, direccion=? WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getCorreo());
            stmt.setInt(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setInt(5, cliente.getId());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return cliente;
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
            String sql = "DELETE FROM clientes WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false
    }
    @Override
    public boolean delete(Clientes cliente){
        return delete(cliente.getId());
    }
}