package br.com.boardGameLibrary.repository;

import br.com.boardGameLibrary.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
