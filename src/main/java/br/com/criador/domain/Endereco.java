package br.com.criador.domain;

import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Setter
@EqualsAndHashCode(of = "id")
@AttributeOverrides(value= {
        @AttributeOverride(name="id", column = @Column(name="ID_END")),
        @AttributeOverride(name = "version", column = @Column(name = "VER_END")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "CRE_AT_END")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "UPD_AT_END"))
})
public class Endereco extends EntidadeBase{

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Pessoa.class)
    @JsonManagedReference
    @JoinColumn(name= "ID_PES")
    private Pessoa pessoa;

    @Column(name = "LOG_END")
    private String logradouro;

    @Column(name= "CEP_END")
    private int cep;
    @Column(name= "NUM_END")
    private int numero;

    @Column(name = "CID_END")
    private String cidade;
    @Column(name="PRI_END")
    private boolean pricipal;

    public EnderecoOutPutDto toOutPut(){
        return EnderecoOutPutDto.builder()
                .cep(cep)
                .numero(numero)
                .logradouro(logradouro)
                .pessoa(pessoa)
                .principal(pricipal)
                .build();
    }
}
