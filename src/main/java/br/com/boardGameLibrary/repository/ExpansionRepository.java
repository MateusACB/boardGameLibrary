package br.com.boardGameLibrary.repository;

import br.com.boardGameLibrary.domain.Expansion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpansionRepository extends CrudRepository<Expansion, Long> {
    boolean existsByNome(String nome);
}
