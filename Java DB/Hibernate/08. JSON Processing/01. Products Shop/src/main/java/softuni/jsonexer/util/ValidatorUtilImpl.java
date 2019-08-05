package softuni.jsonexer.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidatorUtilImpl implements ValidatorUtil {

    private final Validator validator;

    @Autowired
    public ValidatorUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return this.validator.validate(entity).size() == 0;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> violations(E entity) {
        return validator.validate(entity);
    }
}
