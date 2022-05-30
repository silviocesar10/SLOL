package edu.ifes.ci.si.les.slol.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idPessoa"})
public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	 
	@Column(length = 50)
	@NotNull
	//@Constraint(validatedBy = {NotBlankValidator.class})
	@NotBlank(message = "O nome da pessoa nao pode ficar em braco, deve ser preenchido!!")
	@Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 letras")
	private String nome;
	
	@NotNull(message = "Nascimento do Cliente deve ser preenchido")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	@Column(length = 50)
	@NotNull
    @NotBlank(message = "O bairro deve ser preenchido")
    @Size(min = 2, max = 50, message = "O nome do Bairro deve ter entre 2 e 50 letras") 
	private String bairro;
	
	@Column(length = 50)
	@NotNull
    @NotBlank(message = "A rua deve ser preenchida")
    @Size(min = 2, max = 50, message = "O nome da rua deve ter entre 2 e 50 letras")  
	private String rua;
	
	@Column(length = 50)
	@NotNull
    @NotBlank(message = "O nome da cidade deve ser preenchido")
    @Size(min = 2, max = 50, message = "O nome da cidade deve ter entre 2 e 50 letras")  
	private String cidade;
	
	@Column(length = 50)
	@NotNull
    @NotBlank(message = "CPF da Pessoa deve ser preenchido")
    @Size(min = 2, max = 50, message = "CPF da Pessoa deve ter entre 2 e 50 letras")
    @Pattern(regexp="\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "CPF da Pessoa deve seguir o padrão NNN.NNN.NNN-NN")
	private String cpf;
	
	@NotNull
	@NotBlank(message = "O campo de telefone nao deve estar vazio!!")
	private String telefone;
	 
}
 
