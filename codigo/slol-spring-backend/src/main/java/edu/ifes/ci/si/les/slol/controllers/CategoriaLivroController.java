package edu.ifes.ci.si.les.slol.controllers;

import java.util.Collection;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ifes.ci.si.les.slol.services.CategoriaLivroService;
import edu.ifes.ci.si.les.slol.model.CategoriaLivro;
import edu.ifes.ci.si.les.slol.services.exceptions.*;

@RestController
@RequestMapping(value = "/categoriaslivro")
public class CategoriaLivroController {
	
	@Autowired
	private CategoriaLivroService service;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<CategoriaLivro>> findAll() {
        Collection<CategoriaLivro> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoriaLivro> find(@PathVariable Integer id) {
        CategoriaLivro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
        
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoriaLivro> insert(@Valid @RequestBody CategoriaLivro obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoriaLivro> update(@Valid @RequestBody CategoriaLivro obj, BindingResult br) {
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
}
