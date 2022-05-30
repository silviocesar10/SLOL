package edu.ifes.ci.si.les.slol.services;

import java.util.Collection;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import edu.ifes.ci.si.les.slol.repositories.CategoriaLivroRepository;
import edu.ifes.ci.si.les.slol.model.CategoriaLivro;
import edu.ifes.ci.si.les.slol.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.slol.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaLivroService {

	@Autowired
	private CategoriaLivroRepository repository;

	public CategoriaLivro findById(Integer id) {
		try {
			CategoriaLivro obj = repository.findById(id).get();
			return obj;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaLivro.class.getName());
		}
	}

	public Collection<CategoriaLivro> findAll() {
		return repository.findAll();
	}

	public CategoriaLivro insert(CategoriaLivro obj) {
		obj.setIdCategoria(null);
		try {
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Tipo de Livro não foi(foram) preenchido(s)");
		}
	}

	public CategoriaLivro update(CategoriaLivro obj) {
		findById(obj.getIdCategoria());
		try {
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Tipo de Livro não foi(foram) preenchido(s)");
		}
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Tipo de Livro com Livros vinculados a Empréstimos!");
		}
	}

}
