package com.jobsaw.jobsaw.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to automatically log method execution details.
 * Place this on any business logic method to log its exact execution time, 
 * entry arguments, and successful completion or exception thrown.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {

    /**
     * Optional description of the action being logged.
     * @return the description of the action
     */
    String value() default "";

}
