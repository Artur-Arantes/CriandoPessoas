package br.com.criador.model;

import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.time.ZonedDateTime;

@MappedSuperclass
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Generated
@ToString
public abstract class EntidadeBase {

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
