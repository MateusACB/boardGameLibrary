package br.com.boardGameLibrary.service;

import br.com.boardGameLibrary.domain.BoardGame;

import java.util.List;

public interface BoardGameService {
    List<BoardGame> list();
    BoardGame save(BoardGame boardGame);
    BoardGame findById(Long id);
    void delete(Long id);
    BoardGame update(Long id, BoardGame boardGame);
}
