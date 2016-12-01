package ua.com.smiddle.cti.messages.model.messages.calls;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public class AnswerCallReq extends Header {
    private final static int FIXED_PART = 14;
    private final static int MAX_LENGTH = 154;
    List<FloatingField> floatingFields = new ArrayList();
    private int invokeId;
    private int peripheralId;
    private int connectionCallID;
    private ConnectionDeviceIDTypes connectionDeviceIDType;


    //Constructors
    public AnswerCallReq() {
        super(CTI.MSG_ANSWER_CALL_REQ);
    }


    //Getters and setters
    public List<FloatingField> getFloatingFields() {
        return floatingFields;
    }

    public void setFloatingFields(List<FloatingField> floatingFields) {
        this.floatingFields = floatingFields;
    }

    public int getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(int invokeId) {
        this.invokeId = invokeId;
    }

    public int getPeripheralId() {
        return peripheralId;
    }

    public void setPeripheralId(int peripheralId) {
        this.peripheralId = peripheralId;
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
            this.setMessageType(CTI.MSG_ANSWER_CALL_REQ);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(invokeId)
                    .putInt(peripheralId)
                    .putInt(connectionCallID)
                    .putShort((short) connectionDeviceIDType.getValue());
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_ANSWER_CALL_REQ serialization!");
        }
    }

    public static AnswerCallReq deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        AnswerCallReq message = new AnswerCallReq();
        try {
            message.setMessageLength(buffer.getInt());
            message.setMessageType(buffer.getInt());
            message.setInvokeId(buffer.getInt());
            message.setPeripheralId(buffer.getInt());
            message.setConnectionCallID(buffer.getInt());
            message.setConnectionDeviceIDType(ConnectionDeviceIDTypes.getType(Short.toUnsignedInt(buffer.getShort())));
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
        sb.append(", invokeId=").append(invokeId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", floatingFields=").append(floatingFields);
        sb.append('}');
        return sb.toString();
    }
}
