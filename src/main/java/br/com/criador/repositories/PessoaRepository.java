package br.com.criador.repositories;

import br.com.criador.domain.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
