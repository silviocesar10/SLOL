package edu.ifes.ci.si.les.slol.model;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idCategoria"})
public class CategoriaLivro implements Serializable	{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	
	@NotBlank(message = "O campo que contem o nome da categoria nao pode ficar em branco!!")
	@Size(min = 2, max = 50,  message = "O campo deve conter entre 2 a 50 caracteres")
	private String nomeCategoria;
	
	@NotBlank(message = "O campo que contem a descricao da categoria nao pode ficar em branco!!")
	@Size(min = 2, max = 50,  message = "O campo deve conter entre 2 a 50 caracteres")
	private String descCategoria;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataCadastro;
	 
}
 
