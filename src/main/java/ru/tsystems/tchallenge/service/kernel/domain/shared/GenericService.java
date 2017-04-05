package ru.tsystems.tchallenge.service.kernel.domain.shared;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public abstract class GenericService {

}
