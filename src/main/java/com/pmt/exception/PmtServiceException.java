package com.pmt.exception;

public class PmtServiceException extends  PmtRuntimeException {
    private static final long serialVersionUID = 211432342424243242L;

    private Integer code;

    public PmtServiceException(String msg) {
        super(msg);
    }

    public PmtServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public PmtServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public PmtServiceException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
