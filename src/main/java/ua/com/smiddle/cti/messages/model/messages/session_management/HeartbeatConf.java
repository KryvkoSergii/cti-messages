package ua.com.smiddle.cti.messages.model.messages.session_management;

import ua.com.smiddle.cti.messages.model.exception.CTIException;
import ua.com.smiddle.cti.messages.model.exception.CTIMessageException;
import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.Header;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * Added by A.Osadchuk on 26.08.2016 at 16:37.
 * Project: SmiddleRecording
 */
public class HeartbeatConf extends Header {
    private final static int FIXED_PART = 4;
    private int invokeId;


    //Constructors
    public HeartbeatConf(int invokeId) {
        super(FIXED_PART, CTI.MSG_HEARTBEAT_CONF);
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
    public static HeartbeatConf deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        try {
            return new HeartbeatConf(buffer.getInt());
        } catch (BufferUnderflowException e) {
            return new HeartbeatConf(-1);
        }
    }

    //Methods
    public byte[] serializeMessage() throws CTIException {
        try {
            return ByteBuffer.allocate(MHDR + FIXED_PART).putInt(getMessageLength()).putInt(getMessageType()).putInt(invokeId).array();
        } catch (BufferOverflowException e) {
            throw new CTIMessageException("Buffer overflowed during HEART_BEAT_CONF serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HeartbeatConf{");
        sb.append(super.toString());
        sb.append(", invokeId=").append(invokeId);
        sb.append('}');
        return sb.toString();
    }
}
