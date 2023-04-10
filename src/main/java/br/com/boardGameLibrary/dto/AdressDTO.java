package br.com.boardGameLibrary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressDTO {

    private String cep;

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

}

