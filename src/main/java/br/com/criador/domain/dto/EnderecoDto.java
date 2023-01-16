package br.com.criador.domain.dto;

import br.com.criador.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EnderecoDto {

    private String lodgradouro;

    private Pessoa pessoa;

    private int cep;

    private int numero;
}
