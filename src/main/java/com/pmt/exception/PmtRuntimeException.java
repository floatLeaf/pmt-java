package com.pmt.exception;

public class PmtRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 18929174914141L;

    public PmtRuntimeException(String msg) {
        super(msg);
    };

    PmtRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
