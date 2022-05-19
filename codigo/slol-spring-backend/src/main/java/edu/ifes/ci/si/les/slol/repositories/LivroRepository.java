package edu.ifes.ci.si.les.slol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifes.ci.si.les.slol.model.*;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
