package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

import ua.com.smiddle.cti.messages.model.messages.CTI;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;
import ua.com.smiddle.cti.messages.model.messages.common.PeripheralTypes;
import ua.com.smiddle.cti.messages.model.messages.miscellaneous.EventDeviceTypes;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public class CallDeliveredEvent extends Header {
    private final static int FIXED_PART = 54;
    private final static int MAX_LENGTH = 400;
    private int monitorId;
    private int peripheralId;
    private PeripheralTypes peripheralType;
    private ConnectionDeviceIDTypes connectionDeviceIDType;
    private int connectionCallID;
    private short lineHandle;
    private LineTypes lineType;
    private int serviceNumber;
    private int serviceID;
    private int skillGroupNumber;
    private int skillGroupID;
    private short skillGroupPriority;
    private EventDeviceTypes alertingDeviceType;
    private EventDeviceTypes callingDeviceType;
    private EventDeviceTypes calledDeviceType;
    private EventDeviceTypes lastRedirectDeviceType;
    private LocalConnectionState localConnectionState;
    private EventCause eventCause;
    private short numNamedVariables;
    private short numNamedArrays;
    List<FloatingField> floatingFields = new ArrayList<>();


    //Constructors
    public CallDeliveredEvent() {
        super(CTI.MSG_CALL_DELIVERED_EVENT);
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

    public short getLineHandle() {
        return lineHandle;
    }

    public void setLineHandle(short lineHandle) {
        this.lineHandle = lineHandle;
    }

    public LineTypes getLineType() {
        return lineType;
    }

    public void setLineType(LineTypes lineType) {
        this.lineType = lineType;
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

    public EventDeviceTypes getAlertingDeviceType() {
        return alertingDeviceType;
    }

    public void setAlertingDeviceType(EventDeviceTypes alertingDeviceType) {
        this.alertingDeviceType = alertingDeviceType;
    }

    public EventDeviceTypes getCallingDeviceType() {
        return callingDeviceType;
    }

    public void setCallingDeviceType(EventDeviceTypes callingDeviceType) {
        this.callingDeviceType = callingDeviceType;
    }

    public EventDeviceTypes getCalledDeviceType() {
        return calledDeviceType;
    }

    public void setCalledDeviceType(EventDeviceTypes calledDeviceType) {
        this.calledDeviceType = calledDeviceType;
    }

    public EventDeviceTypes getLastRedirectDeviceType() {
        return lastRedirectDeviceType;
    }

    public void setLastRedirectDeviceType(EventDeviceTypes lastRedirectDeviceType) {
        this.lastRedirectDeviceType = lastRedirectDeviceType;
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
            this.setMessageType(CTI.MSG_CALL_DELIVERED_EVENT);
            ByteBuffer buffer = ByteBuffer.allocate(MHDR + this.getMessageLength())
                    .putInt(this.getMessageLength())
                    .putInt(this.getMessageType())
                    .putInt(monitorId)
                    .putInt(peripheralId)
                    .putShort((short) PeripheralTypes.getInt(peripheralType))
                    .putShort((short) connectionDeviceIDType.getValue())
                    .putInt(connectionCallID)
                    .putShort(lineHandle)
                    .putShort((short) lineType.getValue())
                    .putInt(serviceNumber)
                    .putInt(serviceID)
                    .putInt(skillGroupNumber)
                    .putInt(skillGroupID)
                    .putShort(skillGroupPriority)
                    .putShort((short) alertingDeviceType.getMask())
                    .putShort((short) callingDeviceType.getMask())
                    .putShort((short) calledDeviceType.getMask())
                    .putShort((short) lastRedirectDeviceType.getMask())
                    .putShort((short) localConnectionState.getValue())
                    .putShort((short) eventCause.getValue())
                    .putShort(numNamedVariables)
                    .putShort(numNamedArrays);
            for (FloatingField field : floatingFields) {
                field.serializeField(buffer);
            }
            return buffer.array();
        } catch (BufferOverflowException e) {
            throw new Exception("Buffer overflowed during MSG_CALL_DELIVERED_EVENT serialization!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CallDeliveredEvent{");
        sb.append(super.toString());
        sb.append(", monitorId=").append(monitorId);
        sb.append(", peripheralId=").append(peripheralId);
        sb.append(", peripheralType=").append(peripheralType);
        sb.append(", connectionDeviceIDType=").append(connectionDeviceIDType);
        sb.append(", connectionCallID=").append(connectionCallID);
        sb.append(", lineHandle=").append(lineHandle);
        sb.append(", lineType=").append(lineType);
        sb.append(", serviceNumber=").append(serviceNumber);
        sb.append(", serviceID=").append(serviceID);
        sb.append(", skillGroupNumber=").append(skillGroupNumber);
        sb.append(", skillGroupID=").append(skillGroupID);
        sb.append(", skillGroupPriority=").append(skillGroupPriority);
        sb.append(", alertingDeviceType=").append(alertingDeviceType);
        sb.append(", callingDeviceType=").append(callingDeviceType);
        sb.append(", calledDeviceType=").append(calledDeviceType);
        sb.append(", lastRedirectDeviceType=").append(lastRedirectDeviceType);
        sb.append(", localConnectionState=").append(localConnectionState);
        sb.append(", eventCause=").append(eventCause);
        sb.append(", numNamedVariables=").append(numNamedVariables);
        sb.append(", numNamedArrays=").append(numNamedArrays);
        sb.append(", floatingFields=").append(floatingFields);
        sb.append('}');
        return sb.toString();
    }
}
