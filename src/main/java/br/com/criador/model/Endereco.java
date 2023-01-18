package br.com.criador.model;

import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Setter
@AttributeOverrides(value = {
    @AttributeOverride(name = "id", column = @Column(name = "ID_END")),
    @AttributeOverride(name = "version", column = @Column(name = "VER_END")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "CRE_AT_END")),
    @AttributeOverride(name = "updatedAt", column = @Column(name = "UPD_AT_END"))
})
public class Endereco extends EntidadeBase {

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Pessoa.class)
  @JsonManagedReference
  @JoinColumn(name = "ID_PES")
  private Pessoa pessoa;

  @Column(name = "LOG_END")
  private String logradouro;

  @Column(name = "CEP_END")
  private String cep;
  @Column(name = "NUM_END")
  private int numero;

  @Column(name = "CID_END")
  private String cidade;
  @Column(name = "PRI_END")
  private boolean pricipal;

  public Long getPessoaId() {
    return getPessoa().getId();
  }

  public EnderecoOutPutDto toOutput() {
    return EnderecoOutPutDto.builder()
        .cep(cep)
        .numero(numero)
        .logradouro(logradouro)
        .pessoa(pessoa)
        .principal(pricipal)
        .build();
  }
}
