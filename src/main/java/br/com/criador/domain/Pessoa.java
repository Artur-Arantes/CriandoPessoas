package br.com.criador.domain;

import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@AttributeOverrides(value= {
        @AttributeOverride(name="id", column = @Column(name="id_pes")),
        @AttributeOverride(name = "version", column = @Column(name = "ver_pes")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "cre_pes")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "upd_pes"))
        })
@Generated
@Setter
public class Pessoa extends EntidadeBase{

 @Column(name="nom_pes")
 private String nome;

 @Column(name="dat_nas")
 private String dataNascimento;

@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, targetEntity = Endereco.class)
@JsonManagedReference
@JoinColumn(name= "id_end")
private List<Endereco> endereco;


public PessoaOutPutDto toOutPut(){
  return PessoaOutPutDto.builder()
            .nome(nome)
            .dataNascimento(dataNascimento)
            .enderecos(enderecosToOutPut())
            .build();
}

private List<EnderecoOutPutDto> enderecosToOutPut(){
    List<EnderecoOutPutDto> enderecos = new ArrayList<>();
    endereco.stream().forEach(o->enderecos.add(o.toOutPut()));
    return enderecos;
}

}
