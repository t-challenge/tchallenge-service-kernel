package ru.tsystems.tchallenge.service.kernel.utility.correlation;

import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.generic.GenericContext;

@Component
public class CorrelationContextConfigurerBean extends GenericContext implements CorrelationContextConfigurer {

    private CorrelationInfo correlation;

    @Override
    public CorrelationInfo getCorrelation() {
        return correlation;
    }

    @Override
    public void setCorrelation(final CorrelationInfo correlation) {
        this.correlation = correlation;
    }
}
