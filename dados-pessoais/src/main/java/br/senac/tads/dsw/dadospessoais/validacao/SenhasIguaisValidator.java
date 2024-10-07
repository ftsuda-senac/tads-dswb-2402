
package br.senac.tads.dsw.dadospessoais.validacao;

import br.senac.tads.dsw.dadospessoais.pessoas.PessoaDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhasIguaisValidator implements
        ConstraintValidator<SenhasIguais, PessoaDto> {

    @Override
    public boolean isValid(PessoaDto dto, ConstraintValidatorContext context) {
        return dto.getSenha().equals(dto.getSenhaRepetida());
    }
    
}
