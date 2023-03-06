package com.sextob.progrmacion;

import com.sextob.progrmacion.servicios.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class CardenasApplication implements CommandLineRunner{

    @Autowired
    private IUsuarioService u;
    
    public static void main(String[] args){
        SpringApplication.run(CardenasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //u.createUser(new Usuario("admin", "1234"));
    }
}
