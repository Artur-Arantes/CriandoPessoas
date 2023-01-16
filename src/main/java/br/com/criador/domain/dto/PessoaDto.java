package br.com.criador.domain.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class PessoaDto {

    private String nome;

    private String dataNscimento;

    private List<EnderecoDto> enderecos;
}
