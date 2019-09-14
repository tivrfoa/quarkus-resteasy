package org.acme.quickstart;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier
public @interface Original {

}