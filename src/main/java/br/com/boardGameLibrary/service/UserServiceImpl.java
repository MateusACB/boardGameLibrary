package br.com.boardGameLibrary.service;

import br.com.boardGameLibrary.domain.Adress;
import br.com.boardGameLibrary.domain.BoardGame;
import br.com.boardGameLibrary.domain.Expansion;
import br.com.boardGameLibrary.domain.User;
import br.com.boardGameLibrary.dto.AdressDTO;
import br.com.boardGameLibrary.exceptions.UserNotFoundException;
import br.com.boardGameLibrary.exceptions.UserWithSameCpfException;
import br.com.boardGameLibrary.exceptions.UserWithSameEmailException;
import br.com.boardGameLibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> list() {
        return (List<User>) userRepository.findAll();
    }

    private final RestTemplate restTemplate;

    @Override
    public User save(User user, List<Long> boardgames, List<Long> expansions) {

        if (userRepository.existsByCpf(user.getCpf())) {
            throw new UserWithSameCpfException();
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserWithSameEmailException();
        }

        String url = "https://viacep.com.br/ws/" + user.getAdress().getCep() + "/json/";
        AdressDTO response = restTemplate.getForObject(url, AdressDTO.class);
        Adress adress = new Adress();
        adress.setCep(response.getCep());
        adress.setUf(response.getUf());
        adress.setBairro(response.getBairro());
        adress.setLocalidade(response.getLocalidade());
        adress.setLogradouro(response.getLogradouro());
        adress.setNumero(user.getAdress().getNumero());
        adress.setComplemento(user.getAdress().getComplemento());
        user.setAdress(adress);

        Set<BoardGame> novosBoardGames = new HashSet<>();
        if (boardgames != null) {
            for (Long boardGame : boardgames) {
                BoardGame newBoardGame = BoardGame.builder().id(boardGame).build();
                novosBoardGames.add(newBoardGame);
            }
        }
        user.setBoardGames(novosBoardGames);

        Set<Expansion> newExpansions = new HashSet<>();
        if (expansions != null) {
            for (Long expansion : expansions) {
                Expansion newExpansion = Expansion.builder().id(expansion).build();
                newExpansions.add(newExpansion);
            }
        }
        user.setExpansions(newExpansions);

        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return;
        }
        throw new UserNotFoundException();
    }

    @Override
    public User update(Long id, User user, List<Long> boardGames, List<Long> expansions) {

        user.setId(id);

        if (userRepository.existsById(id)) {

            String url = "https://viacep.com.br/ws/" + user.getAdress().getCep() + "/json/";
            AdressDTO response = restTemplate.getForObject(url, AdressDTO.class);
            Adress adress = new Adress();
            adress.setCep(response.getCep());
            adress.setUf(response.getUf());
            adress.setBairro(response.getBairro());
            adress.setLocalidade(response.getLocalidade());
            adress.setLogradouro(response.getLogradouro());
            adress.setNumero(user.getAdress().getNumero());
            adress.setComplemento(user.getAdress().getComplemento());
            user.setAdress(adress);

            Set<BoardGame> novosBoardGames = new HashSet<>();
            if (boardGames != null) {
                for (Long boardgame : boardGames) {
                    BoardGame boardGame = BoardGame.builder().id(boardgame).build();
                    novosBoardGames.add(boardGame);
                }
            }
            user.setBoardGames(novosBoardGames);

            Set<Expansion> newExpansions = new HashSet<>();
            if (expansions != null) {
                for (Long expansion : expansions) {
                    Expansion newExpansion = Expansion.builder().id(expansion).build();
                    newExpansions.add(newExpansion);
                }
            }
            user.setExpansions(newExpansions);

            return userRepository.save(user);
        }
        throw new UserNotFoundException();


    }
}
