package br.com.criador.utils;

import br.com.criador.interfaces.IsPrincipalValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EnderecosValidator implements
    ConstraintValidator<EnderecosConstraint, List<? extends IsPrincipalValidation>> {

  private static final int MAXSIZE = 1;

  @Override
  public void initialize(EnderecosConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(List<? extends IsPrincipalValidation> isPrincipalValidations, ConstraintValidatorContext constraintValidatorContext) {
    return isPrincipalValidations.stream().filter(IsPrincipalValidation::isPrincipal)
        .toList().size() == MAXSIZE;
  }
}
