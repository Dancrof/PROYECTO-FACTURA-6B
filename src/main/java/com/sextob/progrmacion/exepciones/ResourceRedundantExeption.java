/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Bryan
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceRedundantExeption extends RuntimeException{

    public ResourceRedundantExeption(String message) {
        super(message);
    }  
}
