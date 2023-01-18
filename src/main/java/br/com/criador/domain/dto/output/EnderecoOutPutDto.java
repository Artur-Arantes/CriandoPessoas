package br.com.criador.domain.dto.output;

import br.com.criador.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  private String cep;

  @JsonProperty("numero")
  private int numero;

  @JsonProperty("principal")
  private boolean principal;

}
