package ru.tchallenge.service.kernel.utility.correlation;

import ru.tchallenge.service.kernel.conventions.components.RequestContextComponent;
import ru.tchallenge.service.kernel.generic.GenericContext;

@RequestContextComponent
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
