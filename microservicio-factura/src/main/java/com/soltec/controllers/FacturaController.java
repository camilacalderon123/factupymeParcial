
package com.soltec.controllers;
import java.io.File;
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

import com.soltec.entities.Cliente;
import com.soltec.entities.DetalleFactura;
import com.soltec.entities.Factura;
import com.soltec.entities.Producto;
import com.soltec.service.ClienteService;
import com.soltec.service.DetalleFacturaService;
import com.soltec.service.FacturaService;
import com.soltec.service.ProductoService;
import com.soltec.util.EnviarCorreo;

@RestController // Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/factura")//Se accede a través de esta URL
public class FacturaController {

	@Autowired // estamos inyectando la Interface de FacturaService en el controlador
	private FacturaService facturaService;
	
	@Autowired
	private DetalleFacturaService detalleFacturaService;

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ClienteService clienteService;
	
	//Crear nueva factura
	@PostMapping("/")
	/*
	 * public ResponseEntity<?> crear(@RequestBody Factura factura, @RequestBody
	 * List<Producto> productos) { factura.setCUFE(generarCUFE(factura)); return
	 * ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
	 * }
	 */
	
	public ResponseEntity<?> crear(@RequestBody Factura factura, @RequestBody List<Producto> productos) {
		factura.setCUFE(generarCUFE(factura));
		DetalleFactura df = new DetalleFactura();
		
		for(Producto p:productos) {
			df.setFactura_CUFE(factura.getCUFE());
			productoService.save(p);
			df.setProducto_codigo(p.getCodigo());
			detalleFacturaService.save(df);
		}

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
		return ResponseEntity.ok(factura.get());
	}
	//Editar una Factura
		@PutMapping("/")
	    public ResponseEntity<?> editar(@RequestBody Factura facturaEditar){
	        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(facturaEditar));
	    }
		
	private String generarCUFE(Factura f) {
		String cufe ="";	
		EnviarCorreo ec = new EnviarCorreo();
		File fff= new File(System.getProperty("user.dir")+"/soltec.png");
		File ff = new File(System.getProperty("user.dir")+"/recibo.pdf");
		
		Cliente cl = clienteService.findById(f.getCliente_numero_documento()).get();
		
		cufe+=(""+ f.getRango_numeracion() //NumFactura
		+ f.convertirFecha(f.getFecha_expedicion()) //
		+ f.getEmpresa_NIT() //NIT factura);
		+ cl.getContribuyente()
		+ f.getCliente_numero_documento()
		+ cl.getNumero_documento()
		+ f.getRango_numeracion());
		
		return org.apache.commons.codec.digest.DigestUtils.sha1Hex( cufe );
	}

}