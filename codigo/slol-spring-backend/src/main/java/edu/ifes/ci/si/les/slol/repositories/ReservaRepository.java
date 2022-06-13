package edu.ifes.ci.si.les.slol.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
//import java.util.Date;
import edu.ifes.ci.si.les.slol.model.Livro;

import edu.ifes.ci.si.les.slol.model.*;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
		
	@Transactional(readOnly = true)
    @Query(value = "SELECT * FROM reserva rsv WHERE  rsv.id_livro = ?1 AND ?2 <= rsv.data_entrega AND ?2 >= rsv.data_retirada;\n" , nativeQuery = true)
    public Collection<Reserva> findByReservaConflict(Livro lvr, String data);

    @Transactional(readOnly = true)
    @Query(value = "select COUTN(*) FROM reservas rsv WHERE rsv.data_reserva = ?1 AND rsv.data_reserva = ?2", nativeQuery = true)
	public Integer findQuantidadesReservasOfClientesByPeriodo(String inicio, String termino);
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM reservas rsv WHERE rsv,id_pessoa = ?1 AND rsv.data_reserva = ?2 AND rsv.data_reserva = ?3", nativeQuery = true)
    public Collection<Reserva> findByClienteAndPeriodo(Integer idCliente, String inicio, String termino);
}
