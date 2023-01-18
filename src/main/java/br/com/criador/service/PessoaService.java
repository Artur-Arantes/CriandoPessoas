package br.com.criador.service;

import br.com.criador.domain.dto.PessoaDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

public interface PessoaService {
  PessoaOutPutDto cria(@NonNull final PessoaDto pessoa);

  PessoaOutPutDto edita(@NonNull final PessoaDto pessoa);

  PessoaOutPutDto consulta(@RequestParam final long id);

  List<PessoaOutPutDto> lista();
}
