
package com.soltec.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/rango_numeracion")//Se accede a través de esta URL
public class RangoNumeracionController {

	/*@Autowired // estamos inyectando la Interface de ClienteService en el controlador
	private ClienteService clientService;
	
	//Creando un nuevo cliente
	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(cliente));
		
	}
	
	//Listar todos los usuarios
	@GetMapping("/")
	public List<Cliente> leerTodos(){
		List<Cliente> cliente = StreamSupport.stream(clientService.findAll().spliterator(),false).collect(Collectors.toList());
		return cliente;
	}
	
	//Leer 1 usuario por ID
	@GetMapping("/listar-id/{numero_documento}")
	public ResponseEntity<?> leer(@PathVariable(value="numero_documento") Integer id_cliente){
		Optional<Cliente> cliente = clientService.findById(id_cliente);
		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(cliente);
	}
	
	//Editar un usuario
	@PutMapping("/")
	public ResponseEntity<?> editar(@RequestBody Cliente clienteEditar){
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clienteEditar));
	}
	
	//Eliminar un cliente
	@DeleteMapping("/eliminar/{numero_documento}")
	public ResponseEntity<?> eliminar(@PathVariable(value="numero_documento") Integer id_cliente){
		if (!clientService.findById(id_cliente).isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		
		clientService.deleteById(id_cliente);
		return ResponseEntity.ok().build();
	}
	*/

	
}