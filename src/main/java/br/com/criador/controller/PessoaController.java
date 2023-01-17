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

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {
    private final PessoaService pessoaService;

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/cria")
    public PessoaOutPutDto create(@NonNull @RequestBody final PessoaDto dto){
        return pessoaService.cria(dto);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT, value="/edita")
    public PessoaOutPutDto edit(@NonNull @RequestBody PessoaDto dto){
        return pessoaService.edita(dto);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value= "/consulta")
    public PessoaOutPutDto get(@NonNull final long id){
        return pessoaService.consulta(id);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/lista")
    public List<PessoaOutPutDto> getList(){
        return pessoaService.lista();
    }
}
