package br.com.criador.domain.dto;

import br.com.criador.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import static br.com.criador.utils.ConstantsUtils.CEP;
import static java.util.Objects.isNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Setter
public class EnderecoEditaDto {
  @NotEmpty
  private String logradouro;

  @NotEmpty
  @Pattern(regexp = CEP)
  private String cep;
  @Positive
  private Integer numero;
  @NotEmpty
  private String cidade;

  private Boolean principal;

  public Endereco setChanges(@NonNull final Endereco endereco) {
    if (!isNull(logradouro)) {
      endereco.setLogradouro(logradouro);
    }
    if (!isNull(cep)) {
      endereco.setCep(cep);
    }
    if (!isNull(numero)) {
      endereco.setNumero(numero);
    }
    if (!isNull(cidade)) {
      endereco.setCidade(cidade);
    }
    if (!isNull(principal)) {
      endereco.setPricipal(principal);
    }
    return endereco;
  }
}
