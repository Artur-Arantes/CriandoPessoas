package br.com.criador.service.impl;

import br.com.criador.domain.Endereco;
import br.com.criador.domain.dto.EnderecoDto;
import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import br.com.criador.repositories.EnderecoRepository;
import br.com.criador.service.EnderecoService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {
  private EnderecoRepository enderecoRepository;

  @Override
  public EnderecoOutPutDto cria(@NonNull EnderecoDto dto) {
    final var endereco = Endereco.builder()
        .cep(dto.getCep())
        .cidade(dto.getCidade())
        .logradouro(dto.getLogradouro())
        .numero(dto.getNumero())
        .pessoa(dto.getPessoa())
        .build();
    enderecoRepository.save(endereco);
    return enderecoRepository.findById(endereco.getId()).get().toOutPut();
  }

  @Override
  public EnderecoOutPutDto edita(@NonNull EnderecoDto dto) {
    enderecoRepository.findById(dto.getId());
    return null;
  }

  @Override
  public List<EnderecoOutPutDto> lista() {
    List<EnderecoOutPutDto> retorno = new ArrayList<>();
    Iterable<Endereco> consulta = enderecoRepository.findAll();
    consulta.forEach(o -> retorno.add(o.toOutPut()));
    return retorno;
  }

  @Override
  public EnderecoOutPutDto setPrincipal() {
    return null;
  }
}
