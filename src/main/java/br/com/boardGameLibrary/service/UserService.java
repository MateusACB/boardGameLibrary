package br.com.boardGameLibrary.service;

import br.com.boardGameLibrary.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User save(User user,List<Long> boardGames, List<Long> expansions);
    User findById(Long id);
    void delete(Long id);
    User update(Long id, User user,List<Long> boardGames, List<Long> expansions);
}
