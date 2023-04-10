package br.com.boardGameLibrary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExpansionSaveDTO {
    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @NotBlank(message = "Data é um campo obrigatório")
    private String dataLancamento;

    @NotNull
    private Long boardGameNumber;
}
