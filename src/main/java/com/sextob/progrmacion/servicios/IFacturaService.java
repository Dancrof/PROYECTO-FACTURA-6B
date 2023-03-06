/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.servicios;

import com.sextob.progrmacion.entidades.Factura;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan
 */
@Service
public interface IFacturaService {
    
    Factura createFactura(Factura factura);
    
    Factura getFactura(int id);
    
    List<Factura> getAllFactura(String filter);
    
    boolean updateFactura(int id, Factura factura);
    
    boolean deleteFactura(int id);
}
