package br.com.boardGameLibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String dataDeNascimento;
    private String email;
    private String cpf;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private Adress adress;

    @ManyToMany
    @JoinTable(
            name = "user_board_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "board_games_id")
    )
    @JsonIgnoreProperties({"users","expansions"})
    private Set<BoardGame> boardGames;

    @ManyToMany
    @JoinTable(
            name = "user_expansions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "expansions_id")
    )
    @JsonIgnoreProperties({"users","boardGames", "boardGame"})
    private Set<Expansion> expansions;
}
