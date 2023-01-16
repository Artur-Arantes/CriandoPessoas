package br.com.criador.controller;

import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/endereco", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {


    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/cria")
    public EnderecoOutPutDto createAddress(){
        return EnderecoService.cria();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/lista")
    public PessoaOutPutDto list(){
        return EnderecoService.lista();
    }
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value= "/principal")
    public EnderecoOutPutDto setMainAddress(){
        return EnderecoService.setPrincipal();
    }
}
