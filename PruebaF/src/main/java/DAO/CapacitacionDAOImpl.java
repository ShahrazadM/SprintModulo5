package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Capacitacion;
import Model.Conexion;

public class CapacitacionDAOImpl implements ICapacitacionDAO {

    private Connection cn = null;

    @Override
    public void create(Capacitacion c) {
        String sql = "INSERT INTO capacitacion(identificador, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            cn = Conexion.getConn();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setInt(1, c.getIdentificador());
            pstmt.setInt(2, c.getRutCliente());
            pstmt.setString(3, c.getDia());
            pstmt.setString(4, c.getHora());
            pstmt.setString(5, c.getLugar());
            pstmt.setString(6, c.getDuracion());
            pstmt.setInt(7, c.getCantidadAsistentes());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Capacitacion> readAll() {
        List<Capacitacion> capacitaciones = new ArrayList<>();
        String sql = "SELECT * FROM capacitacion";
        try {
            cn = Conexion.getConn();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Capacitacion c = new Capacitacion();
                c.setIdentificador(rs.getInt("identificador"));
                c.setRutCliente(rs.getInt("rutCliente"));
                c.setDia(rs.getString("dia"));
                c.setHora(rs.getString("hora"));
                c.setLugar(rs.getString("lugar"));
                c.setDuracion(rs.getString("duracion"));
                c.setCantidadAsistentes(rs.getInt("cantidadAsistentes"));
                capacitaciones.add(c);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return capacitaciones;
    }

    @Override
    public Capacitacion readOne(int id) {
        Capacitacion capacitacion = null;
        String sql = "SELECT * FROM capacitacion WHERE identificador = ?";
        try {
            cn = Conexion.getConn();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                capacitacion = new Capacitacion();
                capacitacion.setIdentificador(rs.getInt("identificador"));
                capacitacion.setRutCliente(rs.getInt("rutCliente"));
                capacitacion.setDia(rs.getString("dia"));
                capacitacion.setHora(rs.getString("hora"));
                capacitacion.setLugar(rs.getString("lugar"));
                capacitacion.setDuracion(rs.getString("duracion"));
                capacitacion.setCantidadAsistentes(rs.getInt("cantidadAsistentes"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return capacitacion;
    }

    @Override
    public void update(Capacitacion c) {
        String sql = "UPDATE capacitacion SET rutCliente = ?, dia = ?, hora = ?, lugar = ?, duracion = ?, cantidadAsistentes = ? WHERE identificador = ?";
        try {
            cn = Conexion.getConn();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setInt(1, c.getRutCliente());
            pstmt.setString(2, c.getDia());
            pstmt.setString(3, c.getHora());
            pstmt.setString(4, c.getLugar());
            pstmt.setString(5, c.getDuracion());
            pstmt.setInt(6, c.getCantidadAsistentes());
            pstmt.setInt(7, c.getIdentificador());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM capacitacion WHERE identificador = ?";
        try {
            cn = Conexion.getConn();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Capacitacion c) {
        delete(c.getIdentificador());
    }

	@Override
	public void updatde(Capacitacion c) {
		// TODO Auto-generated method stub
		
	}
    
}