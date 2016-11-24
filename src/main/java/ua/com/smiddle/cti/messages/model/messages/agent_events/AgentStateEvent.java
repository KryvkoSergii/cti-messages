package ua.com.smiddle.cti.messages.model.messages.agent_events;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;
import ua.com.smiddle.cti.messages.model.messages.common.PeripheralTypes;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Added by A.Osadchuk on 27.08.2016 at 17:15.
 * Project: SmiddleRecording
 */
public class AgentStateEvent extends Header {
    private final static int FIXED_PART = 58;
    List<FloatingField> floatingFields = new ArrayList<>(10);
    private int monitorId;
    private int peripheralId;
    private int sessionId;
    private PeripheralTypes peripheralType;
    private short skillGroupState;  //One of the values from Table 6-5 representing the current state of the associated agent with respect to the indicated Agent Skill Group.
    private int stateDuration;
    private int skillGroupNumber;   //May contain CTI.SPEC_NULL_SKILL_GROUP
    private int skillGroupId;       //May contain CTI.SPEC_NULL_SKILL_GROUP
    private short skillGroupPriority;
    private AgentStates agentState;       //One of the values from Table 6-5 representing the current overall state of the associated agent.
    private short eventReasonCode;
    private int mrdid;              //Media Routing Domain ID
    private int numTasks;
    private short agentMode;        //ROUTABLE = 0, NOT ROUTABLE = 1
    private int maxTaskLimit;
    private int agentIdICMA;
    private int agentAvailabilityStatus;    //NOT AVAILABLE = 0, ICM AVAILABLE = 1, APPLICATION AVAILABLE=2
    private short numFltSkillGroups;


    //Constructors
    public AgentStateEvent() {
        super(CTI.MSG_AGENT_STATE_EVENT);
    }


