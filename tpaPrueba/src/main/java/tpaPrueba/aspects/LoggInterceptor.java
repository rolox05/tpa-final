package tpaPrueba.aspects;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;

import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
public class LoggInterceptor implements MethodInterceptor<Object, Object> {

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {

        Logger.getLogger(context.getName()).info("Comienza el metodo "+context.getName());

        Object o =context.proceed();

        Logger.getLogger(context.getName()).info("Termina el metodo "+context.getName());

        return o;
    }
}
