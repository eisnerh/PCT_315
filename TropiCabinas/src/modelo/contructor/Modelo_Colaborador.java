/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

/**
 *
 * @author Eisner Lopez Acevedo <eisner.lopez at gmail.com>
 */
public class Modelo_Colaborador {
private String empleado_id;
private String fecha_contrato;
private String fecha_despido;
private String observaciones;
private String persona_idpersona;
private String puesto_puesto_id;
private String horario_horario_id;

public Modelo_Colaborador()
{
    
}

    public Modelo_Colaborador(String empleado_id, String fecha_contrato, String fecha_despido, String observaciones, String persona_idpersona, String puesto_puesto_id, String horario_horario_id) {
        this.empleado_id = empleado_id;
        this.fecha_contrato = fecha_contrato;
        this.fecha_despido = fecha_despido;
        this.observaciones = observaciones;
        this.persona_idpersona = persona_idpersona;
        this.puesto_puesto_id = puesto_puesto_id;
        this.horario_horario_id = horario_horario_id;
    }

    public String getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(String empleado_id) {
        this.empleado_id = empleado_id;
    }

    public String getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public String getFecha_despido() {
        return fecha_despido;
    }

    public void setFecha_despido(String fecha_despido) {
        this.fecha_despido = fecha_despido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(String persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

    public String getPuesto_puesto_id() {
        return puesto_puesto_id;
    }

    public void setPuesto_puesto_id(String puesto_puesto_id) {
        this.puesto_puesto_id = puesto_puesto_id;
    }

    public String getHorario_horario_id() {
        return horario_horario_id;
    }

    public void setHorario_horario_id(String horario_horario_id) {
        this.horario_horario_id = horario_horario_id;
    }


}
