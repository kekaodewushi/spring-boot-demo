package com.wanma.charge.util.exception;


public class CECBusinessException extends RuntimeException {
    private String code;

    private String message;

    public CECBusinessException(Throwable cause, String code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public CECBusinessException(String code) {
        this.code = code;
    }

    public CECBusinessException(Throwable cause) {
        super(cause);
    }

    public CECBusinessException() {
        super();
    }

    public CECBusinessException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

