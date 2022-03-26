package web.maxnumber.errors;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ServerError {
    private String message;
    private HttpStatus errorCode;
    private List<String> errors;

    public HttpStatus getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public ServerError(HttpStatus httpStatus, String message, List<String> errors) {
        this.message = message;
        this.errorCode = httpStatus;
        this.errors = errors;
    }
}
