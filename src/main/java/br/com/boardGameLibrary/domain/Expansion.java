package br.com.boardGameLibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Expansion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String nome;
    private String dataLancamento;
    private Long boardGameNumber;

    @ManyToOne
    @JsonIgnoreProperties({"expansions","users"})
    private BoardGame boardGame;

    @ManyToMany(mappedBy = "expansions")
    @JsonIgnoreProperties({"adress","boardGames","expansions"})
    private Set<User> users;
}
