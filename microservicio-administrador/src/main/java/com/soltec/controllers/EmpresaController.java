package com.soltec.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.Empresa;
import com.soltec.service.EmpresaService;


@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.GET ,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/empresa")//Se accede a través de esta URL
public class EmpresaController {
	
	
	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private EmpresaService empresaService;
	
	//agregando empresa
	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody Empresa empresa) {	
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa));
	}
	
	//listar empresa
	@GetMapping("/")
	public List<Empresa> leerEmpresa() {
		List<Empresa> cliente = StreamSupport.stream(empresaService.findAll().spliterator(),false).collect(Collectors.toList());
		return cliente;
	}

	//Editar empresa
	@PutMapping("/{NIT}")
	public ResponseEntity<?> editar(@RequestBody Empresa empresaEditar){
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaEditar));
	}
	
	//listar Empresa por NIT
	@GetMapping("/listar-id/{NIT}")
	public ResponseEntity<?> buscarNIT(@PathVariable(value="NIT") Integer NIT){
		Optional<Empresa> empresa= empresaService.findById(NIT);
		if (!empresa.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(empresa);
	}
	

	//Listar todas las empresas
	@GetMapping
	public List<Empresa> leerTodos(){
		List<Empresa> empresa= StreamSupport.stream(empresaService.findAll().spliterator(),false).collect(Collectors.toList());
		return empresa;
	}
	

}
