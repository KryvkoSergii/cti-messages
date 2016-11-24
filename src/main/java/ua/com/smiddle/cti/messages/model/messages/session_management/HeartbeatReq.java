package ua.com.smiddle.cti.messages.model.messages.session_management;

import ua.com.smiddle.cti.messages.model.exception.CTIException;
import ua.com.smiddle.cti.messages.model.exception.CTIMessageException;
import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.Header;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/**
 * Added by A.Osadchuk on 26.08.2016 at 16:37.
 * Project: SmiddleRecording
 */
public class HeartbeatReq extends Header {
    private final static int FIXED_PART = 4;

    private int invokeId;


    //Constructors
    public HeartbeatReq() {
        super(FIXED_PART, CTI.MSG_HEARTBEAT_REQ);
    }

    public HeartbeatReq(int invokeId) {
        super(FIXED_PART, CTI.MSG_HEARTBEAT_REQ);
        this.invokeId = invokeId;
    }

    //static methods
    public static HeartbeatReq deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        HeartbeatReq message = new HeartbeatReq();
        message.setMessageLength(buffer.getInt());
        message.setMessageType(buffer.getInt());
        message.setInvokeId(buffer.getInt());
        return message;
    }

    //Getters & setters
    public int getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(int invokeId) {
        this.invokeId = invokeId;
    }

    //Methods
    public byte[] serializeMessage() throws CTIException {
        try {
            return ByteBuffer.allocate(Header.MHDR + FIXED_PART).putInt(getMessageLength()).putInt(getMessageType()).putInt(invokeId).array();
        } catch (BufferOverflowException e) {
            throw new CTIMessageException("Buffer overflowed during MSG_HEARTBEAT_REQ serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HeartbeatReq{");
        sb.append(super.toString());
        sb.append(", invokeId=").append(invokeId);
        sb.append('}');
        return sb.toString();
    }
}
