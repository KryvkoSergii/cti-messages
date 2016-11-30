package ua.com.smiddle.cti.messages.model.messages.miscellaneous.calls;

import ua.com.smiddle.cti.messages.model.messages.agent_events.AgentStates;
import ua.com.smiddle.cti.messages.model.messages.common.FloatingField;
import ua.com.smiddle.cti.messages.model.messages.common.Header;
import ua.com.smiddle.cti.messages.model.messages.common.PeripheralTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public class BeginCallEvent extends Header {
    List<FloatingField> floatingFields = new ArrayList();
    private int monitorId;
    private int pheriperalID;
    private PeripheralTypes peripheralType;
    private short numCTIClients;
    private short numNamedVariables;
    private short NumNamedArrays;
    private CallTypes callType;
    private ConnectionDeviceIDTypes connectionDeviceIDType;
    private int connectionCallID;
    private short calledPartyDisposition;

    public BeginCallEvent() {
        super(messageType);
    }

    private AgentStates agentState;
    private short agentWorkMode;
    private short numSkillsGroups;
    private short eventReasonCode;
    private char forsedFlag;
    private int agentServiceReq;
}
