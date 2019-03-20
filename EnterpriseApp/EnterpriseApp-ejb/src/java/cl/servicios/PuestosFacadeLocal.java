/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.servicios;

import cl.pojos.Puestos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Prophet
 */
@Local
public interface PuestosFacadeLocal {

    void create(Puestos puestos);

    void edit(Puestos puestos);

    void remove(Puestos puestos);

    Puestos find(Object id);

    List<Puestos> findAll();

    List<Puestos> findRange(int[] range);

    int count();
    
}
