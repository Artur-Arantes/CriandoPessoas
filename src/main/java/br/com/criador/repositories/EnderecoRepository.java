package br.com.criador.repositories;

import br.com.criador.domain.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Long, Endereco> {
}
