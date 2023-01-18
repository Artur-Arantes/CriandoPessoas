package br.com.criador.service;

import br.com.criador.domain.dto.EnderecoCreateDto;
import br.com.criador.domain.dto.EnderecoEditaDto;
import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EnderecoService {
  EnderecoOutPutDto cria(EnderecoCreateDto dto);

  EnderecoOutPutDto edita(Long idEndereco, EnderecoEditaDto enderecoDto);

  List<EnderecoOutPutDto> lista();
}
