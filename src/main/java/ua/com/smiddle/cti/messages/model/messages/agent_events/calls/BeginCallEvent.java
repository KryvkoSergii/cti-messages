package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

import ua.com.smiddle.cti.messages.model.messages.CTI;
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
public class BeginCallEvent extends Header {
    private final static int FIXED_PART = 26;
    private final static int MAX_LENGTH = 4561;
    List<FloatingField> floatingFields = new ArrayList();
    private int monitorId;
    private int peripheralId;
    private PeripheralTypes peripheralType;
    private short numCTIClients;
    private short numNamedVariables;
    private short numNamedArrays;
    private CallTypes callType;
    private ConnectionDeviceIDTypes connectionDeviceIDType;
    private int connectionCallID;
    private short calledPartyDisposition;


    //Constructors
    public BeginCallEvent() {
        super(CTI.MSG_BEGIN_CALL_EVENT);
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

    public short getNumCTIClients() {
        return numCTIClients;
    }

    public void setNumCTIClients(short numCTIClients) {
        this.numCTIClients = numCTIClients;
    }

    public short getNumNamedVariables() {
        return numNamedVariables;
    }

    public void setNumNamedVariables(short numNamedVariables) {
        this.numNamedVariables = numNamedVariables;
    }

    public short getNumNamedArrays() {
        return numNamedArrays;
    }

    public void setNumNamedArrays(short numNamedArrays) {
        this.numNamedArrays = numNamedArrays;
    }

    public CallTypes getCallType() {
        return callType;
    }

    public void setCallType(CallTypes callType) {
        this.callType = callType;
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

    public short getCalledPartyDisposition() {
        return calledPartyDisposition;
    }

    public void setCalledPartyDisposition(short calledPartyDisposition) {
        this.calledPartyDisposition = calledPartyDisposition;
    }


    //Methods
    public byte[] serializeMessage() throws Exception {
        try {
            this.setMessageLength(FIXED_PART + FloatingField.calculateFloatingPart(floatingFields));
            this.setMessageType(CTI.MSG_BEGIN_CALL_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putInt(peripheralId)
                    .putShort((short) PeripheralTypes.getInt(peripheralType))
                    .putShort(numCTIClients)
                    .putShort(numNamedVariables)
                    .putShort(numNamedArrays)
                    .putShort((short) callType.getValue())
                    .putShort((short) connectionDeviceIDType.getValue())
                    .putInt(connectionCallID)
                    .putShort(calledPartyDisposition);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_BEGIN_CALL_EVENT serialization!");
        }
    }

    public static BeginCallEvent deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        BeginCallEvent message = new BeginCallEvent();
        try {
            message.setMessageLength(buffer.getInt());
            message.setMessageType(buffer.getInt());
            message.setMonitorId(buffer.getInt());
            message.setPeripheralId(buffer.getInt());
            message.setPeripheralType(PeripheralTypes.getType(Short.toUnsignedInt(buffer.getShort())));
            message.setNumCTIClients(buffer.getShort());
            message.setNumNamedVariables(buffer.getShort());
            message.setNumNamedArrays(buffer.getShort());
            message.setCallType(CallTypes.getType(Short.toUnsignedInt(buffer.getShort())));
            message.setConnectionDeviceIDType(ConnectionDeviceIDTypes.getType(Short.toUnsignedInt(buffer.getShort())));
            message.setConnectionCallID(buffer.getInt());
            message.setCalledPartyDisposition(buffer.getShort());
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
        final StringBuilder sb = new StringBuilder("BeginCallEvent{");
        sb.append(super.toString());
        sb.append(", floatingFields=").append(floatingFields);
        sb.append(", monitorId=").append(monitorId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", peripheralType=").append(peripheralType);
        sb.append(", numCTIClients=").append(numCTIClients);
        sb.append(", numNamedVariables=").append(numNamedVariables);
        sb.append(", numNamedArrays=").append(numNamedArrays);
        sb.append(", callType=").append(callType);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append(", calledPartyDisposition=").append(calledPartyDisposition);
        sb.append('}');
        return sb.toString();
    }
}
