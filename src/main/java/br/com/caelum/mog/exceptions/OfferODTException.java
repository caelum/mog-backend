package br.com.caelum.mog.exceptions;

public class OfferODTException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OfferODTException(Throwable cause) {
        super("Can't be generate ODT", cause);
    }

    public OfferODTException() {
        super("Can't be generate ODT");
    }
}
