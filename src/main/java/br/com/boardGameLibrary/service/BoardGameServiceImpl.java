package br.com.boardGameLibrary.service;

import br.com.boardGameLibrary.domain.BoardGame;
import br.com.boardGameLibrary.exceptions.BoardGameNotFoundException;
import br.com.boardGameLibrary.exceptions.BoardGameWithSameNameException;
import br.com.boardGameLibrary.repository.BoardGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardGameServiceImpl implements BoardGameService {

    private final BoardGameRepository repository;

    public List<BoardGame> list(){
        return (List<BoardGame>) repository.findAll();
    }

    @Override
    public BoardGame save(BoardGame boardGame) {
        if (repository.existsByNome(boardGame.getNome())){
            throw new BoardGameWithSameNameException();
        }
        return repository.save(boardGame);
    }

    @Override
    public BoardGame findById(Long id) {
            return repository.findById(id).orElseThrow(BoardGameNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return;
        }
        throw new BoardGameNotFoundException();
    }

    @Override
    public BoardGame update(Long id, BoardGame boardGame) {
        boardGame.setId(id);
        if (repository.existsById(id)){
            return repository.save(boardGame);
        }
        throw new BoardGameNotFoundException();
    }
}
