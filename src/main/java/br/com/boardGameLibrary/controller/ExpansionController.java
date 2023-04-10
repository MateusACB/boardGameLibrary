package br.com.boardGameLibrary.controller;

import br.com.boardGameLibrary.domain.BoardGame;
import br.com.boardGameLibrary.domain.Expansion;
import br.com.boardGameLibrary.dto.ExpansionSaveDTO;
import br.com.boardGameLibrary.service.ExpansionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("expansions")
@RestController
public class ExpansionController {

    private final ExpansionService expansionService;

    @GetMapping
    public List<Expansion> list(){
        return expansionService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expansion save(@Valid @RequestBody ExpansionSaveDTO dto) {
        Expansion boardGame = Expansion.builder()
                .nome(dto.getNome())
                .dataLancamento(dto.getDataLancamento())
                .boardGameNumber(dto.getBoardGameNumber())
                .boardGame(BoardGame.builder().id(dto.getBoardGameNumber()).build())
                .build();
        return expansionService.save(boardGame);
    }

    @GetMapping("{id}")
    public Expansion getById(@PathVariable Long id){
        return expansionService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        expansionService.delete(id);
    }

    @PutMapping("{id}")
    public Expansion update(@PathVariable Long id, @Valid @RequestBody ExpansionSaveDTO dto){
        Expansion boardGame = Expansion.builder()
                .nome(dto.getNome())
                .dataLancamento(dto.getDataLancamento())
                .build();
        expansionService.update(id, boardGame);
        return boardGame;
    }

}
