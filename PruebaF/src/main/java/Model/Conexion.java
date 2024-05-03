package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/empresitariesgo";
    private static final String USER = "root";
    private static final String PASSWORD = "Carcamo2023@";

    // Objeto de conexión
    private static Connection connection;

    // Método para obtener la conexión a la base de datos
    public static Connection obtenerConexion() {
        if (connection == null) {
            try {
            	// Agrega un mensaje de registro para indicar que se está intentando establecer la conexión
                System.out.println("Intentando establecer la conexión a la base de datos...");

                // Cargar el driver de MySQL
                Class.forName("com.mysql.jdbc.Driver");
             // Agrega un mensaje de registro para indicar que la conexión se estableció correctamente
                
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
             // Agrega un mensaje de registro para indicar que la conexión se estableció correctamente
                System.out.println("Conexión establecida correctamente.");
            } catch (ClassNotFoundException | SQLException e) {
            	// Agrega un mensaje de registro para indicar que ocurrió un error al establecer la conexión
                System.err.println("Error al establecer la conexión a la base de datos:");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Método para obtener la conexión a la base de datos (corregido)
    public static Connection getConn() {
        return obtenerConexion();
    }
}