package lobodanicolae.U5_W7_D1_Spring_Secure.exceptions;

import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.Errore;
import lobodanicolae.U5_W7_D1_Spring_Secure.Payloads.ErroreDettagliato;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Errore handleBadRequest(BadRequestException ex) {
        return new Errore(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Errore handleNotFound(ResourceNotFoundException ex) {
        return new Errore(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroreDettagliato handleValidation(ValidationException ex) {
        return new ErroreDettagliato("Dati non validi", LocalDateTime.now(), ex.getErrors());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Errore handleGeneric(Exception ex) {
        ex.printStackTrace();
        return new Errore("Errore imprevisto. Ci scusiamo per il disagio.", LocalDateTime.now());
    }
}
