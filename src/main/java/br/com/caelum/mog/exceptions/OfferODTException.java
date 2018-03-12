package br.com.caelum.mog.exceptions;

public class OfferODTException extends RuntimeException {

    public OfferODTException(Throwable cause) {
        super("Can't be generate ODT", cause);
    }

    public OfferODTException() {
        super("Can't be generate ODT");
    }
}
