package edu.ifes.ci.si.les.slol.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import edu.ifes.ci.si.les.slol.model.Livro;

import edu.ifes.ci.si.les.slol.model.*;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
		
	@Transactional(readOnly = true)
    @Query(value = "select * from RESERVA where RESERVA.CLIENTE_ID = ?1 and RESERVA.DATA > ?2 and RESERVA.DATA < ?3", nativeQuery = true)
    public Collection<Reserva> findByReservaConflict(Date data, Livro lvr);

    @Transactional(readOnly = true)
    @Query(value = "select CLIENTE.NOME as nome, count(RESERVA.ID) as quantidade from RESERVA inner join CLIENTE on RESERVA.CLIENTE_ID = CLIENTE.ID where DATA > ?1 and DATA < ?2 group by RESERVA.CLIENTE_ID", nativeQuery = true)
    public Collection<?> findQuantidadesReservasOfClientesByPeriodo(String inicio, String termino);
}
