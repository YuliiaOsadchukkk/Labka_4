package lpnu.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    private static final HttpStatus DEFAULT_HTTP_STATUS_CODE = HttpStatus.INTERNAL_SERVER_ERROR;
    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ServiceExceptionDTO> handleServiceException(final ServiceException ex, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.valueOf(ex.getCode())).body(new ServiceExceptionDTO(ex.getCode(),
                ex.getMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handlerException(final Exception ex, final WebRequest request) {
        return ResponseEntity.status(DEFAULT_HTTP_STATUS_CODE).body(new ExceptionDTO(DEFAULT_HTTP_STATUS_CODE,
                ex.getMessage()));
    }
}
