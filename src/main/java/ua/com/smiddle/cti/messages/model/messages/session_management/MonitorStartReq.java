package ua.com.smiddle.cti.messages.model.messages.session_management;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;

import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author srg on 22.11.16.
 * @project cti-messages
 */
public class MonitorStartReq extends Header {
    private final static int FIXED_PART = 24;
    private final static int MAX_LENGTH = 164;
    private int invokeId;
    private int peripheralID;
    private int connectionCallID;
    private int callMsgMask; // нужна обработка
    private int agentStateMask; // нужна обработка
    private short connectionDeviceIDType; //table 6-13
    private short monitoredDeviceType; //table 6-11
    private List<FloatingField> floatingFields = new ArrayList<>(7);


    //Constructors
    public MonitorStartReq() {
    }


    //Getters and setters
    public int getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(int invokeId) {
        this.invokeId = invokeId;
    }

    public int getPeripheralID() {
        return peripheralID;
    }

    public void setPeripheralID(int peripheralID) {
        this.peripheralID = peripheralID;
    }

    public int getConnectionCallID() {
        return connectionCallID;
    }

    public void setConnectionCallID(int connectionCallID) {
        this.connectionCallID = connectionCallID;
    }

    public int getCallMsgMask() {
        return callMsgMask;
    }

    public void setCallMsgMask(int callMsgMask) {
        this.callMsgMask = callMsgMask;
    }

    public int getAgentStateMask() {
        return agentStateMask;
    }

    public void setAgentStateMask(int agentStateMask) {
        this.agentStateMask = agentStateMask;
    }

    public short getConnectionDeviceIDType() {
        return connectionDeviceIDType;
    }

    public void setConnectionDeviceIDType(short connectionDeviceIDType) {
        this.connectionDeviceIDType = connectionDeviceIDType;
    }

    public short getMonitoredDeviceType() {
        return monitoredDeviceType;
    }

    public void setMonitoredDeviceType(short monitoredDeviceType) {
        this.monitoredDeviceType = monitoredDeviceType;
    }

    public List<FloatingField> getFloatingFields() {
        return floatingFields;
    }

    public void setFloatingFields(List<FloatingField> floatingFields) {
        this.floatingFields = floatingFields;
    }

    //Methods
    public static MonitorStartReq deserializeMessage(byte[] bytes) throws UnsupportedEncodingException {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        MonitorStartReq message = new MonitorStartReq();
        try {
            message.setMessageLength(buffer.getInt());
            message.setMessageType(buffer.getInt());
            message.setInvokeId(buffer.getInt());
            message.setPeripheralID(buffer.getInt());
            message.setConnectionCallID(buffer.getInt());
            message.setCallMsgMask(buffer.getInt());
            message.setAgentStateMask(buffer.getInt());
            message.setConnectionDeviceIDType(buffer.getShort());
            message.setMonitoredDeviceType(buffer.getShort());
            while (true) {
                try {
                    message.getFloatingFields().add(FloatingField.deserializeField(buffer));
                } catch (BufferUnderflowException e) {
                    break;
                }
            }
            return message;
        } catch (BufferUnderflowException e) {
            return message;
        }
    }

    public byte[] serializeMessage() throws Exception {
        try {
            setMessageLength(FIXED_PART + FloatingField.calculateFloatingPart(floatingFields));
            setMessageType(CTI.MSG_MONITOR_START_REQ);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + FIXED_PART + FloatingField.calculateFloatingPart(floatingFields))
                    .putInt(getMessageLength())
                    .putInt(getMessageType())
                    .putInt(invokeId)
                    .putInt(peripheralID)
                    .putInt(connectionCallID)
                    .putInt(callMsgMask)
                    .putInt(agentStateMask)
                    .putShort(connectionDeviceIDType)
                    .putShort(monitoredDeviceType);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during Monitor_Start_Req serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MonitorStartReq{");
        sb.append(super.toString());
        sb.append(",invokeId=").append(invokeId);
        sb.append(", peripheralID=").append(peripheralID);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append(", callMsgMask=").append(callMsgMask);
        sb.append(", agentStateMask=").append(agentStateMask);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", monitoredDeviceType=").append(monitoredDeviceType);
        sb.append(", floatingFields=").append(floatingFields);
        sb.append('}');
        return sb.toString();
    }
}
