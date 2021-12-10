package lpnu.exception;

public class ServiceExceptionDTO {
    private int code;
    private String message;
    private String details;

    public ServiceExceptionDTO() {
    }

    public ServiceExceptionDTO(final ServiceException ex) {
        this.code = ex.getCode();
        this.message = ex.getMessage();
        this.details = ex.getDetails();
    }

    public ServiceExceptionDTO(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(final String details) {
        this.details = details;
    }
}