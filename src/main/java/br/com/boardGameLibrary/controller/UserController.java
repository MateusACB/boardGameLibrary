package br.com.boardGameLibrary.controller;

import br.com.boardGameLibrary.domain.Adress;
import br.com.boardGameLibrary.domain.User;
import br.com.boardGameLibrary.dto.UserSaveDTO;
import br.com.boardGameLibrary.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> list(){
        return userService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@Valid @RequestBody UserSaveDTO dto) {

        User user = User.builder()
                .nome(dto.getNome())
                .dataDeNascimento(dto.getDataDeNascimento())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .build();

        var adress = new Adress();
        adress.setCep(dto.getCep());
        adress.setComplemento(dto.getComplemento());
        adress.setNumero(dto.getNumero());
        user.setAdress(adress);

        List<Long> boardGames = dto.getBoardGames();
        List<Long> expansions = dto.getExpansions();

        return userService.save(user, boardGames, expansions);
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody UserSaveDTO dto){

        User user = User.builder()
                .nome(dto.getNome())
                .dataDeNascimento(dto.getDataDeNascimento())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .build();

        var adress = new Adress();
        adress.setCep(dto.getCep());
        adress.setComplemento(dto.getComplemento());
        adress.setNumero(dto.getNumero());
        user.setAdress(adress);

        List<Long> boardGames = dto.getBoardGames();
        List<Long> expansions = dto.getExpansions();

        userService.update(id, user, boardGames, expansions);

        return user;
    }

}
