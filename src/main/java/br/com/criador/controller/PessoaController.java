package br.com.criador.controller;

import br.com.criador.domain.dto.PessoaCreateDto;
import br.com.criador.domain.dto.PessoaEditDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import br.com.criador.service.PessoaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

  private final PessoaService pessoaService;

  @Transactional
  @RequestMapping(method = RequestMethod.POST, value = "/")
  public PessoaOutPutDto cria(@Valid @RequestBody final PessoaCreateDto dto) {
    return pessoaService.cria(dto);
  }

  @Transactional
  @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
  public PessoaOutPutDto edita(@PathVariable final long id,
                               @NonNull @RequestBody PessoaEditDto dto) {
    return pessoaService.edita(id, dto);
  }

  @Transactional
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public PessoaOutPutDto consulta(@PathVariable final long id) {
    return pessoaService.consulta(id);
  }

  @Transactional
  @RequestMapping(method = RequestMethod.GET, value = "/")
  public List<PessoaOutPutDto> list() {
    return pessoaService.lista();
  }
}
