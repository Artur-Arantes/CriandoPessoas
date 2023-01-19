package br.com.criador.repository;

import br.com.criador.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
  @Modifying(clearAutomatically = true)
  @Query(value = "update ENDERECO set PRI_END=false where ID_PES=:id_pes and ID_END<>:id_end and PRI_END=true",
      nativeQuery = true)
  void disableOtherMainAddress(@Param("id_pes") final Long idPes, @Param("id_end") final Long idEnd);
}
