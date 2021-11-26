
package com.soltec.controllers;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.RangoNumeracion;
import com.soltec.service.RangoNumeracionService;

@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/rango_numeracion")//Se accede a través de esta URL
public class RangoNumeracionController {

	@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private RangoNumeracionService rangoNumeracionService;
	
	//Creando un nuevo rango
	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody RangoNumeracion rangoNumeracion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(rangoNumeracionService.save(rangoNumeracion));
	}
	
	//Listar todos los rangos
	@GetMapping("/")
	public List<RangoNumeracion> leerTodos(){
		List<RangoNumeracion> rango = StreamSupport.stream(rangoNumeracionService.findAll().spliterator(),false).collect(Collectors.toList());
		return rango;
	}
	
	//Listar uno solo 
	@GetMapping("/listar-rangos/{idNumeracion}")
	public ResponseEntity<?> obtenerProducto(@PathVariable(value="idNumeracion") Integer idNumeracion) {
		Optional<RangoNumeracion> rango = rangoNumeracionService.findById(idNumeracion);
		if(!rango.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(rango);
	}
	

	//Eliminar un rango
		@DeleteMapping("/{codigo}")
		public ResponseEntity<?> eliminar(@PathVariable(value="idNumeracion") Integer idNumeracion){
			if(!rangoNumeracionService.findById(idNumeracion).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			rangoNumeracionService.deleteById(idNumeracion);
			return ResponseEntity.ok().build();
		}

	
}