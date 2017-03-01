/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.form;

/**
 *
 * @author ace
 */
public class mComboTipoPersona {
    
    Double idtipo_persona;

    public Double getIdtipo_persona() {
        return idtipo_persona;
    }

    public void setIdtipo_persona(Double idtipo_persona) {
        this.idtipo_persona = idtipo_persona;
    }

    public String getDesc_persona() {
        return desc_persona;
    }

    public void setDesc_persona(String desc_persona) {
        this.desc_persona = desc_persona;
    }
    String desc_persona;

    public mComboTipoPersona(Double idtipo_persona, String desc_persona) {
        this.idtipo_persona = idtipo_persona;
        this.desc_persona = desc_persona;
    }
    
    
    
}
