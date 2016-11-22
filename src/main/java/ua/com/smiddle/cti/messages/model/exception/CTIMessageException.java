package ua.com.smiddle.cti.messages.model.exception;

/**
 * Added by A.Osadchuk on 26.08.2016 at 11:25.
 * Project: SmiddleRecording
 */
public class CTIMessageException extends CTIException {

    public CTIMessageException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "CTIMessageException: " + super.getMessage();
    }
}
