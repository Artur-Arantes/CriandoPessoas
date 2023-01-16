package br.com.criador.domain;

import jakarta.persistence.*;
import lombok.*;

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
    protected void prePersist(){
        createdAt= updatedAt=ZonedDateTime.now();
    }

    @PreUpdate
    protected void preUpdate(){
        createdAt=ZonedDateTime.now();
    }

}
