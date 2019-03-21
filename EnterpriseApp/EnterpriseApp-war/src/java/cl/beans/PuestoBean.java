/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.pojos.Puestos;
import cl.servicios.PuestosFacadeLocal;
import com.sun.javafx.geom.CubicApproximator;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Prophet
 */
@Named(value = "puestoBean")
@RequestScoped
public class PuestoBean {

    @EJB
    private PuestosFacadeLocal puestosFacade;

    private BigDecimal id;
    private String descripcion;
    
    
    public PuestoBean() {  
        
    }
    
    
    public List<Puestos> getPuestos(){
        return puestosFacade.findAll();
    }
    
    public String setPuesto(){
        
        Puestos nuevo = new Puestos();
        nuevo.setDescripcion(descripcion);
        nuevo.setPuestoid(id);
        puestosFacade.create(nuevo);
        return "Puesto";
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
   
}
