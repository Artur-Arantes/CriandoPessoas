package br.com.criador.domain.dto;

import br.com.criador.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

import static java.util.Objects.isNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@Generated
@Setter
public class PessoaEditDto {

  private String nome;

  private LocalDate dataNascimento;

  public Pessoa setChanges(@NonNull final Pessoa pessoa) {
    if (!isNull(nome)) {
      pessoa.setNome(nome);
    }
    if (!isNull(dataNascimento)) {
      pessoa.setDataNascimento(dataNascimento);
    }
    return pessoa;
  }
}
