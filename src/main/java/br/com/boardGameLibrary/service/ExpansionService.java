package br.com.boardGameLibrary.service;

import br.com.boardGameLibrary.domain.Expansion;

import java.util.List;

public interface ExpansionService {
    List<Expansion> list();
    Expansion save(Expansion expansion);
    Expansion findById(Long id);
    void delete(Long id);
    Expansion update(Long id, Expansion expansion);
}
