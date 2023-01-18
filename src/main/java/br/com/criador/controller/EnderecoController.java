package br.com.criador.controller;

import br.com.criador.domain.dto.EnderecoCreateDto;
import br.com.criador.domain.dto.EnderecoEditaDto;
import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import br.com.criador.service.EnderecoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "api/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class EnderecoController {

  private final EnderecoService enderecoService;


  @RequestMapping(method = RequestMethod.POST, value = "/")
  public EnderecoOutPutDto create(@Valid @NonNull @RequestBody final EnderecoCreateDto dto) {
    return enderecoService.cria(dto);
  }


  @RequestMapping(method = RequestMethod.GET, value = "/")
  public List<EnderecoOutPutDto> list() {
    return enderecoService.lista();
  }


  @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
  public EnderecoOutPutDto edit(
      @NonNull @PathVariable("id") final long id,
      @NonNull @RequestBody final EnderecoEditaDto dto) {
    return enderecoService.edita(id, dto);
  }
}