    //Methods
    public static AgentStateEvent deserializeMessage(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        AgentStateEvent message = new AgentStateEvent();
        try {
            message.setMessageLength(bytes.length);
            message.setMonitorId(buffer.getInt());
            message.setPeripheralId(buffer.getInt());
            message.setSessionId(buffer.getInt());
            message.setPeripheralType(PeripheralTypes.getType(Short.toUnsignedInt(buffer.getShort())));
            message.setSkillGroupState(buffer.getShort());
            message.setStateDuration(buffer.getInt());
            message.setSkillGroupNumber(buffer.getInt());
            message.setSkillGroupId(buffer.getInt());
            message.setSkillGroupPriority(buffer.getShort());
            message.setAgentState(AgentStates.getState(Short.toUnsignedInt(buffer.getShort())));
            message.setEventReasonCode(buffer.getShort());
            message.setMrdid(buffer.getInt());
            message.setNumTasks(buffer.getInt());
            message.setAgentMode(buffer.getShort());
            message.setMaxTaskLimit(buffer.getInt());
            message.setAgentIdICMA(buffer.getInt());
            message.setAgentAvailabilityStatus(buffer.getInt());
            message.setNumFltSkillGroups(buffer.getShort());
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

    //Getters & setters
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

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public short getSkillGroupState() {
        return skillGroupState;
    }

    public void setSkillGroupState(short skillGroupState) {
        this.skillGroupState = skillGroupState;
    }

    public int getStateDuration() {
        return stateDuration;
    }

    public void setStateDuration(int stateDuration) {
        this.stateDuration = stateDuration;
    }

    public int getSkillGroupNumber() {
        return skillGroupNumber;
    }

    public void setSkillGroupNumber(int skillGroupNumber) {
        this.skillGroupNumber = skillGroupNumber;
    }

    public int getSkillGroupId() {
        return skillGroupId;
    }

    public void setSkillGroupId(int skillGroupId) {
        this.skillGroupId = skillGroupId;
    }

    public short getSkillGroupPriority() {
        return skillGroupPriority;
    }

    public void setSkillGroupPriority(short skillGroupPriority) {
        this.skillGroupPriority = skillGroupPriority;
    }

    public AgentStates getAgentState() {
        return agentState;
    }

    public void setAgentState(AgentStates agentState) {
        this.agentState = agentState;
    }

    public short getEventReasonCode() {
        return eventReasonCode;
    }

    public void setEventReasonCode(short eventReasonCode) {
        this.eventReasonCode = eventReasonCode;
    }

    public int getMrdid() {
        return mrdid;
    }

    public void setMrdid(int mrdid) {
        this.mrdid = mrdid;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public short getAgentMode() {
        return agentMode;
    }

    public void setAgentMode(short agentMode) {
        this.agentMode = agentMode;
    }

    public int getMaxTaskLimit() {
        return maxTaskLimit;
    }

    public void setMaxTaskLimit(int maxTaskLimit) {
        this.maxTaskLimit = maxTaskLimit;
    }

    public int getAgentIdICMA() {
        return agentIdICMA;
    }

    public void setAgentIdICMA(int agentIdICMA) {
        this.agentIdICMA = agentIdICMA;
    }

    public int getAgentAvailabilityStatus() {
        return agentAvailabilityStatus;
    }

    public void setAgentAvailabilityStatus(int agentAvailabilityStatus) {
        this.agentAvailabilityStatus = agentAvailabilityStatus;
    }

    public short getNumFltSkillGroups() {
        return numFltSkillGroups;
    }

    public void setNumFltSkillGroups(short numFltSkillGroups) {
        this.numFltSkillGroups = numFltSkillGroups;
    }

    public List<FloatingField> getFloatingFields() {
        return floatingFields;
    }

    public void setFloatingFields(List<FloatingField> floatingFields) {
        this.floatingFields = floatingFields;
    }

    public PeripheralTypes getPeripheralType() {
        return peripheralType;
    }

    public void setPeripheralType(PeripheralTypes peripheralType) {
        this.peripheralType = peripheralType;
    }

    public byte[] serializeMessage() throws Exception {
        try {
            this.setMessageLength(FIXED_PART + FloatingField.calculateFloatingPart(floatingFields));
            this.setMessageType(CTI.MSG_AGENT_STATE_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putInt(peripheralId)
                    .putInt(sessionId)
                    .putShort((short) PeripheralTypes.getInt(peripheralType))
                    .putShort(skillGroupState)
                    .putInt(stateDuration)
                    .putInt(skillGroupNumber)
                    .putInt(skillGroupId)
                    .putShort(skillGroupPriority)
                    .putShort((short) AgentStates.setIntState(agentState))
                    .putShort(eventReasonCode)
                    .putInt(mrdid)
                    .putInt(numTasks)
                    .putShort(agentMode)
                    .putInt(maxTaskLimit)
                    .putInt(agentIdICMA)
                    .putInt(agentAvailabilityStatus)
                    .putShort(numFltSkillGroups);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_QUERY_AGENT_STATE_CONF serialization!");
        }
    }

    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" AgentStateEvent{").append(super.toString());
        sb.append(", monitorId=").append(monitorId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", peripheralType=").append(peripheralType);
        sb.append(", skillGroupState=").append(skillGroupState);
        sb.append(", stateDuration=").append(stateDuration);
        sb.append(", skillGroupNumber=").append(skillGroupNumber);
        sb.append(", skillGroupId=").append(skillGroupId);
        sb.append(", skillGroupPriority=").append(skillGroupPriority);
        sb.append(", agentState=").append(agentState);
        sb.append(", eventReasonCode=").append(eventReasonCode);
        sb.append(", mrdid=").append(mrdid);
        sb.append(", numTasks=").append(numTasks);
        sb.append(", agentMode=").append(agentMode);
        sb.append(", maxTaskLimit=").append(maxTaskLimit);
        sb.append(", agentIdICMA=").append(agentIdICMA);
        sb.append(", agentAvailabilityStatus=").append(agentAvailabilityStatus);
        sb.append(", numFltSkillGroups=").append(numFltSkillGroups);
        sb.append(", floatingFields=").append(Arrays.deepToString(floatingFields.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
