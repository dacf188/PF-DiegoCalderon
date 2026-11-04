package model;

import java.util.Date;

public class Asignacion {
    private String noCarnet;
    private String idCurso;
    private int calificacion;
    private Date fechaAprobacion;

    public Asignacion (){
        
    }
    public Asignacion(String noCarnet, String idCurso, int calificacion, Date fechaAprobacion) {
        this.noCarnet = noCarnet;
        this.idCurso = idCurso;
        this.calificacion = calificacion;
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(String noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }
    
}
