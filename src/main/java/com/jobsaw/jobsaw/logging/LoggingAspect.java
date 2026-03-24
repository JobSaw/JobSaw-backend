package com.jobsaw.jobsaw.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Aspect handling the @Loggable annotation logic.
 * Traces method entries, exits, execution duration, and potential exceptions.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(com.jobsaw.jobsaw.logging.Loggable)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Loggable loggable = method.getAnnotation(Loggable.class);

        String methodName = signature.getDeclaringType().getSimpleName() + "." + method.getName();
        String actionDescription = loggable.value().isEmpty() ? methodName : loggable.value();

        logger.info("[START] Action: '{}' - Executing method: {}", actionDescription, methodName);
        
        long start = System.currentTimeMillis();

        try {
            Object proceed = joinPoint.proceed();
            
            long executionTime = System.currentTimeMillis() - start;
            logger.info("[SUCCESS] Action: '{}' completed in {} ms.", actionDescription, executionTime);
            
            return proceed;
        } catch (Throwable throwable) {
            long executionTime = System.currentTimeMillis() - start;
            logger.error("[FAILED] Action: '{}' threw exception after {} ms. Error: {}", 
                    actionDescription, executionTime, throwable.getMessage(), throwable);
            throw throwable;
        }
    }
}
