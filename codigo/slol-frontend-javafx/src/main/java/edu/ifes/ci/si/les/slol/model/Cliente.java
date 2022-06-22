package edu.ifes.ci.si.les.slol.model;
import java.util.Date;

import javax.persistence.*;
import lombok.*;


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
	            String bairro, Date nascimento, String telefone, Boolean plano) {
	        super(id, nome,nascimento,bairro, rua, cidade,cpf, telefone);
	        this.temPlano = plano;
	    }

}
 
