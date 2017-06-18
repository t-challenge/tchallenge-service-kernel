package ru.tchallenge.service.kernel.conventions.components;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.INTERFACES)
@Target(ElementType.TYPE)
public @interface RequestContextComponent {

}
