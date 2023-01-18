package br.com.criador.domain.dto;

import br.com.criador.interfaces.IsPrincipalValidation;
import br.com.criador.model.Endereco;
import br.com.criador.model.Pessoa;
import br.com.criador.utils.EnderecosConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.criador.utils.ConstantsUtils.CEP;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@Generated
@Setter
public class PessoaCreateDto {

  @NotEmpty
  private String nome;

  @Past(message = "A data deve ser anterior a hoje")
  private LocalDate dataNascimento;

  @NotEmpty
  @EnderecosConstraint
  @Valid
  private List<EnderecoDto> enderecos = new ArrayList<>();

  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode()
  @Generated
  @Setter
  static class EnderecoDto implements IsPrincipalValidation {
    @NotEmpty
    private String logradouro;

    @NotEmpty
    @Pattern(regexp = CEP)
    private String cep;

    private int numero;

    private String cidade;

    @Getter
    private boolean principal;

  }

  public Pessoa toObject() {
    final var pessoa = Pessoa.builder()
        .nome(nome)
        .dataNascimento(dataNascimento)
        .build();

    pessoa.setEnderecos(enderecos.stream().map(end -> Endereco.builder()
        .cep(end.cep)
        .pessoa(pessoa)
        .pricipal(end.principal)
        .numero(end.numero)
        .logradouro(end.logradouro)
        .cidade(end.cidade)
        .build()).toList());

    return pessoa;
  }
}
