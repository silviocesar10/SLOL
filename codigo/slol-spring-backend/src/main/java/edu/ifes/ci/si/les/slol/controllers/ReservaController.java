package edu.ifes.ci.si.les.slol.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

//import edu.ifes.ci.si.les.slol.model.Livro;
import edu.ifes.ci.si.les.slol.model.Reserva;
import edu.ifes.ci.si.les.slol.services.ReservaService;
import edu.ifes.ci.si.les.slol.services.exceptions.ConstraintException;


@RestController
@RequestMapping(value = "/reservas")
public class ReservaController {
	 	@Autowired
	    private ReservaService service;
	 	

	    @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<Collection<Reserva>> findAll() {
	        Collection<Reserva> collection = service.findAll();
	        return ResponseEntity.ok().body(collection);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Reserva> find(@PathVariable Integer id) {
	        Reserva obj = service.findById(id);
	        return ResponseEntity.ok().body(obj);
	    }

	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Reserva> insert(@Valid @RequestBody Reserva obj, BindingResult br) {
	        if (br.hasErrors())
	        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
	        obj = service.insert(obj);
	        return ResponseEntity.ok().body(obj);
	    }
	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Reserva> update(@Valid @RequestBody Reserva obj, BindingResult br) {
	        if (br.hasErrors())
	        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
	        obj = service.update(obj);
	        return ResponseEntity.ok().body(obj);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	@RequestMapping(value = "/findQuantidadesReservasOfClientesByPeriodo/{inicio}/{termino}", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findTotaisAndQuantidadesReservasOfClientesByPeriodo(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date termino) {
        Collection<?> collection = service.findTotaisAndQuantidadesReservasOfClientesByPeriodo(inicio, termino);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/findQuantidadesReservasOfClientes/", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findQuantidadesReservas() {
        Collection<?> collection = service.findQuantidadesReservas();
        return ResponseEntity.ok().body(collection);
    }
}
