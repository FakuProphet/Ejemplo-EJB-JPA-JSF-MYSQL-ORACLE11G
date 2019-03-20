/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.servicios;

import cl.pojos.Puestos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prophet
 */
@Stateless
public class PuestosFacade extends AbstractFacade<Puestos> implements PuestosFacadeLocal {

    @PersistenceContext(unitName = "EnterpriseApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuestosFacade() {
        super(Puestos.class);
    }
    
}
