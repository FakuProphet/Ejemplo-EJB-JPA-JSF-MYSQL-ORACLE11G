/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.pojos.Empleados;
import cl.pojos.Puestos;
import cl.servicios.EmpleadosFacadeLocal;
import cl.servicios.PuestosFacadeLocal;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Prophet
 */
@Named(value = "empleadoBean")
@RequestScoped
public class EmpleadoBean {

    @EJB
    private PuestosFacadeLocal puestosFacade;

    @EJB
    private EmpleadosFacadeLocal empleadosFacade;

    
   
    private String nombre;
    private String apellido;
    private Integer nroDoc;
    private Puestos puesto;
    private String telefono;
    private String direccion;
    
    public EmpleadoBean() {
        
        /*inicializar puesto*/
        puesto = new Puestos();
        
    }
    
    
    public List<Empleados> getListaEmpleados(){
        return empleadosFacade.findAll();
    }

    public String setNuevoEmpleado(){
        Empleados nuevo = new Empleados();
        nuevo.setApellidos(apellido);
        nuevo.setNombres(nombre);
        nuevo.setNrodoc(nroDoc);
        nuevo.setTelefono(telefono);
        nuevo.setDireccion(direccion);
        nuevo.setPuestoid(puestosFacade.find( puesto.getPuestoid()));
        empleadosFacade.create(nuevo);
        return "Empleado";
    }
    
    
    public PuestosFacadeLocal getPuestosFacade() {
        return puestosFacade;
    }

    public void setPuestosFacade(PuestosFacadeLocal puestosFacade) {
        this.puestosFacade = puestosFacade;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

   

    public Integer getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(Integer nroDoc) {
        this.nroDoc = nroDoc;
    }

    public Puestos getPuesto() {
        return puesto;
    }

    public void setPuesto(Puestos puesto) {
        this.puesto = puesto;
    }
    
    
    
    
    
}
