package com.sentinel.api.infrastructure.logging;

import com.sentinel.api.domain.logging.Logger;

public class LoggerFactory {
    private LoggerFactory() {
        super();
    }

    public static Logger getLogger(Class<?> clazz) {
        return new LoggerImpl(clazz);
    }
}
