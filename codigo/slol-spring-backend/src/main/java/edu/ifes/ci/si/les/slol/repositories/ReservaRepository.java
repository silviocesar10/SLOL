package edu.ifes.ci.si.les.slol.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import edu.ifes.ci.si.les.slol.model.*;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
		
	@Transactional(readOnly = true)
    //@Query(value = "SELECT * FROM RESERVA WHERE RESERVA.ID_LIVRO = ?1 AND (?2 >= RESERVA.DATA_RETIRADA AND ?2 <= RESERVA.DATA_ENTREGA) OR (?3 >= RESERVA.DATA_RETIRADA AND ?3 <= RESERVA.DATA_ENTREGA)" , nativeQuery = true)
	//@Query(value = "SELECT * FROM reserva" , nativeQuery = true)
	@Query(value = "SELECT * FROM RESERVA rsv WHERE rsv.ID_LIVRO = ?1 AND (?2 >= rsv.DATA_RETIRADA AND ?3 <= rsv.DATA_ENTREGA) OR (?2 >= rsv.DATA_RETIRADA AND ?3 <= rsv.DATA_ENTREGA)" , nativeQuery = true)
    public Collection<Reserva> findByReservaConflict(Integer id, Date retirada, Date entrega);

    //@Transactional(readOnly = true)
    //@Query(value = "select CLIENTE.NOME as nome, count(VALOR) as quantidade from RESERVA inner join CLIENTE on RESERVA.ID_PESSOA = CLIENTE.ID_PESSOA where DATA_RESERVA > '2022-01-01' and DATA_RESERVA < '2022-12-31' group by CLIENTE.NOME", nativeQuery = true)
	//public Collection<?> findQuantidadesReservasOfClientesByPeriodo(String inicio, String termino);
    
    @Transactional(readOnly = true)
    //@Query(value = "SELECT * FROM reserva rsv WHERE rsv.id_pessoa = ?1 AND rsv.data_reserva = ?2 AND rsv.data_reserva = ?3", nativeQuery = true)
    @Query(value = "SELECT * FROM reserva rsv WHERE rsv.id_pessoa = ?1 AND extract(month FROM rsv.data_reserva) = extract(month FROM (SELECT CURRENT_DATE)) AND extract(year FROM rsv.data_reserva) = extract(year FROM (SELECT CURRENT_DATE))", nativeQuery = true)
    public Collection<Reserva> findByClienteAndPeriodoInMonth(Integer idCliente);
}
