
package com.soltec.controllers;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soltec.entities.Factura;
import com.soltec.service.FacturaService;

@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/factura")//Se accede a través de esta URL
public class FacturaController {

	@Autowired // estamos inyectando la Interface de FacturaService en el controlador
	private FacturaService facturaService;
	
	//Crear nueva factura
	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody Factura factura) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
	}
	
	//Listar todos las Facturas
	@GetMapping("/")
	public List<Factura> leerTodos(){
		List<Factura> factura = StreamSupport.stream(facturaService.findAll().spliterator(),false).collect(Collectors.toList());
		return factura;
	}
	
	//Listar uno solo 
	@GetMapping("/listar-facturas/{CUFE}")
	public ResponseEntity<?> obtenerProducto(@PathVariable(value="FacturaService") String CUFE) {
		Optional<Factura> factura = facturaService.findById(CUFE);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(factura);
	}
	//Editar una Factura
		@PutMapping("/")
	    public ResponseEntity<?> editar(@RequestBody Factura facturaEditar){
	        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(facturaEditar));
	    }
}