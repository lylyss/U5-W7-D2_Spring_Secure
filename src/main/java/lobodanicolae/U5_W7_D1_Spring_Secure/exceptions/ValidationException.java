package lobodanicolae.U5_W7_D1_Spring_Secure.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        super("Errore di validazione");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
