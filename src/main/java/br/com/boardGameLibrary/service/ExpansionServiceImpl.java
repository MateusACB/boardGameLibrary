package br.com.boardGameLibrary.service;

import br.com.boardGameLibrary.domain.Expansion;
import br.com.boardGameLibrary.exceptions.ExpansionNotFoundException;
import br.com.boardGameLibrary.exceptions.ExpansionWithSameNameException;
import br.com.boardGameLibrary.repository.ExpansionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpansionServiceImpl implements ExpansionService {

    private final ExpansionRepository repository;

    public List<Expansion> list(){
        return (List<Expansion>) repository.findAll();
    }

    @Override
    public Expansion save(Expansion expansion) {
        if (repository.existsByNome(expansion.getNome())){
            throw new ExpansionWithSameNameException();
        }
        return repository.save(expansion);
    }

    @Override
    public Expansion findById(Long id) {
            return repository.findById(id).orElseThrow(ExpansionNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return;
        }
        throw new ExpansionNotFoundException();
    }

    @Override
    public Expansion update(Long id, Expansion boardGame) {
        boardGame.setId(id);
        if (repository.existsById(id)){
            return repository.save(boardGame);
        }
        throw new ExpansionNotFoundException();
    }
}
