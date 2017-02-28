package com.thoughtworks.lean.config;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.cloud.sleuth.Span;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;


@Configuration
public class ErrorConfig {

    @Bean
    ErrorAttributes getErrorAttributes() {
        return new LeanErrorAttributes();
    }
}

class LeanErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> ret = super.getErrorAttributes(requestAttributes, includeStackTrace);
        ret.put("traceId", MDC.get(Span.TRACE_ID_NAME));
        ret.put("spanId", MDC.get(Span.SPAN_ID_NAME));
        return ret;
    }
}
