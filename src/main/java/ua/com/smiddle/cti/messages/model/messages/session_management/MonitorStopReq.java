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
public class MonitorStopReq extends Header {
    private final static int FIXED_PART = 8;
    private final static int MAX_LENGTH = 16;
    private int invokeId;
    private int monitorId;


    //Constructors
    public MonitorStopReq() {
    }


    //Static Methods
    public static MonitorStopReq deserializeMessage(byte[] bytes) throws UnsupportedEncodingException {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        MonitorStopReq message = new MonitorStopReq();
        try {
            message.setMessageLength(buffer.getInt());
            message.setMessageType(buffer.getInt());
            message.setInvokeId(buffer.getInt());
            message.setMonitorId(buffer.getInt());
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

    public int getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(int monitorId) {
        this.monitorId = monitorId;
    }


    //Methods
    public byte[] serializeMessage() throws Exception {
        try {
            setMessageLength(FIXED_PART);
            setMessageType(CTI.MSG_MONITOR_START_CONF);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + FIXED_PART)
                    .putInt(getMessageLength())
                    .putInt(getMessageType())
                    .putInt(invokeId)
                    .putInt(monitorId);
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during Monitor_Stop_Req serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MonitorStopReq{");
        sb.append(super.toString());
        sb.append(", invokeId=").append(invokeId);
        sb.append(", monitorId=").append(monitorId);
        sb.append('}');
        return sb.toString();
    }
}
