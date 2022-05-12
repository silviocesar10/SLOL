package src.edu.ifes.ci.si.les.slol.model;

import java.util.Date;

public class Livro {
 
	private Integer idLivro;
	 
	private String tituloLivro;
	 
	private String descricao;
	 
	private Integer numISBN;
	 
	private String autor;
	 
	private Date anoPublicacao;
	 
	private Emprestimo emprestimo;
	 
	private ItemEmprestimo[] itemEmprestimo;
	 
	private CategoriaLivro categoriaLivro;
	 
	private Reserva[] reserva;
	 
}
 
