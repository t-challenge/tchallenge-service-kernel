package ru.tsystems.tchallenge.service.kernel.generic;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.INTERFACES)
public abstract class GenericContext {

}
