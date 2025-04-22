package com.system_common.rest.handles;

import com.system_common.rest.dto.ResponseGeneric;
import com.system_common.rest.exception.BussinesCheckedException;
import com.system_common.rest.exception.BussinesUncheckedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class HandleResponseException {

    @ExceptionHandler
    public ResponseEntity<ResponseGeneric<Void>> handleStudentNotFoundException(Throwable exception,
                                                                                HttpServletRequest request) {
        String requestId = request.getHeader("request-id");
        log.info("request-id : {} | finally request for employee - system error {}  ",  requestId, exception.getMessage());
        if(exception instanceof BussinesCheckedException || exception instanceof BussinesUncheckedException){
            String [] notification = {String.format("Error de negocio %s",exception.getMessage())};
            ResponseGeneric<Void> responseGeneric = new ResponseGeneric<>(null,notification);
            return new ResponseEntity<>(responseGeneric, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        String [] notification = {String.format("Error del sistema %s",exception.getMessage())};
        ResponseGeneric<Void> responseGeneric = new ResponseGeneric<>(null,notification);
        return new ResponseEntity<>(responseGeneric, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
