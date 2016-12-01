package ua.com.smiddle.cti.messages.model.messages.calls;

import ua.com.smiddle.cti.messages.model.exception.CTIException;
import ua.com.smiddle.cti.messages.model.exception.CTIMessageException;
import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.Header;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * @author ksa on 01.12.16.
 * @project cti-messages
 */
public class ClearCallConf extends Header {
    private final static int FIXED_PART = 4;
    private final static int MAX_LENGTH = 12;
    private int invokeId;


    //Constructors
    public ClearCallConf(int invokeId) {
        super(FIXED_PART, CTI.MSG_CLEAR_CALL_CONF);
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
    public static ClearCallConf deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        try {
            return new ClearCallConf(buffer.getInt());
        } catch (BufferUnderflowException e) {
            return new ClearCallConf(-1);
        }
    }

    public byte[] serializeMessage() throws CTIException {
        try {
            return ByteBuffer.allocate(MHDR + FIXED_PART).putInt(getMessageLength()).putInt(getMessageType()).putInt(invokeId).array();
        } catch (BufferOverflowException e) {
            throw new CTIMessageException("Buffer overflowed during MSG_CLEAR_CALL_CONF serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClearCallConf{");
        sb.append(super.toString());
        sb.append(", invokeId=").append(invokeId);
        sb.append('}');
        return sb.toString();
    }
}
