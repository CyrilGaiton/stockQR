package fr.utln.ancy;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckMaterialValidator implements ConstraintValidator<CheckMaterial, MaterialType> {

    @Override
    public void initialize(CheckMaterial checkMaterial){}

    @Override
    public boolean isValid(MaterialType materialType, ConstraintValidatorContext constraintValidatorContext) {

        return (materialType == null);
    }
}
