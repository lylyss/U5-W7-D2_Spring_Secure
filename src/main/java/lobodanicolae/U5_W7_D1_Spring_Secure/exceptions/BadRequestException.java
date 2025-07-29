package lobodanicolae.U5_W7_D1_Spring_Secure.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
