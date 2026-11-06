
package controller;

import dao.AsignacionDao;
import java.util.Date;
import model.Asignacion;
import java.util.List;

public class AsignacionController {
    
    private final AsignacionDao dao = new AsignacionDao();
    
    //BUSCAR POR CARNET
    public List<Asignacion> buscarPorCarnet (String noCarnet){
        return dao.buscarPorCarnet(noCarnet);
    }
    //REGRESAR TODOS LOS REGISTROS
    public List<Asignacion> obtenerTodos (){
        return dao.obtenerTodos();
    }
    //AGREGAR ASIGNACIÓN
    public boolean guardarAsignacion (String noCarnet, String idCurso, int calificacion, Date fechaAprobacion){
        Asignacion  asig = new Asignacion(noCarnet, idCurso, calificacion, fechaAprobacion);
        return dao.guardar(asig);
    }
    //ACTUALIZAR ASIGNACIÓN
    public boolean actualizarAsignacion (String noCarnet, String idCurso, int calificacion, Date fechaAprobacion){
        Asignacion asig = new Asignacion(noCarnet, idCurso, calificacion, fechaAprobacion);
        return dao.actualizar(asig);
    }
    //ELIMINAR ASIGNACIÓN
    public boolean eliminarAsignacion (String noCarnet){
        return dao.eliminar(noCarnet);
    }
}
