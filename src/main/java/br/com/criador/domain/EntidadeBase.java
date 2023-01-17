package br.com.criador.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@MappedSuperclass
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Generated
@ToString
public class EntidadeBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id;

  @Version
  protected Integer version;

  protected ZonedDateTime createdAt;

  private ZonedDateTime updatedAt;

  @PrePersist
  protected void prePersist() {
    createdAt = updatedAt = ZonedDateTime.now();
  }

  @PreUpdate
  protected void preUpdate() {
    createdAt = ZonedDateTime.now();
  }

}
