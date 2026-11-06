package dao;

import conexion.CreateConnection;
import model.Asignacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsignacionDao {
    //DEVOLVER TODOS LOS REGISTROS
    private final CreateConnection connFactory = new CreateConnection();
    
    public List<Asignacion> obtenerTodos (){
        List<Asignacion> lista = new ArrayList<>();
        //INDICAMOS EL ESQUEMA EN QUE ESTÁ ADEMÁS DE INDICARLE EL NOMBRE ESPECÍFICO
        String squl = "SELECT * FROM public.\"Asignación\"";
        try {Connection conn = connFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(squl);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Asignacion asig = new Asignacion(
                rs.getString("No_Carnet"),
                rs.getString("Id_Curso"),
                rs.getInt("Calificación"),
                rs.getDate("Fecha_Aprobación")
                );
                lista.add(asig);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //FILTRAR POR ID
    public List<Asignacion> buscarPorCarnet (String carnet){
        List<Asignacion> listaAsignaciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM public.\"Asignación\" WHERE \"No_Carnet\" =?";
            Connection conn = connFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, carnet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Asignacion asig = new Asignacion(
                        rs.getString("No_Carnet"),
                        rs.getString("Id_Curso"),
                        rs.getInt("Calificación"),
                        rs.getDate("Fecha_Aprobación")
                );
                listaAsignaciones.add(asig);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(AsignacionDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAsignaciones;
    }
    
    //GUARDAR
    public boolean guardar (Asignacion asig){
        String sql = "INSERT INTO public.\"Asignación\" (\"No_Carnet\", \"Id_Curso\", \"Calificación\", \"Fecha_Aprobación\") VALUES (?, ?, ?, ?)";
        try (Connection conn = connFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, asig.getNoCarnet());
            ps.setString(2, asig.getIdCurso());
            ps.setInt(3, asig.getCalificacion());
            ps.setDate(4, new java.sql.Date(asig.getFechaAprobacion().getTime()));
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //ACTUALIZAR
    public boolean actualizar(Asignacion asig) {
        //CAMBIAR
        String sql = "UPDATE public.\"Asignación\" SET \"Id_Curso\" = ?, \"Calificación\" = ?, \"Fecha_Aprobación\" = ? WHERE \"No_Carnet\" = ?";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, asig.getIdCurso());
            ps.setInt(2, asig.getCalificacion());
            ps.setDate(3, new java.sql.Date(asig.getFechaAprobacion().getTime()));
            ps.setString(4, asig.getNoCarnet());
            
            int filasAfectadas = ps.executeUpdate();
            ps.close();
            conn.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //ELIMINAR
    public boolean eliminar(String noCarnet) {
        String sql = "DELETE FROM public.\"Asignación\" WHERE \"No_Carnet\" = ?";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, noCarnet);
            
            int filasAfectadas = ps.executeUpdate();
            ps.close();
            conn.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
