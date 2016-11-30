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
public class RtpStartedEvent extends Header {
    private final static int FIXED_PART = 34;
    private final static int MAX_LENGTH = 224;
    private int monitorId;
    private int peripheralId;
    private int clientPort;
    private CallDirection direction;
    private short rtpType;
    private int bitRate;
    private short echoCancellation;
    private int packetSize;
    private short payloadType;
    private ConnectionDeviceIDTypes connectionDeviceIDType;
    private int connectionCallID;
    List<FloatingField> floatingFields = new ArrayList<>();


    //Constructors
    public RtpStartedEvent() {
        super(CTI.MSG_RTP_STARTED_EVENT);
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

    public short getRtpType() {
        return rtpType;
    }

    public void setRtpType(short rtpType) {
        this.rtpType = rtpType;
    }

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public short getEchoCancellation() {
        return echoCancellation;
    }

    public void setEchoCancellation(short echoCancellation) {
        this.echoCancellation = echoCancellation;
    }

    public int getPacketSize() {
        return packetSize;
    }

    public void setPacketSize(int packetSize) {
        this.packetSize = packetSize;
    }

    public short getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(short payloadType) {
        this.payloadType = payloadType;
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
            this.setMessageType(CTI.MSG_RTP_STARTED_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putInt(peripheralId)
                    .putInt(clientPort)
                    .putShort((short) direction.ordinal())
                    .putShort(rtpType)
                    .putInt(bitRate)
                    .putShort(echoCancellation)
                    .putInt(packetSize)
                    .putShort(payloadType)
                    .putShort((short) connectionDeviceIDType.getValue())
                    .putInt(connectionCallID);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_RTP_STARTED_EVENT serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RtpStartedEvent{");
        sb.append(super.toString());
        sb.append(", monitorId=").append(monitorId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", clientPort=").append(clientPort);
        sb.append(", direction=").append(direction);
        sb.append(", rtpType=").append(rtpType);
        sb.append(", bitRate=").append(bitRate);
        sb.append(", echoCancellation=").append(echoCancellation);
        sb.append(", packetSize=").append(packetSize);
        sb.append(", payloadType=").append(payloadType);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append(", floatingFields=").append(floatingFields);
        sb.append('}');
        return sb.toString();
    }
}
