package fr.utln.ancy;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckSalleNomValidator implements ConstraintValidator<CheckSalleNom, String> {

    @Override
    public void initialize(CheckSalleNom checkSalleNom){}

    @Override
    public boolean isValid(String nom, ConstraintValidatorContext constraintValidatorContext) {
        boolean isChecked = false;
        if (Character.isLetter(nom.charAt(0)) && Character.isLowerCase(nom.charAt(0)) && nom.length()>1){
            isChecked = true;
            for (int i=1; i<nom.length(); i++){
                if (!Character.isDigit(nom.charAt(i))) isChecked= false;
            }
        }
        return (isChecked);
    }
}
