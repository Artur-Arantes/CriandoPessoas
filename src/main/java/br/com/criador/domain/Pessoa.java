package br.com.criador.domain;

import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PESSOA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@AttributeOverrides(value= {
        @AttributeOverride(name="id", column = @Column(name="ID_PES")),
        @AttributeOverride(name = "version", column = @Column(name = "VER_PES")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "CRE_AT_PES")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "UPD_AT_PES"))
        })
@Generated
@Setter
public class Pessoa extends EntidadeBase{

 @Column(name="NOM_PES")
 private String nome;

 @Column(name="DAT_NAS")
 private String dataNascimento;

@OneToMany(fetch = FetchType.LAZY, targetEntity = Endereco.class)
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
