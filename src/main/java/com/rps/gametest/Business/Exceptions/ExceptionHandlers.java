
package com.rps.gametest.Business.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler{



    @ExceptionHandler(value = {GameNotFoundException.class})
    public ResponseEntity<Object> handleGameNotFound(GameNotFoundException ex, WebRequest request){
        ErrorMessage error = new ErrorMessage(ex.getLocalizedMessage(),"Game not found");
        return new ResponseEntity<>(
                error, new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {GameFullException.class})
    public ResponseEntity<Object> handleGameFullException(GameFullException ex, WebRequest request){
        ErrorMessage error = new ErrorMessage(ex.getLocalizedMessage(),"Game is already full");
        return new ResponseEntity<>(
                error, new HttpHeaders(),HttpStatus.CONFLICT);

    }

    @ExceptionHandler(value = {WaitingForPlayerException.class})
    public ResponseEntity<Object> handleWaitingForPlayerException(WaitingForPlayerException ex, WebRequest request){
        ErrorMessage error = new ErrorMessage(ex.getLocalizedMessage(),"Waiting for other player");
        return new ResponseEntity<>(
                error, new HttpHeaders(),HttpStatus.CONFLICT);

    }

    @ExceptionHandler(value = {NoMoreMovesException.class})
    public ResponseEntity<Object> handleNoMoreMoves(NoMoreMovesException ex, WebRequest request){
        ErrorMessage error = new ErrorMessage(ex.getLocalizedMessage(),"Players have already made their moves");
        return new ResponseEntity<>(
                error, new HttpHeaders(),HttpStatus.CONFLICT);

    }

    @ExceptionHandler(value = {UnvalidMoveException.class})
    public ResponseEntity<Object> handleNoMoreMoves(UnvalidMoveException ex, WebRequest request){
        ErrorMessage error = new ErrorMessage(String.format("%s is not a valid move",ex.getLocalizedMessage()));
        return new ResponseEntity<>(
                error.getMessage(), new HttpHeaders(),HttpStatus.CONFLICT);


    }

    @ExceptionHandler(value = {NameAlreadyInUse.class})
    public ResponseEntity<Object> handleNameAlreadyInUse(NameAlreadyInUse ex, WebRequest request){
        ErrorMessage error = new ErrorMessage(String.format("Name: %s is used by other player",ex.getLocalizedMessage()));
        return new ResponseEntity<>(
                error.getMessage(), new HttpHeaders(),HttpStatus.CONFLICT);


    }
}


