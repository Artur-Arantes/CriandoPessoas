package br.com.criador.service;

import br.com.criador.domain.dto.output.EnderecoOutPutDto;

public interface EnderecoService {
    public EnderecoOutPutDto cria();

    public EnderecoOutPutDto edita();

    public EnderecoOutPutDto lista();

    public EnderecoOutPutDto setPrincipal();
}
