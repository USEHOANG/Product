package sping.api.spingboot.api.User.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handle(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }


    //validate
    @ExceptionHandler(value =  MethodArgumentNotValidException.class)
    ResponseEntity<String> handleValidate(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
    }
}
