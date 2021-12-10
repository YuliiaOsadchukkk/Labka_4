package lpnu.exception;

import org.springframework.http.HttpStatus;

public class ExceptionDTO extends Exception{
    private HttpStatus code;
    private String message;

    public ExceptionDTO() {
    }

    public ExceptionDTO(final ExceptionDTO ex) {
        this.code = ex.getCode();
        this.message = ex.getMessage();
    }

    public ExceptionDTO(final HttpStatus code, final String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(final HttpStatus code) {
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