package br.com.criador.service.impl;

import br.com.criador.domain.dto.EnderecoCreateDto;
import br.com.criador.domain.dto.EnderecoEditaDto;
import br.com.criador.domain.dto.output.EnderecoOutPutDto;
import br.com.criador.model.Endereco;
import br.com.criador.repository.EnderecoRepository;
import br.com.criador.repository.PessoaRepository;
import br.com.criador.service.EnderecoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {
  private final EnderecoRepository enderecoRepository;
  private final PessoaRepository pessoaRepository;

  @Override
  @Transactional
  public EnderecoOutPutDto cria(@NonNull final EnderecoCreateDto dto) {
    final var pessoa = pessoaRepository.findById(dto.getIdPessoa()).orElseThrow(RuntimeException::new);
    final var endereco = enderecoRepository.save(dto.toObject(pessoa));
    checkAddress(endereco);
    return endereco.toOutput();
  }

  private void checkAddress(final Endereco endereco) {
    if (endereco.isPricipal()) {
      enderecoRepository.disableOtherMainAddress(endereco.getPessoaId(), endereco.getId());
    }
  }

  @Override
  @Transactional
  public EnderecoOutPutDto edita(@NonNull final Long idEndereco,
                                 @NonNull final EnderecoEditaDto dto) {
    final var end = enderecoRepository.findById(idEndereco).orElseThrow(RuntimeException::new);
    Endereco enderecoAtualizado = enderecoRepository.save(dto.setChanges(end));
    checkAddress(enderecoAtualizado);
    return enderecoAtualizado.toOutput();
  }

  @Override
  public List<EnderecoOutPutDto> lista() {
    List<EnderecoOutPutDto> retorno = new ArrayList<>();
    Iterable<Endereco> consulta = enderecoRepository.findAll();
    consulta.forEach(o -> retorno.add(o.toOutput()));
    return retorno;
  }
}
