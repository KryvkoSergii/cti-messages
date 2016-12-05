package ua.com.smiddle.cti.messages.model.messages.calls.events;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.calls.ConnectionDeviceIDTypes;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;
import ua.com.smiddle.cti.messages.model.messages.common.PeripheralTypes;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public class EndCallEvent extends Header {
    private final static int FIXED_PART = 16;
    private final static int MAX_LENGTH = 90;
    List<FloatingField> floatingFields = new ArrayList();
    private int monitorId;
    private int peripheralId;
    private PeripheralTypes peripheralType;
    private ConnectionDeviceIDTypes connectionDeviceIDType;
    private int connectionCallID;


    //Constructors
    public EndCallEvent() {
        super(CTI.MSG_END_CALL_EVENT);
    }


    //Getters and setters
    public List<FloatingField> getFloatingFields() {
        return floatingFields;
    }

    public void setFloatingFields(List<FloatingField> floatingFields) {
        this.floatingFields = floatingFields;
    }

    public int getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(int monitorId) {
        this.monitorId = monitorId;
    }

    public int getPeripheralId() {
        return peripheralId;
    }

    public void setPeripheralId(int peripheralId) {
        this.peripheralId = peripheralId;
    }

    public PeripheralTypes getPeripheralType() {
        return peripheralType;
    }

    public void setPeripheralType(PeripheralTypes peripheralType) {
        this.peripheralType = peripheralType;
    }

    public ConnectionDeviceIDTypes getConnectionDeviceIDType() {
        return connectionDeviceIDType;
    }

    public void setConnectionDeviceIDType(ConnectionDeviceIDTypes connectionDeviceIDType) {
        this.connectionDeviceIDType = connectionDeviceIDType;
    }

    public int getConnectionCallID() {
        return connectionCallID;
    }

    public void setConnectionCallID(int connectionCallID) {
        this.connectionCallID = connectionCallID;
    }


    //Methods
    public byte[] serializeMessage() throws Exception {
        try {
            this.setMessageLength(FIXED_PART + FloatingField.calculateFloatingPart(floatingFields));
            this.setMessageType(CTI.MSG_END_CALL_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putInt(peripheralId)
                    .putShort((short) PeripheralTypes.getInt(peripheralType))
                    .putShort((short) connectionDeviceIDType.getValue())
                    .putInt(connectionCallID);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_END_CALL_EVENT serialization!");
        }
    }

    public static EndCallEvent deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        EndCallEvent message = new EndCallEvent();
        try {
            message.setMessageLength(buffer.getInt());
            message.setMessageType(buffer.getInt());
            message.setMonitorId(buffer.getInt());
            message.setPeripheralId(buffer.getInt());
            message.setPeripheralType(PeripheralTypes.getType(Short.toUnsignedInt(buffer.getShort())));
            message.setConnectionDeviceIDType(ConnectionDeviceIDTypes.getType(Short.toUnsignedInt(buffer.getShort())));
            message.setConnectionCallID(buffer.getInt());
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EndCallEvent{");
        sb.append(super.toString());
        sb.append(", floatingFields=").append(floatingFields);
        sb.append(", monitorId=").append(monitorId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", peripheralType=").append(peripheralType);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append('}');
        return sb.toString();
    }
}
