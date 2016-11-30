package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

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
public class AgentPreCallEvent extends Header {
    private final static int FIXED_PART = 30;
    private final static int MAX_LENGTH = 3303;
    List<FloatingField> floatingFields = new ArrayList<>();
    private int monitorId;
    private short numNamedVariables;
    private short numNamedArrays;
    private int serviceNumber;
    private int serviceID;
    private int skillGroupNumber;
    private int skillGroupID;
    private short skillGroupPriority;
    private int mrdid;


    //Constructors
    public AgentPreCallEvent() {
        super(CTI.MSG_AGENT_PRE_CALL_EVENT);
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

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getSkillGroupNumber() {
        return skillGroupNumber;
    }

    public void setSkillGroupNumber(int skillGroupNumber) {
        this.skillGroupNumber = skillGroupNumber;
    }

    public int getSkillGroupID() {
        return skillGroupID;
    }

    public void setSkillGroupID(int skillGroupID) {
        this.skillGroupID = skillGroupID;
    }

    public short getSkillGroupPriority() {
        return skillGroupPriority;
    }

    public void setSkillGroupPriority(short skillGroupPriority) {
        this.skillGroupPriority = skillGroupPriority;
    }

    public int getMrdid() {
        return mrdid;
    }

    public void setMrdid(int mrdid) {
        this.mrdid = mrdid;
    }


    //Methods
    public byte[] serializeMessage() throws Exception {
        try {
            this.setMessageLength(FIXED_PART + FloatingField.calculateFloatingPart(floatingFields));
            this.setMessageType(CTI.MSG_CALL_DATA_UPDATE_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putShort(numNamedVariables)
                    .putShort(numNamedArrays)
                    .putInt(serviceNumber)
                    .putInt(serviceID)
                    .putInt(skillGroupNumber)
                    .putInt(skillGroupID)
                    .putShort(skillGroupPriority)
                    .putInt(mrdid);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_CALL_DATA_UPDATE_EVENT serialization!");
        }
    }

    public static AgentPreCallEvent deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        AgentPreCallEvent message = new AgentPreCallEvent();
        try {
            message.setMessageLength(buffer.getInt());
            message.setMessageType(buffer.getInt());
            message.setMonitorId(buffer.getInt());
            message.setNumNamedVariables(buffer.getShort());
            message.setNumNamedArrays(buffer.getShort());
            message.setServiceNumber(buffer.getInt());
            message.setServiceID(buffer.getInt());
            message.setSkillGroupNumber(buffer.getInt());
            message.setSkillGroupID(buffer.getInt());
            message.setSkillGroupPriority(buffer.getShort());
            message.setMrdid(buffer.getInt());
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
        final StringBuilder sb = new StringBuilder("AgentPreCallEvent{");
        sb.append(super.toString());
        sb.append(", monitorId=").append(monitorId);
        sb.append(", numNamedVariables=").append(numNamedVariables);
        sb.append(", numNamedArrays=").append(numNamedArrays);
        sb.append(", serviceNumber=").append(serviceNumber);
        sb.append(", serviceID=").append(serviceID);
        sb.append(", skillGroupNumber=").append(skillGroupNumber);
        sb.append(", skillGroupID=").append(skillGroupID);
        sb.append(", skillGroupPriority=").append(skillGroupPriority);
        sb.append(", mrdid=").append(mrdid);
        sb.append(", floatingFields=").append(floatingFields);
        sb.append('}');
        return sb.toString();
    }
}
