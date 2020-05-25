package com.ipminor.kevindevijlder.taskmanager.config;

import org.springframework.beans.*;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

            Object attributeValue = wrapper.getPropertyValue(firstFieldName);

            final Object firstObj =  wrapper.getPropertyValue(firstFieldName);
            final Object secondObj =  wrapper.getPropertyValue(secondFieldName);

            boolean isValid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);

            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(secondFieldName).addConstraintViolation();
            }

            return isValid;
        }
        catch (final Exception ignore) {
            // ignore
        }
        return true;
    }

}
