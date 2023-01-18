package br.com.criador.service.impl;

import br.com.criador.domain.dto.EnderecoCreateDto;
import br.com.criador.domain.dto.PessoaCreateDto;
import br.com.criador.repository.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceImplTest {
  @Mock
  PessoaRepository repository;

  @InjectMocks
  PessoaServiceImpl pessoaService;

  @DisplayName("testando método cria do service")
  @Nested
  public class Cria {

void sucesso(){
final String dataNascimento="xx/xx/xx";
final String nome = "Harry";

final var pessoaDto= mock(PessoaCreateDto.class);
final var enderecoDto= mock(EnderecoCreateDto.class);
when(pessoaDto.getDataNascimento()).thenReturn(dataNascimento);
when(pessoaDto.getNome()).thenReturn(nome);
}
  }
}
