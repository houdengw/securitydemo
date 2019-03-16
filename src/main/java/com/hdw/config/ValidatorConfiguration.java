package com.hdw.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Configuration;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Title: evils
 * CreateDate:  2019/3/15
 *
 * @author houdengw
 * @version 1.0
 */
@Configuration
public class ValidatorConfiguration {

    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast","true")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }
}
