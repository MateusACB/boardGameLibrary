package br.com.boardGameLibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String dataLancamento;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany(mappedBy = "boardGame")
    @JsonIgnoreProperties({"boardGame","users"})
    private List<Expansion> expansions;

    @ManyToMany(mappedBy = "boardGames")
    @JsonIgnoreProperties({"adress","boardGames","expansions"})
    private Set<User> users;
}
