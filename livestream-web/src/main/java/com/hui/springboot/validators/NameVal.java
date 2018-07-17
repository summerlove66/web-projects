package com.hui.springboot.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author hui
 * 自定义注解，NameVal
 *检测是否包含contain参数
 *不包含notContain参数
 */

@Documented
@Constraint( validatedBy = NameValidator.class)
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameVal {

	String message() default "必须含有contain字段";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String contain() default "";
	String notContain() default "";
}
