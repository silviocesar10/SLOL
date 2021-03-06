package edu.ifes.ci.si.les.slol.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.slol.repositories.ClienteRepository;
import edu.ifes.ci.si.les.slol.model.Cliente;
import edu.ifes.ci.si.les.slol.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.slol.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Integer id)
	{
		Cliente obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
	public Collection<Cliente> findAll()
	{
		return repository.findAll();
	}
	
	public Cliente insert(Cliente obj)
	{
		obj.setIdPessoa(null);
		try
		{
			if(obj.getNome().isEmpty() || obj.getCpf().isEmpty() || obj.getBairro().isEmpty() || obj.getCidade().isEmpty() || obj.getDataNascimento().toString().isEmpty())
			{
				
			}
			return repository.save(obj);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Cliente não foi(foram) preenchido(s): Bairro ou Telefone");
		}
	}
	
	public Cliente update(Cliente obj)
	{
		findById(obj.getIdPessoa());
        try 
        {
        	return repository.save(obj);
        }
        catch (DataIntegrityViolationException e) 
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Cliente não foi(foram) preenchido(s): Bairro ou Telefone");
        }
    }
	public void delete(Integer id) 
	{
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Cliente associado a Reservas");
        }
    }

}
