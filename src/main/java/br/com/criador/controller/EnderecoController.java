package br.com.criador.controller;

import br.com.criador.domain.dto.EnderecoDto;
import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import br.com.criador.service.EnderecoService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/endereco", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {
    private final EnderecoService enderecoService;


    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/cria")
    public EnderecoOutPutDto createAddress(@NonNull @RequestBody final EnderecoDto dto){
        return enderecoService.cria(dto);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/lista")
    public List<EnderecoOutPutDto> list(){
        return enderecoService.lista();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value= "/principal")
    public EnderecoOutPutDto setMainAddress(){
        return enderecoService.setPrincipal();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value= "/edita")
    public EnderecoOutPutDto edit(@NonNull @RequestBody final EnderecoDto dto){
        return enderecoService.edita(dto);
    }
}
