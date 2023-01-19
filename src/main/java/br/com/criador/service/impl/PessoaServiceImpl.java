package br.com.criador.service.impl;

import br.com.criador.domain.dto.PessoaCreateDto;
import br.com.criador.domain.dto.PessoaEditDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import br.com.criador.exceptions.PessoaNotFoundException;
import br.com.criador.model.Pessoa;
import br.com.criador.repository.PessoaRepository;
import br.com.criador.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {
  @Autowired
  private PessoaRepository pessoaRepository;

  @Override
  public PessoaOutPutDto cria(@NonNull final PessoaCreateDto pessoaDto) {

    return pessoaRepository.save(pessoaDto.toObject()).toOutput();
  }

  @Override
  public PessoaOutPutDto edita(final long id, final PessoaEditDto pessoaDto) {
    return pessoaRepository.findById(id)
        .map(pessoa -> pessoaRepository.save(pessoaDto.setChanges(pessoa)).toOutput())
        .orElseThrow(PessoaNotFoundException::new);
  }

  @Override
  public PessoaOutPutDto consulta(final long id) {

    return pessoaRepository.findById(id)
        .map(Pessoa::toOutput)
        .orElseThrow(PessoaNotFoundException::new);
  }

  @Override
  public List<PessoaOutPutDto> lista() {
    return pessoaRepository.findAll().stream()
        .map(Pessoa::toOutput)
        .toList();
  }
}
