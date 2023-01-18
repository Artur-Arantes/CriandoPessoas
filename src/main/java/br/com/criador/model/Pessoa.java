package br.com.criador.model;

import br.com.criador.domain.dto.output.PessoaOutPutDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PESSOA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString(callSuper = true)
@AttributeOverrides(value = {
    @AttributeOverride(name = "id", column = @Column(name = "ID_PES")),
    @AttributeOverride(name = "version", column = @Column(name = "VER_PES")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "CRE_AT_PES")),
    @AttributeOverride(name = "updatedAt", column = @Column(name = "UPD_AT_PES"))
})
@Generated
@Setter
public class Pessoa extends EntidadeBase {

  @Column(name = "NOM_PES")
  private String nome;

  @Column(name = "DAT_NAS")
  private LocalDate dataNascimento;

  @OneToMany(fetch = FetchType.LAZY, targetEntity = Endereco.class, mappedBy = "pessoa",
      cascade = CascadeType.ALL)
  @JsonBackReference
  private List<Endereco> enderecos;


  public PessoaOutPutDto toOutput() {
    return PessoaOutPutDto.builder()
        .nome(nome)
        .dataNascimento(dataNascimento)
        .enderecos(enderecos.stream().map(Endereco::toOutput).toList())
        .build();
  }

}
