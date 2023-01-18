package br.com.criador.domain.dto;

import br.com.criador.model.Endereco;
import br.com.criador.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import static br.com.criador.utils.ConstantsUtils.CEP;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Setter
public class EnderecoCreateDto {

  @JsonProperty("id_pessoa")
  @Getter
  @NotNull
  @Positive
  private long idPessoa;
  @NotBlank
  private String logradouro;

  @NotBlank
  @Pattern(regexp = CEP)
  private String cep;
  @Positive
  private int numero;
  @NotBlank
  private String cidade;

  private boolean principal;

  public Endereco toObject(@NonNull final Pessoa pessoa) {
    return Endereco.builder()
        .pessoa(pessoa)
        .cep(cep)
        .numero(numero)
        .cidade(cidade)
        .logradouro(logradouro)
        .pricipal(principal)
        .build();
  }
}
