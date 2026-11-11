package conexion;

import java.sql.SQLException;
import java.sql.Connection;

public class mainPrueba {

    public static void main(String[] args) {
       System.out.println("Probando conexiones a las 3 máquinas en red...\n");

        try {
            // 1. Probar Estudiantes
            System.out.print("Conectando a Estudiantes... ");
            Connection conEst = CreateConnection.getConnectionEstudiantes();
            if (conEst != null) {
                System.out.println("¡CONEXIÓN EXITOSA!");
            } else {
                System.out.println("FALLÓ LA CONEXIÓN.");
            }
            // 2. Probar Cursos
            /*
            System.out.print("Conectando a Cursos... ");
            Connection conCur = CreateConnection.getConnectionCursos();
            if (conCur != null) {
                System.out.println("CONEXION EXITOSA!");
            } else {
                System.out.println("FALLO LA CONEXIÓN.");
            }
*/

            // 3. Probar Asignaciones
            System.out.print("Conectando a Asignaciones... ");
            Connection conAsig = CreateConnection.getConnectionAsignaciones();
            if (conAsig != null) {
                System.out.println("CONEXION EXITOSA!");
            } else {
                System.out.println("FALLO LA CONEXIÓN.");
            }

            if (conEst != null) conEst.close();
            /*if (conCur != null) {
                conCur.close();
            }*/
            if (conAsig != null) {
                conAsig.close();
            }
        } catch (SQLException e) {
            System.out.println("ERROR DE SQL" + e.getMessage());
        }
    }
    
}
