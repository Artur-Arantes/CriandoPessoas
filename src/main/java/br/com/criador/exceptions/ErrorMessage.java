package br.com.criador.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Generated
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorMessage {
  private String message;
}
