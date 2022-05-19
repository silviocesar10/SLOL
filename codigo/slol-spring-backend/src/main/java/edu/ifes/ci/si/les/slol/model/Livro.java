package edu.ifes.ci.si.les.slol.model;

import java.util.Date;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idLivro"})
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLivro;
	
	@NotBlank(message = "O campo com o titulo do livro nao pode permanecer em branco!!")
	@Size(min = 2, max = 50, message = "O campo de titulo deve ter no minimo 2 e no maximo 50 caracteres!!")
	private String tituloLivro;
	
	@NotBlank(message = "O campo de descricao do livro nao pode permanecer em branco!!")
	@Size(min = 2, max = 200, message = "O campo de descricao deve ter no minimo 2 e no maximo 200 caracteres!!")
	private String descricao;
	
	@NotBlank(message = "o campo deve conter um registro ISBN referente a obra cadastrada")
	private String numISBN;
	 
	@NotBlank(message = "O campo de nome do autor nao pode permanecer em branco!!")
	@Size(min = 2, max = 50, message = "O campo de nome do autor deve ter no minimo 2 e no maximo 50 caracteres!!")
	private String autor;
	 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date anoPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private CategoriaLivro categoriaLivro;
	 
}
 
