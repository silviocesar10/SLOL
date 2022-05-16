package edu.ifes.ci.si.les.slol.model;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private Boolean temPlano;
	 
	  @Builder
	    public Cliente(Integer id, String nome, String cpf, String rua, String cidade,
	            String bairro, Date nascimento, String telefone) {
	        super(id, nome,nascimento,bairro, cpf, rua, cidade,cpf, telefone);
	    }

}
 
