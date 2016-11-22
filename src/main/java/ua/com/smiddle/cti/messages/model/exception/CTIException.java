package ua.com.smiddle.cti.messages.model.exception;

/**
 * Added by A.Osadchuk on 06.09.2016 at 13:48.
 * Project: SmiddleRecording
 */
public class CTIException extends Exception {

    public CTIException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
