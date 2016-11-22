package ua.com.smiddle.cti.messages.model.messages.session_management;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.Header;

import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * @author srg on 22.11.16.
 * @project cti-messages
 */
public class MonitorStopConf extends Header {
    private final static int FIXED_PART = 4;
    private final static int MAX_LENGTH = 12;
    private int invokeId;


    //Constructors
    public MonitorStopConf() {
    }


    //Static Methods
    public static MonitorStopConf deserializeMessage(byte[] bytes) throws UnsupportedEncodingException {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        MonitorStopConf message = new MonitorStopConf();
        try {
            message.setMessageLength(buffer.getInt());
            message.setMessageType(buffer.getInt());
            message.setInvokeId(buffer.getInt());
            return message;
        } catch (BufferUnderflowException e) {
            return message;
        }
    }


    //Getters and setters
    public int getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(int invokeId) {
        this.invokeId = invokeId;
    }


    //Methods
    public byte[] serializeMessage() throws Exception {
        try {
            setMessageLength(FIXED_PART);
            setMessageType(CTI.MSG_MONITOR_START_CONF);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + FIXED_PART)
                    .putInt(getMessageLength())
                    .putInt(getMessageType())
                    .putInt(invokeId);
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during Monitor_Stop_Conf serialization!");
        }
    }
}
}
