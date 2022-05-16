package edu.ifes.ci.si.les.slol.model;

import java.util.Date;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLivro;
	
	@NotBlank(message = "O campo com o titulo do livro nao pode permanecer em branco!!")
	@Size(min = 2, max = 50, message = "O campo de titulo deve ter no minimo 2 e no maximo 50 caracteres!!")
	private String tituloLivro;
	
	@NotBlank(message = "O campo de descricao do livro nao pode permanecer em branco!!")
	@Size(min = 2, max = 50, message = "O campo de descricao deve ter no minimo 2 e no maximo 50 caracteres!!")
	private String descricao;
	
	@NotBlank(message = "o campo deve conter um registro ISBN referente a obra cadastrada")
	@Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "O numero ISBN deve seguir o padrao ISBN-10 ou ISBN-13!!")
	private Integer numISBN;
	 
	@NotBlank(message = "O campo de nome do autor nao pode permanecer em branco!!")
	@Size(min = 2, max = 50, message = "O campo de nome do autor deve ter no minimo 2 e no maximo 50 caracteres!!")
	private String autor;
	 
	private Date anoPublicacao;
	
	private CategoriaLivro categoriaLivro;
	 
}
 
