package ie.atu.week5.customerapp.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlevalidation(MethodArgumentNotValidException e){

        Map<String, String> errors = new HashMap<>();
        for (FieldError error: e.getBindingResult().getFieldErrors()){
            String fieldName = error.getField() + " ";
            String errorMessage = error.getDefaultMessage() + "  ";
            errors.put(fieldName, errorMessage);
        }
        return errors;
    }

}
