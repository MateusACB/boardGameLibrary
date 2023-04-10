package br.com.boardGameLibrary.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Setter
@Getter
public class UserSaveDTO {
    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @NotBlank(message = "Data de nascimento é um campo obrigatório")
    private String dataDeNascimento;

    @NotBlank(message = "E-mail é um campo obrigatório")
    @Email
    private String email;

    @NotBlank(message = "CPF é um campo obrigatório")
    @CPF
    private String cpf;

    @NotNull(message = "CEP é um campo obrigatório")
    private String cep;

    @NotNull(message = "Número é um campo obrigatório")
    private String numero;

    @NotNull(message = "Complemento é um campo obrigatório")
    private String complemento;

    private List<Long> boardGames;

    private List<Long> expansions;
}
