package ru.tchallenge.service.kernel.utility.correlation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service
public class CorrelationInterceptorBean extends HandlerInterceptorAdapter {

    @Autowired
    private CorrelationContextConfigurer correlationContextConfigurer;

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object object) throws Exception {
        correlationContextConfigurer.setCorrelation(correlation(request));
        return true;
    }

    private CorrelationInfo correlation(final HttpServletRequest request) {
        return new CorrelationInfo();
    }
}
