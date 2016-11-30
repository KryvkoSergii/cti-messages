package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public class RtpStoppedEvent extends Header {
    private final static int FIXED_PART = 20;
    private final static int MAX_LENGTH = 210;
    private int monitorId;
    private int peripheralId;
    private int clientPort;
    private CallDirection direction;
    private ConnectionDeviceIDTypes connectionDeviceIDType;
    private int connectionCallID;
    List<FloatingField> floatingFields = new ArrayList<>();


    //Constructors
    public RtpStoppedEvent() {
        super(CTI.MSG_RTP_STOPPED_EVENT);
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

    public int getClientPort() {
        return clientPort;
    }

    public void setClientPort(int clientPort) {
        this.clientPort = clientPort;
    }

    public CallDirection getDirection() {
        return direction;
    }

    public void setDirection(CallDirection direction) {
        this.direction = direction;
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
            this.setMessageType(CTI.MSG_RTP_STOPPED_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putInt(peripheralId)
                    .putInt(clientPort)
                    .putShort((short) direction.ordinal())
                    .putShort((short) connectionDeviceIDType.getValue())
                    .putInt(connectionCallID);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_RTP_STOPPED_EVENT serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RtpStoppedEvent{");
        sb.append(super.toString());
        sb.append(", monitorId=").append(monitorId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", clientPort=").append(clientPort);
        sb.append(", direction=").append(direction);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append(", floatingFields=").append(floatingFields);
        sb.append('}');
        return sb.toString();
    }
}
