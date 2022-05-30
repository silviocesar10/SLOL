package edu.ifes.ci.si.les.slol.services;

//import java.util.Collection;
//import java.util.NoSuchElementException;

//import edu.ifes.ci.si.les.slol.model.Reserva;
//import edu.ifes.ci.si.les.slol.repositories.ReservaRepository;
//import edu.ifes.ci.si.les.slol.model.Cliente;
//import edu.ifes.ci.si.les.slol.repositories.ClienteRepository;
//import edu.ifes.ci.si.les.slol.services.exceptions.DataIntegrityException;
//import edu.ifes.ci.si.les.slol.services.exceptions.ObjectNotFoundException;
//import edu.ifes.ci.si.les.slol.services.exceptions.BusinessRuleException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;

//@Service
public class ReservaService {
	/*
	 * @Autowired
	private ReservaRepository repository;
	
	@Autowired
	//private ClienteRepository clienteRepository;
	
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
    
    //public Reserva findByLivroAndStatus(Integer idLivro, Integer status) {
      //  return repository.findByLivroAndStatus(idLivro, status);
    //}

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

    //public Collection<Reserva> findByClienteAndPeriodo(Integer idCliente, String inicio, String termino) {
      //  return repository.findByClienteAndPeriodo(idCliente, inicio, termino);
    //}

    //public Collection<?> findQuantidadesReservasOfClientesByPeriodo(String inicio, String termino){
      //  return repository.findQuantidadesReservasOfClientesByPeriodo(inicio, termino);
    //}
    
    // Implementando as regras de negócio relacionadas ao processo de negócio Reserva
 	// Regra de Negócio 1: Cliente não pode ter multas não pagas
 	public boolean verificarRegrasDeNegocio1(Reserva obj) {
 		//Collection<Reserva> tmp = repository.findAll();
 		//var datatmp = obj.getDataRetirada();
 		//for(Reserva item : tmp)
 		//{
 			//if (item.getDataReserva() == datatmp)
 			//{
 				//return false;
 			//}
 		//}
 		return true;
 	}*/
}
