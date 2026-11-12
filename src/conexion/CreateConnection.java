package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {
    private static Properties config = new Properties();
    
    static{
        String recurso = "conexion/db_config.properties";
        try (InputStream input = CreateConnection.class.getClassLoader().getResourceAsStream(recurso)){
            if (input == null) {
                throw  new IllegalStateException("No se encontró" + recurso + " en el classpath");
            } 
            config.load(input);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("No se pudo cargar la configuración " + e.getMessage());
        }
    }
    public static Connection getConnectionEstudiantes() throws SQLException{
        return conectar("estudiantes");
    }
    public static Connection getConnectionCursos() throws SQLException{
        return conectar("cursos");
    }
    public static Connection getConnectionAsignaciones() throws SQLException{
        return conectar("asignaciones");
    }
    private static Connection conectar(String modulo) throws SQLException{
        String hostname = config.getProperty("host." + modulo);
        String port = config.getProperty("port." + modulo);
        String database = config.getProperty("db." + modulo);
        String username = config.getProperty("user." + modulo);
        String password = config.getProperty("pass." + modulo);
        
        try {
            String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conectado exitosamente a: " + database + " (" + hostname + ")");
            return connection;
        } catch (SQLException ex) {
            System.out.println("Error en " + modulo + " (" + hostname + "): " + ex.getMessage());
            throw ex;
        }
    }
}
