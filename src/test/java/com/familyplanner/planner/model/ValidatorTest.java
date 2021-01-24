package com.familyplanner.planner.model;

import java.util.Locale;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.familyplanner.planner.family.Family;
import com.familyplanner.planner.family.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    @Test
    void shouldNotValidateWhenLastNameEmpty() {
        LocaleContextHolder.setLocale(Locale.ENGLISH);
        Family family = new Family();
        family.setLastName("");

        Validator validator = createValidator();
        Set<ConstraintViolation<Family>> constraintViolations = validator.validate(family);

        assertThat(constraintViolations).hasSize(1);
        ConstraintViolation<Family> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("lastName");
        assertThat(violation.getMessage()).isEqualTo("must not be empty");
    }

    @Test
    void shouldNotValidateWhenNameEmpty() {
        LocaleContextHolder.setLocale(Locale.ENGLISH);
        Member member = new Member();
        member.setName("");

        Validator validator = createValidator();
        Set<ConstraintViolation<Member>> constraintViolations = validator.validate(member);

        assertThat(constraintViolations).hasSize(1);
        ConstraintViolation<Member> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("name");
        assertThat(violation.getMessage()).isEqualTo("must not be empty");
    }
}
