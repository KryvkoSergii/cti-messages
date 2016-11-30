package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

import ua.com.smiddle.cti.messages.model.exception.CTIException;
import ua.com.smiddle.cti.messages.model.exception.CTIMessageException;
import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.Header;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public class AnswerCallConf extends Header {
    private final static int FIXED_PART = 4;
    private final static int MAX_LENGTH = 12;
    private int invokeId;


    //Constructors
    public AnswerCallConf(int invokeId) {
        super(FIXED_PART, CTI.MSG_ANSWER_CALL_CONF);
        this.invokeId = invokeId;
    }


    //Getters & setters
    public int getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(int invokeId) {
        this.invokeId = invokeId;
    }


    //Methods
    public static AnswerCallConf deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        try {
            return new AnswerCallConf(buffer.getInt());
        } catch (BufferUnderflowException e) {
            return new AnswerCallConf(-1);
        }
    }

    public byte[] serializeMessage() throws CTIException {
        try {
            return ByteBuffer.allocate(MHDR + FIXED_PART).putInt(getMessageLength()).putInt(getMessageType()).putInt(invokeId).array();
        } catch (BufferOverflowException e) {
            throw new CTIMessageException("Buffer overflowed during HEART_BEAT_CONF serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AnswerCallConf{");
        sb.append(super.toString());
        sb.append(", invokeId=").append(invokeId);
        sb.append('}');
        return sb.toString();
    }
}
