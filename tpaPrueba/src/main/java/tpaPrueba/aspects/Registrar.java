package tpaPrueba.aspects;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Around
@Target({ElementType.TYPE, ElementType.METHOD})
@Type(LoggInterceptor.class)
public @interface Registrar {
}
