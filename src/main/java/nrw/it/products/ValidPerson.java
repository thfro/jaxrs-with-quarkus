package nrw.it.products;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = PersonValidator.class)
public @interface ValidPerson {

    boolean checkAge() default true;
    String message() default "Personendaten konnten nicht validiert werden";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
