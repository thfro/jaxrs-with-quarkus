package nrw.it.products;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonValidator implements ConstraintValidator<ValidPerson, Person> {

    boolean ageCheckEnabled = true;

    @Override
    public void initialize(ValidPerson annotation) {
        if (annotation.checkAge()==false) {
            ageCheckEnabled = false;
        }
    }


    @Override
    public boolean isValid(Person person, ConstraintValidatorContext context) {
        if (ageCheckEnabled && person.getAge() > 20 && person.getBeruf()==null) {
            return false;
        }
        return true;
    }
}
