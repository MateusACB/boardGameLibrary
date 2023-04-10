package br.com.boardGameLibrary.controller;

import br.com.boardGameLibrary.domain.BoardGame;
import br.com.boardGameLibrary.dto.BoardGameSaveDTO;
import br.com.boardGameLibrary.service.BoardGameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("board-games")
@RestController
public class BoardGameController {

    private final BoardGameService boardGameService;

    @GetMapping
    public List<BoardGame> list(){
        return boardGameService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardGame save(@Valid @RequestBody BoardGameSaveDTO dto) {
        BoardGame boardGame = BoardGame.builder()
                .nome(dto.getNome())
                .dataLancamento(dto.getDataLancamento())
                .genero(dto.getGenero())
                .build();
        return boardGameService.save(boardGame);
    }

    @GetMapping("{id}")
    public BoardGame getById(@PathVariable Long id){
        return boardGameService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        boardGameService.delete(id);
    }

    @PutMapping("{id}")
    public BoardGame update(@PathVariable Long id, @Valid @RequestBody BoardGameSaveDTO dto){
        BoardGame boardGame = BoardGame.builder()
                .nome(dto.getNome())
                .dataLancamento(dto.getDataLancamento())
                .genero(dto.getGenero())
                .build();
        boardGameService.update(id, boardGame);
        return boardGame;
    }
}
