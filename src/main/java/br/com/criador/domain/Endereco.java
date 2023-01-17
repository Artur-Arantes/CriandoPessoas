package br.com.criador.domain;

import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Column(name="id_end")
    @Generated
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Pessoa.class)
    private Pessoa pessoa;

    @Column(name = "log_end")
    private String logradouro;

    @Column(name= "cep_end")
    private int cep;
    @Column(name= "num_end")
    private int numero;

    @Column(name = "cid_end")
    private String cidade;

    public EnderecoOutPutDto toOutPut(){
        return EnderecoOutPutDto.builder()
                .cep(cep)
                .numero(numero)
                .logradouro(logradouro)
                .pessoa(pessoa)
                .build();
    }
}
