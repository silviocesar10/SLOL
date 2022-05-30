package edu.ifes.ci.si.les.slol.services;

import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.slol.model.Livro;
import edu.ifes.ci.si.les.slol.repositories.LivroRepository;
import edu.ifes.ci.si.les.slol.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.slol.services.exceptions.ObjectNotFoundException;
import edu.ifes.ci.si.les.slol.services.exceptions.BusinessRuleException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id)
	{
		Livro obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Livro.class.getName());
		}
		return obj;
	}
	
	public Collection<Livro> findAll()
	{
		return repository.findAll();
	}
	
	public Livro insert(Livro obj)
	{
		obj.setIdLivro(null);
		try
		{
			if(verificarRegrasDeNegocio(obj))
			{
				return repository.save(obj);	
			}
			
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Livro não foi(foram) preenchido(s)");
		}
		return null;
	}
	
	public Livro update(Livro obj)
	{
		findById(obj.getIdLivro());
        try 
        {
        	return repository.save(obj);
        }
        catch (DataIntegrityViolationException e) 
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Livro não foi(foram) preenchido(s)");
        }
    }
	public void delete(Integer id) 
	{
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Livro associado a Reservas");
        }
    }
	
	public boolean verificarRegrasDeNegocio(Livro obj) {
		if(obj.getDescricao() != null || obj.getCategoriaLivro() != null)
		{
			return true;
		}
		else
		{
			throw new BusinessRuleException("O livro deve possuir uma descricao!!");
		}
 	}
}
