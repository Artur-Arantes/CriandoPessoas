package br.com.criador.domain.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class PessoaOutPutDto {
    @JsonProperty("id")
    private long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("data_nascimento")
    private String dataNascimento;

    @JsonProperty("enderecos")
    private List<EnderecoOutPutDto> enderecos;
}
