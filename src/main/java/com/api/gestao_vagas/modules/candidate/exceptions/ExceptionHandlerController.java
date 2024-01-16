package com.api.gestao_vagas.modules.candidate.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice //pra definir um controle de Exception
public class ExceptionHandlerController {

    private MessageSource messageSource;
    public ExceptionHandlerController(MessageSource ms){
        this.messageSource = ms;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class) //definindo a class de alteração
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ErrorMessageDTO> dto = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(message, err.getField());
            dto.add(errorMessageDTO);
        }); // pegando os erros e tratando

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
