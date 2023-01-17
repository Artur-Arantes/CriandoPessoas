package br.com.criador.service.impl;

import br.com.criador.domain.Endereco;
import br.com.criador.domain.Pessoa;
import br.com.criador.domain.dto.PessoaDto;
import br.com.criador.domain.dto.output.PessoaOutPutDto;
import br.com.criador.repositories.PessoaRepository;
import br.com.criador.service.PessoaService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
  private PessoaRepository pessoaRepository;

  @Override
  public PessoaOutPutDto cria(@NonNull final PessoaDto pessoaDto) {
    final List<Endereco> enderecos=transformaParaListaEndereco(pessoaDto);

    final var pessoa = Pessoa.builder()
        .nome(pessoaDto.getNome())
        .dataNascimento(pessoaDto.getDataNascimento())
        .endereco(enderecos)
        .build();

    pessoaRepository.save(pessoa);

    Optional<Pessoa> retorno = pessoaRepository.findById(pessoa.getId());

    return retorno.get().toOutPut();
  }

  @Override
  public PessoaOutPutDto edita(@NonNull final PessoaDto pessoaDto) {
    final List<Endereco> enderecos=transformaParaListaEndereco(pessoaDto);

    Optional<Pessoa> pessoaConsulta = pessoaRepository.findById(pessoaDto.getId());

    final var pessoa = pessoaConsulta.get();
    pessoa.setDataNascimento(pessoaDto.getDataNascimento());
    pessoa.setEndereco(enderecos);
    pessoa.setNome(pessoaDto.getNome());

    pessoaRepository.save(pessoa);

    Optional<Pessoa> retorno = pessoaRepository.findById(pessoa.getId());
    return retorno.get().toOutPut();
  }

  @Override
  public PessoaOutPutDto consulta(long id) {
    return pessoaRepository.findById(id).get().toOutPut();
  }

  @Override
  public List<PessoaOutPutDto> lista() {
    List<PessoaOutPutDto> retorno = new ArrayList<>();
    Iterable<Pessoa> consulta = pessoaRepository.findAll();
    consulta.forEach(o -> retorno.add(o.toOutPut()));
    return retorno;
  }

  private static List<Endereco> transformaParaListaEndereco(PessoaDto pessoaDto) {
    List<Endereco> endereco = new ArrayList<>();
    pessoaDto.getEnderecos().stream().forEach(o -> endereco.add(o.toObject()));
    return endereco;
  }
}
