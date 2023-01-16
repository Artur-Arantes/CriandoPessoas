package br.com.criador.service;

import br.com.criador.domain.dto.output.PessoaOutPutDto;

import java.util.List;

public interface PessoaService {
    public PessoaOutPutDto cria();

    public PessoaOutPutDto edita();

    public PessoaOutPutDto  consulta();

    public List<PessoaOutPutDto> lista();
}
