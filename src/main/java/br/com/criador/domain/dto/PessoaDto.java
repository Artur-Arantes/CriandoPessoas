package br.com.criador.domain.dto;

import br.com.criador.domain.Endereco;
import br.com.criador.domain.Pessoa;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class PessoaDto {
    private long id;
    private String nome;

    private String dataNascimento;

    private List<EnderecoDto> enderecos;

    public Pessoa toOutPut(){
        return Pessoa.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .endereco(enderecosToOutPut())
                .build();
    }

    private List<Endereco> enderecosToOutPut(){
        List<Endereco> endereco = new ArrayList<>();
        enderecos.stream().forEach(o->endereco.add(o.toObject()));
        return endereco;
    }
}
