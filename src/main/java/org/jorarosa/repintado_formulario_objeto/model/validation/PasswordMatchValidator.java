package org.jorarosa.repintado_formulario_objeto.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.jorarosa.repintado_formulario_objeto.model.DatosFormulario;


public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, DatosFormulario>{

    @Override
    public void initialize(PasswordMatch p) {
        
    }
    
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext c) {
        String clave = datosFormulario.getClave();
        String confirmarClave = datosFormulario.getConfirmarClave();
        
        if (clave == null || !clave.equals(confirmarClave)) {
            return false;
        }
        return true;
    }

}