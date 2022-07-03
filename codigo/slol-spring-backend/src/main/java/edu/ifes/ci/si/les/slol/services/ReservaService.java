package edu.ifes.ci.si.les.slol.services;

import java.util.Collection;
import java.util.NoSuchElementException;
import edu.ifes.ci.si.les.slol.model.Cliente;
import edu.ifes.ci.si.les.slol.model.Livro;
import edu.ifes.ci.si.les.slol.model.Reserva;
import edu.ifes.ci.si.les.slol.repositories.ReservaRepository;
import edu.ifes.ci.si.les.slol.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.slol.services.exceptions.ObjectNotFoundException;
import edu.ifes.ci.si.les.slol.services.exceptions.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;



@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository repository;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private ClienteService clienteService;
	
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
    	Livro livro = livroService.findById(obj.getLivro().getIdLivro());
    	Cliente cliente = clienteService.findById(obj.getCliente().getIdPessoa());
    	
    	obj.setLivro(livro);
    	obj.setCliente(cliente);
    	
    	float tmp = 0.0F;
    	try {
    		if(verificarRegrasDeNegocio1(obj)){
    			if(!obj.getCliente().getTemPlano()){
            		obj.setIdReserva(null);
    	        	if(!verificarRegrasDeNegocio2(obj))
    	        	{
    	        		//aqui eu estaria tratando a segunda regra de negocio pra gerar o desconto
    	        		//de 3,90 a cada 3 dias para 3 reais a cada tres dias
    	        		tmp = calcularValor(obj.getPeriodoEmprestimo(), 3.9F);
    	        		obj.setValor(tmp);
    	        	}else 
    	        	{
    	        		tmp = calcularValor(obj.getPeriodoEmprestimo(), 3.00F);
    	        		obj.setValor(tmp);
    	        	}
    	        	System.out.println("reserva " + obj);
    	        	return repository.save(obj);
            	}else 
            	{
            		obj.setIdReserva(null);
            		obj.setValor(0.0F);
            		return repository.save(obj);
            	}
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
   
    
    //mplementando as regras de negócio relacionadas ao processo de negócio Reserva
 	//Regra de Negócio 1: Cliente não pode ter multas não pagas
 	public boolean verificarRegrasDeNegocio1(Reserva obj) {
 		Collection<Reserva> lst = null;
 			lst = repository.findByReservaConflict(obj.getLivro().getIdLivro(), obj.getDataRetirada(), obj.getDataEntrega());
 			if(!lst.isEmpty())
 			{
 				throw new BusinessRuleException("O periodo de reserva que compreende a data de retirada e a data de entrega esta em conflito, selecione outro periodo");
 				
 			}
 		return true;
 	}
 	

 	public boolean verificarRegrasDeNegocio2(Reserva obj)
 	{
 			//aqui eu faco a conversao das datas para o formato correto para verificar
 			//se o cliente se encaixa no requisito de no minimo de 3 reservas no mes
 			Collection<Reserva> lst = repository.findByClienteAndPeriodoInMonth(obj.getCliente().getIdPessoa());
 			if(!lst.isEmpty() && lst.size() >= 3)
 			{
 				return true;
 			}else
 			{
 				return false;
 			}
 		}
 		
 	
 	public float calcularValor(int periodo, float valor)
 	{
 		float res = 0.0F;
		switch(periodo){
			case 3:
				res = valor;
				break;
			case 6:
				res = 2 * valor;
				break;
			case 9:
				res = 3 * valor;
				break;
			case 12:
				res = 4 * valor;
				break;
			
		}
 		return res;
 	}
}
