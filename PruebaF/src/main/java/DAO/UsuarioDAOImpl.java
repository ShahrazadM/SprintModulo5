package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.Usuario;


public class UsuarioDAOImpl implements IUsuarioDAO {

    private Connection connection;

    public UsuarioDAOImpl() {
        // Aquí deberías inicializar la conexión a la base de datos
        // Por ejemplo: this.connection = Conexion.getConn();
    }

    @Override
    public void create(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, fecha_nacimiento, rut, acceso, contrasena) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getfechaNacimiento());
            pstmt.setInt(3, usuario.getRut());
            pstmt.setString(4, usuario.getAcceso());
            pstmt.setString(5, usuario.getContrasena());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public Usuario read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

    // Implementa los métodos restantes de UsuarioDAO según tus necesidades

}