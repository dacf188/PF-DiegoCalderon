package conexion;

import java.sql.SQLException;

public class mainPrueba {

    public static void main(String[] args) {
        try {
            CreateConnection conn = new CreateConnection();
            conn.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
