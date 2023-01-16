package br.com.criador.controller;

import br.com.criador.domain.dto.PessoaDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import br.com.criador.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/cria")
    public PessoaOutPutDto create(@NonNull @RequestBody final PessoaDto dto){
        return PessoaService.cria();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT, value="/edita")
    public PessoaOutPutDto edit(){
        return PessoaService.edita();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value= "/consulta")
    public PessoaOutPutDto get(){
        return PessoaService.consulta();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/lista")
    public List<PessoaOutPutDto> getList(){
        return PessoaService.lista();
    }
}
