package com.soltec.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/administrador")//Se accede a través de esta URL
public class AdministradorController {
	@RequestMapping("/")
    public String index() {
       
        return "index";
    }
	
	@PostMapping({"/validacion"})
	public String validacion() {
		System.out.println("bien");
		return "prueba";
	}
	
}
