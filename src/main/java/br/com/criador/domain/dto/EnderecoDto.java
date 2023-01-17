package br.com.criador.domain.dto;

import br.com.criador.domain.Endereco;
import br.com.criador.domain.Pessoa;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class EnderecoDto {
    private long id;
    private String logradouro;

    private Pessoa pessoa;

    private int cep;

    private int numero;

    private String cidade;

    public Endereco toObject(){
        return Endereco.builder()
                .cep(cep)
                .numero(numero)
                .logradouro(logradouro)
                .pessoa(pessoa)
                .build();
    }
}
