package br.com.boardGameLibrary.repository;

import br.com.boardGameLibrary.domain.BoardGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGameRepository extends CrudRepository<BoardGame, Long> {
    boolean existsByNome(String nome);
}
