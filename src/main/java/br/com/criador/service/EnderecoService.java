package br.com.criador.service;

import br.com.criador.domain.dto.EnderecoDto;
import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EnderecoService {
  EnderecoOutPutDto cria(@NonNull EnderecoDto dto);

  EnderecoOutPutDto edita(@NonNull @RequestBody final EnderecoDto enderecoDto);

  List<EnderecoOutPutDto> lista();

  EnderecoOutPutDto setPrincipal();
}
