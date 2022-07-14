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
	@Query(value = "SELECT * FROM RESERVA rsv WHERE rsv.ID_LIVRO = ?1 AND (?2 >= rsv.DATA_RETIRADA AND ?3 <= rsv.DATA_ENTREGA) OR (?2 >= rsv.DATA_RETIRADA AND ?3 <= rsv.DATA_ENTREGA)" , nativeQuery = true)
    public Collection<Reserva> findByReservaConflict(Integer id, Date retirada, Date entrega);

    @Transactional(readOnly = true)
    @Query(value = "select c.nome as nome, count(r.valor) as quantidade, l.autor, l.titulo_livro from reserva r, livro l, cliente c where r.id_pessoa = c.id_pessoa and r.id_livro = l.id_livro and DATA_RESERVA > ?1 and DATA_RESERVA < ?2 group by c.nome , l.autor, l.titulo_livro;", nativeQuery = true)
	public Collection<?> findQuantidadesReservasOfClientesByPeriodo(Date inicio, Date termino);
    
    @Transactional(readOnly = true)
    @Query(value = "select c.nome as nome, count(r.valor) as quantidade, l.autor, l.titulo_livro from reserva r, livro l, cliente c where r.id_pessoa = c.id_pessoa group by c.nome , l.autor, l.titulo_livro", nativeQuery = true)
	public Collection<?> findQuantidadesReservasOfClientes();
    
    @Transactional(readOnly = true)
    //@Query(value = "SELECT * FROM reserva rsv WHERE rsv.id_pessoa = ?1 AND rsv.data_reserva = ?2 AND rsv.data_reserva = ?3", nativeQuery = true)
    @Query(value = "SELECT * FROM reserva rsv WHERE rsv.id_pessoa = ?1 AND extract(month FROM rsv.data_reserva) = extract(month FROM (SELECT CURRENT_DATE)) AND extract(year FROM rsv.data_reserva) = extract(year FROM (SELECT CURRENT_DATE))", nativeQuery = true)
    public Collection<Reserva> findByClienteAndPeriodoInMonth(Integer idCliente);
}
