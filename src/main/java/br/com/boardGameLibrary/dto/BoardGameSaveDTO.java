package br.com.boardGameLibrary.dto;

import br.com.boardGameLibrary.domain.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardGameSaveDTO {
    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @NotBlank(message = "Data é um campo obrigatório")
    private String dataLancamento;

    @NotNull(message = "Gênero é um campo obrigatório")
    private Genero genero;
}
