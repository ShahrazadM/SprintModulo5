package DAO;

import Model.Administrativo;
import Model.Cliente;
import Model.Profesional;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioEditarDAOImpl implements IUsuarioEditarDAO {
    private Connection connection;

    public UsuarioEditarDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void editar(Usuario usuario) {
        String sql;
        if (usuario instanceof Cliente) {
            sql = "UPDATE clientes SET nombre=?, fecha_nacimiento=?, rut=?, acceso=?, contrasena=?, run=?, nombres=?, apellidos=?, telefono=?, afp=?, sistema_salud=?, direccion=?, comuna=?, edad=? WHERE id=?";
        } else if (usuario instanceof Administrativo) {
            sql = "UPDATE administrativos SET nombre=?, fecha_nacimiento=?, rut=?, acceso=?, contrasena=?, area=?, experiencia_previa=? WHERE id=?";
        } else if (usuario instanceof Profesional) {
            sql = "UPDATE profesionales SET nombre=?, fecha_nacimiento=?, rut=?, acceso=?, contrasena=?, titulo=?, fecha_ingreso=? WHERE id=?";
        } else {
            throw new IllegalArgumentException("Tipo de usuario no válido");
        }

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getfechaNacimiento());
            pstmt.setInt(3, usuario.getRut());
            pstmt.setString(4, usuario.getAcceso());
            pstmt.setString(5, usuario.getContrasena());

            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                pstmt.setInt(6, cliente.getRun());
                pstmt.setString(7, cliente.getNombres());
                pstmt.setString(8, cliente.getApellidos());
                pstmt.setString(9, cliente.getTelefono());
                pstmt.setString(10, cliente.getAfp());
                pstmt.setInt(11, cliente.getSistemaSalud());
                pstmt.setString(12, cliente.getDireccion());
                pstmt.setString(13, cliente.getComuna());
                pstmt.setInt(14, cliente.getEdad());
                pstmt.setInt(15, cliente.getId());
            } else if (usuario instanceof Administrativo) {
                Administrativo administrativo = (Administrativo) usuario;
                pstmt.setString(6, administrativo.getArea());
                pstmt.setString(7, administrativo.getExperienciaPrevia());
                pstmt.setInt(8, administrativo.getId());
            } else if (usuario instanceof Profesional) {
                Profesional profesional = (Profesional) usuario;
                pstmt.setString(6, profesional.gettitulo());
                pstmt.setString(7, profesional.getfechaIngreso());
                pstmt.setInt(8, profesional.getId());
            }

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

