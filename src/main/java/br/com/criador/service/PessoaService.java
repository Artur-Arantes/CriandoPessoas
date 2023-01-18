package br.com.criador.service;

import br.com.criador.domain.dto.PessoaCreateDto;
import br.com.criador.domain.dto.PessoaEditDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PessoaService {
  PessoaOutPutDto cria(final PessoaCreateDto pessoa);

  PessoaOutPutDto edita(final long id, final PessoaEditDto pessoa);

  PessoaOutPutDto consulta(@RequestParam final long id);

  List<PessoaOutPutDto> lista();
}
