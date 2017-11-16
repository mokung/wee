package me.wenkang.wee.biz.aop;

import lombok.extern.slf4j.Slf4j;
import me.wenkang.wee.biz.exception.VerifyException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by wenkang
 * on 2017/11/15.
 */
@Aspect
@Component
@Slf4j
public class ValidatorAspect {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Before("@annotation(javax.validation.Valid)")
    public void validatorParams(JoinPoint joinPoint) {
        for (Object param : joinPoint.getArgs()) {
            checkParams(param);
        }
    }

    /**
     * hibernate valid params
     *
     * @param obj
     */
    private void checkParams(Object obj) {
        Set<ConstraintViolation<Object>> validate = validator.validate(obj);
        if (validate.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<Object> violation : validate) {
            String message = violation.getMessage();
            String prop = violation.getPropertyPath().toString();
            String clazz = violation.getRootBeanClass().toString();
            sb.append(clazz).append(".").append(prop).append(":").append(message);
            sb.append(";");
        }
        throw new VerifyException(sb.toString());
    }

}
