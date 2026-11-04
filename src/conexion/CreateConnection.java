package conexion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {
    static Properties config = new Properties();
    String hostname, port, database, username, password;
    
    public CreateConnection(){
        String path = "C:\\Users\\EstuardoC\\OneDrive\\Documents\\NetBeans Project\\PFDiegoCalderon\\src\\conexion\\db_config.properties";
        try {
            config.load(Files.newInputStream(Paths.get(path)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        loadProperties();
    }
    
    public Connection getConnection() throws SQLException{
            try {
                String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port
                        + "/" + database;
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                System.out.println("Conectado exitosamente");
                return  connection;
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                throw ex;
            }
        }
    public void loadProperties (){
        this.hostname = config.getProperty("hostname");
        this.port = config.getProperty("port");
        this.database = config.getProperty("database");
        this.username = config.getProperty("username");
        this.password = config.getProperty("password");
    }
}
