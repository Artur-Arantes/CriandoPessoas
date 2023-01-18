package br.com.criador.service.impl;

import br.com.criador.domain.Pessoa;
import br.com.criador.domain.dto.PessoaDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import br.com.criador.repositories.PessoaRepository;
import br.com.criador.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {
  @Autowired
  private PessoaRepository pessoaRepository;

  @Override
  public PessoaOutPutDto cria(@NonNull final PessoaDto pessoaDto) {

    final var pessoa = Pessoa.builder()
        .nome(pessoaDto.getNome())
        .dataNascimento(pessoaDto.getDataNascimento())
        .build();

    pessoaRepository.save(pessoa);

    Optional<Pessoa> retorno = pessoaRepository.findById(pessoa.getId());

    return retorno.get().toOutPut();
  }

  @Override
  public PessoaOutPutDto edita(@NonNull final PessoaDto pessoaDto) {
    Optional<Pessoa> pessoaConsulta = pessoaRepository.findById(pessoaDto.getId());
    if (pessoaConsulta.stream().findAny().isPresent()){
       Pessoa pessoa = pessoaConsulta.stream().findFirst().get();
      pessoa.setDataNascimento(pessoaDto.getDataNascimento());
      pessoa.setNome(pessoaDto.getNome());

      pessoaRepository.save(pessoa);

      Optional<Pessoa> retorno = pessoaRepository.findById(pessoa.getId());
      return retorno.get().toOutPut();
    }
    throw new  HttpClientErrorException(HttpStatus.NOT_FOUND);
  }

  @Override
  public PessoaOutPutDto consulta(final long id) {

    return pessoaRepository.findById(id).get().toOutPut();
  }

  @Override
  public List<PessoaOutPutDto> lista() {
    List<PessoaOutPutDto> retorno = new ArrayList<>();
    Iterable<Pessoa> consulta = pessoaRepository.findAll();
    consulta.forEach(o -> retorno.add(o.toOutPut()));
    return retorno;
  }
}
