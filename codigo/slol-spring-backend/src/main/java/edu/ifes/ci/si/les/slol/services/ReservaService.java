package edu.ifes.ci.si.les.slol.services;

import java.util.Collection;
import java.util.NoSuchElementException;


import edu.ifes.ci.si.les.slol.model.Reserva;
import edu.ifes.ci.si.les.slol.repositories.ReservaRepository;
//import edu.ifes.ci.si.les.slol.model.Cliente;
import edu.ifes.ci.si.les.slol.model.Livro;
import edu.ifes.ci.si.les.slol.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.slol.services.exceptions.ObjectNotFoundException;
import edu.ifes.ci.si.les.slol.services.exceptions.BusinessRuleException;
import edu.ifes.ci.si.les.slol.utils.LocalDateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;



@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository repository;
	
	public Reserva findById(Integer id) {
    	try {
        	Reserva obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Reserva.class.getName());
        }
    }

    public Collection<Reserva> findAll() {
        return repository.findAll();
    }
    
    public Reserva insert(Reserva obj) {
        try {
        	if(verificarRegrasDeNegocio1(obj)) {
	        	obj.setIdReserva(null);
	        	return repository.save(obj);
        	}
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Reserva não foi(foram) preenchido(s): Cliente ou Livro");
        }
        return null;
    }

    public Reserva update(Reserva obj) {
        findById(obj.getIdReserva());
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Reserva não foi(foram) preenchido(s): Cliente ou Livro");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir esta Reserva!");
        }
    }

    public Collection<Reserva> findByClienteAndPeriodo(Integer idCliente, String inicio, String termino) {
        return repository.findByClienteAndPeriodo(idCliente, inicio, termino);
    }

    public Integer findQuantidadesReservasOfClientesByPeriodo(String inicio, String termino){
       return repository.findQuantidadesReservasOfClientesByPeriodo(inicio, termino);
    }
    
    public Collection<Reserva> findByReservaConflict(Livro lvr, String data)
    {
    	return repository.findByReservaConflict(lvr, data);
    }
   
    
    //mplementando as regras de negócio relacionadas ao processo de negócio Reserva
 	//Regra de Negócio 1: Cliente não pode ter multas não pagas
 	public boolean verificarRegrasDeNegocio1(Reserva obj) {
 		LocalDateOperations operator = new LocalDateOperations(); 
 		int periodo =obj.getPeriodoEmprestimo();
 		String data = obj.getDataRetirada().toString();
 		for(int i =periodo; i > 0; i--)
 		{
 			data = operator.addNDay(data, i);
 			Collection<Reserva> lst = findByReservaConflict(obj.getLivro(), data);
 			if(!lst.isEmpty())
 			{
 				throw new BusinessRuleException("O periodo de reserva que compreende a data de retirada e a data de entrega esta em conflito, selecione outro periodo");
 				
 			}
 		}
 		return true;
 	}
 	
 	
}
