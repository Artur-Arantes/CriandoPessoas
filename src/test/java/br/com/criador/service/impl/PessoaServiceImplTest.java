package br.com.criador.service.impl;

import br.com.criador.exceptions.PessoaNotFoundException;
import br.com.criador.model.Endereco;
import br.com.criador.model.Pessoa;
import br.com.criador.repository.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceImplTest {
  @Mock
  PessoaRepository repository;

  @InjectMocks
  PessoaServiceImpl pessoaService;

  @DisplayName("testando método consulta do service")
  @Nested
  public class Cria {
    @Test
    void falha() {
      final var pessoa = mock(Pessoa.class);
      List<Endereco> enderecos = new ArrayList<>();
      var endereco = Endereco.builder().build();
      enderecos.add(endereco);

      when(repository.findById(anyLong())).thenReturn(Optional.of(pessoa));
      assertThatExceptionOfType(PessoaNotFoundException.class).isThrownBy(() ->
          pessoaService.consulta(anyLong()));
    }
  }
}
