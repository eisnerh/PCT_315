/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class mHorario {

    String horarioId;

    String descripcionHorario;

    public mHorario() {

    }

    public mHorario(String horarioId, String descripcionHorario) {
        this.horarioId = horarioId;
        this.descripcionHorario = descripcionHorario;
    }

    public String getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(String horarioId) {
        this.horarioId = horarioId;
    }

    public String getDescripcionHorario() {
        return descripcionHorario;
    }

    public void setDescripcionHorario(String descripcionHorario) {
        this.descripcionHorario = descripcionHorario;
    }

}
