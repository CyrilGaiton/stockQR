package fr.utln.ancy;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckMaterialValidator.class)
public @interface CheckMaterial {


    String message() default "Le materiel doit être de type enum MaterialType (bois, acier, plastique, ...)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
