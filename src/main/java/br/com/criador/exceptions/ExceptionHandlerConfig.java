package br.com.criador.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Configuration
public class ExceptionHandlerConfig {

  public static final String PESSOA_NOT_FOUND_MESSAGE = "Id de pessoa referenciado não encontrado.";

  @ExceptionHandler(PessoaNotFoundException.class)
  @ResponseStatus(NOT_FOUND)
  public List<ErrorMessage> pessoaNotFound(final PessoaNotFoundException ex) {
    return singletonList(
        ErrorMessage.builder()
            .message(PESSOA_NOT_FOUND_MESSAGE)
            .build()
    );
  }

  @ExceptionHandler(SQLException.class)
  @ResponseStatus(NOT_FOUND)
  public List<ErrorMessage> pessoaNotFound(final SQLException ex) {
    return singletonList(
        ErrorMessage.builder()
            .message("Erro de Consulta generico")
            .build()
    );
  }
}
