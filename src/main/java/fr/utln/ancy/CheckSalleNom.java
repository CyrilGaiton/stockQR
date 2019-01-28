package fr.utln.ancy;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckSalleNomValidator.class)
public @interface CheckSalleNom {


    String message() default "Le nom de la salle doit commencer par une lettre minuscule et finir par des chiffres";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
