package src.edu.ifes.ci.si.les.slol.model;

import java.util.Date;

public class Reserva {
 
	private Integer idReserva;
	 
	private Date dataReserva;
	 
	private Date dataRetirada;
	 
	/**
	 * the value became 0 if the client has a month plan subscription, and if not the value needs to by paid at loan date
	 * 
	 */
	private Float valor;
	 
	/**
	 * vai guardar a informa��o de quantos dias a pessoa que esta reservando aquele exemplar vai querer ficar com ele e a partir dai o valor � calculado sendo 3,90 para 3 dias
	 * 
	 */
	private Integer periodoEmprestimo;
	 
	private Cliente cliente;
	 
	private Livro livro;
	 
}
 
