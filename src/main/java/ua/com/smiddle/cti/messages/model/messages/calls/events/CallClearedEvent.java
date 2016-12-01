package ua.com.smiddle.cti.messages.model.messages.calls.events;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.calls.ConnectionDeviceIDTypes;
import ua.com.smiddle.cti.messages.model.messages.calls.EventCause;
import ua.com.smiddle.cti.messages.model.messages.calls.LocalConnectionState;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;
import ua.com.smiddle.cti.messages.model.messages.common.PeripheralTypes;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ksa on 01.12.16.
 * @project cti-messages
 */
public class CallClearedEvent extends Header {
    private final static int FIXED_PART = 20;
    private final static int MAX_LENGTH = 94;
    private int monitorId;
    private int peripheralId;
    private PeripheralTypes peripheralType;
    private ConnectionDeviceIDTypes connectionDeviceIDType;
    private int connectionCallID;
    private LocalConnectionState localConnectionState;
    private EventCause eventCause;
    List<FloatingField> floatingFields = new ArrayList<>();


    //Constructors
    public CallClearedEvent() {
        super(CTI.MSG_CALL_CLEARED_EVENT);
    }


    //Getters and setters
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

    public LocalConnectionState getLocalConnectionState() {
        return localConnectionState;
    }

    public void setLocalConnectionState(LocalConnectionState localConnectionState) {
        this.localConnectionState = localConnectionState;
    }

    public EventCause getEventCause() {
        return eventCause;
    }

    public void setEventCause(EventCause eventCause) {
        this.eventCause = eventCause;
    }

    public List<FloatingField> getFloatingFields() {
        return floatingFields;
    }

    public void setFloatingFields(List<FloatingField> floatingFields) {
        this.floatingFields = floatingFields;
    }


    //Methods
    public byte[] serializeMessage() throws Exception {
        try {
            this.setMessageLength(FIXED_PART + FloatingField.calculateFloatingPart(floatingFields));
            this.setMessageType(CTI.MSG_CALL_CLEARED_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putInt(peripheralId)
                    .putShort((short) PeripheralTypes.getInt(peripheralType))
                    .putShort((short) connectionDeviceIDType.getValue())
                    .putInt(connectionCallID)
                    .putShort((short) localConnectionState.getValue())
                    .putShort((short) eventCause.getValue());
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_CALL_CLEARED_EVENT serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CallClearedEvent{");
        sb.append(super.toString());
        sb.append(", monitorId=").append(monitorId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", peripheralType=").append(peripheralType);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append(", localConnectionState=").append(localConnectionState);
        sb.append(", eventCause=").append(eventCause);
        sb.append(", floatingFields=").append(floatingFields);
        sb.append('}');
        return sb.toString();
    }
}
