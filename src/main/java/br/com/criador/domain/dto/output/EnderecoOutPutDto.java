package br.com.criador.domain.dto.output;

import br.com.criador.domain.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EnderecoOutPutDto {
    @JsonProperty("id")
    private long id;

    @JsonProperty("pessoa")
    private Pessoa pessoa;

    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("cep")
    private int cep;

    @JsonProperty("numero")
    private int numero;

}
