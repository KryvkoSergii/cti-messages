package ua.com.smiddle.cti.messages.model.messages;

/**
 * Added by A.Osadchuk on 23.08.2016 at 10:36.
 * Project: SmiddleRecording
 */
public abstract class CTI {
    //Protocol version
    public final static int PROTOCOL_VERSION = 15;


    //Maximum message length
    /**
     * Max possible message length including MHDR
     */
    public final static int MAX_MSG_LENGTH = 4329;


    //Special values
    /**
     * No skill group is supplied.
     */
    public final static int SPEC_NULL_SKILL_GROUP = 0xFFFFFFFF;


    //Message types
    /**
     * Negative confirmation may be sent in response to any request.
     */
    public final static int MSG_FAILURE_CONF = 1;
    /**
     * Unsolicited notification of a failure or error.
     */
    public final static int MSG_FAILURE_EVENT = 2;
    /**
     * Communication session establishment request.
     */
    public final static int MSG_OPEN_REQ = 3;
    /**
     * Communication session establishment confirmation.
     */
    public final static int MSG_OPEN_CONF = 4;
    /**
     * Communication session maintenance request.
     */
    public final static int MSG_HEARTBEAT_REQ = 5;
    /**
     * Communication session maintenance confirmation.
     */
    public final static int MSG_HEARTBEAT_CONF = 6;
    /**
     * Communication session termination request.
     */
    public final static int MSG_CLOSE_REQ = 7;
    /**
     * Communication session termination confirmation.
     */
    public final static int MSG_CLOSE_CONF = 8;
    /**
     * Notification of inbound call arrival.
     */
    public final static int CALL_DELIVERED_EVENT= 9;
    /**
     * Notification of answering of inbound call.
     */
    public final static int CALL_ESTABLISHED_EVENT = 10;
    /**
     * Notification of call placed on hold.
     */
    public final static int CALL_HELD_EVENT = 11;
    /**
     * Notification of call taken off hold.
     */
    public final static int CALL_RETRIEVED_EVENT = 12;
    /**
     * Notification of call termination.
     */
    public final static int CALL_CLEARED_EVENT = 13;
    /**
     * Notification of the termination of a conference party connection.
     */
    public final static int CALL_CONNECTION_CLEARED_EVENT = 14;
    /**
     * Notification of outbound call initiation.
     */
    public final static int CALL_ORIGINATED_EVENT = 15;
    /**
     * Notification of inability to complete call.
     */
    public final static int CALL_FAILED_EVENT = 16;
    /**
     * Notification of tandem connection of two calls.
     */
    public final static int CALL_CONFERENCED_EVENT = 17;
    /**
     * Notification of call transfer.
     */
    public final static int CALL_TRANSFERRED_EVENT = 18;
    /**
     * Notification of call changing to a different service.
     */
    public final static int CALL_DIVERTED_EVENT = 19;
    /**
     * Notification of the initiation of telecommunications service at a device (“dial-tone”).
     */
    public final static int CALL_SERVICE_INITIATED_EVENT = 20;
    /**
     * Notification of call being placed in a queue pending the availability of some resource.
     */
    public final static int CALL_QUEUED_EVENT = 21;
    /**
     * Notification of call context data for a call that has been routed to the peripheral via a translation route.
     */
    public final static int CALL_TRANSLATION_ROUTE_EVENT = 22;
    /**
     * Notification that a call has been associated with the CTI client.
     */
    public final static int BEGIN_CALL_EVENT = 23;
    /**
     * Notification that a call is no longer associated with a CTI client.
     */
    public final static int END_CALL_EVENT = 24;
    /**
     * Notification of a change in a call’s context data.
     */
    public final static int CALL_DATA_UPDATE_EVENT = 25;
    /**
     * Request to update one or more call variables or call wrap-up data.
     */
    public final static int SET_CALL_DATA_REQ = 26;
    /**
     * Response confirming a previous SET_CALL_DATA request.
     */
    public final static int SET_CALL_DATA_CONF = 27;
    /**
     * Notification that all call data updates are complete.
     */
    public final static int RELEASE_CALL_REQ = 28;
    /**
     * Response confirming a previous RELEASE_CALL request.
     */
    public final static int RELEASE_CALL_CONF = 29;
    /**
     * Notification of new agent state.
     */
    public final static int MSG_AGENT_STATE_EVENT = 30;
    /**
     * Notification of a PG Status change.
     */
    public final static int MSG_SYSTEM_EVENT = 31;
    /**
     * Request to report a CTI client event.
     */
    public final static int MSG_CLIENT_EVENT_REPORT_REQ = 32;
    /**
     * Response confirming a CLIENT_EVENT_REPORT request.
     */
    public final static int MSG_CLIENT_EVENT_REPORT_CONF = 33;
    /**
     * Response indicating the failure of a proceeding control request.
     */
    public final static int MSG_CONTROL_FAILURE_CONF = 35;
    /**
     * Request to obtain the current state of an agent position.
     */
    public final static int MSG_QUERY_AGENT_STATE_REQ = 36;
    /**
     * Response to a QUERY_AGENT_ STATE request.
     */
    public final static int MSG_QUERY_AGENT_STATE_CONF = 37;
    /**
     * Request to alter the current state of an agent position.
     */
    public final static int MSG_SET_AGENT_STATE_REQ = 38;
    /**
     * Response confirming a previous SET_AGENT_STATE request.
     */
    public final static int MSG_SET_AGENT_STATE_CONF = 39;
    /**
     * Request to obtain information about a specified call.
     */
    public final static int MSG_SNAPSHOT_CALL_REQ = 82;
    /**
     * Response to a previous SNAPSHOT_CALL request.
     */
    public final static int MSG_SNAPSHOT_CALL_CONF = 83;
    /**
     * Request to obtain information about a specified device.
     */
    public final static int MSG_SNAPSHOT_DEVICE_REQ = 84;
    /**
     * Response to a previous SNAPSHOT_DEVICE request.
     */
    public final static int MSG_SNAPSHOT_DEVICE_CONF = 85;
    /**
     * Use this message to create a new monitor for the given call or device.
     */
    public final static int MSG_MONITOR_START_REQ = 93;
    /**
     * Response to a previous MSG_MONITOR_START_REQ request.
     */
    public final static int MSG_MONITOR_START_CONF = 94;
    /**
     * Use this message to terminate a call or device monitor. .
     */
    public final static int MSG_MONITOR_STOP_REQ = 95;
    /**
     * Response to a previous MSG_MONITOR_STOP_REQ request.
     */
    public final static int MSG_MONITOR_STOP_CONF = 96;
    /**
     * Notification that a new CTI Client session has been opened.
     */
    public final static int MSG_CLIENT_SESSION_OPENED_EVENT = 99;
    /**
     * Notification that a CTI Client session has been terminated.
     */
    public final static int MSG_CLIENT_SESSION_CLOSED_EVENT = 100;
    /**
     * Once a supervisor CTI client session is opened, the CTIServer will send one or more
     * AGENT_TEAM_CONFIG_EVENT messages with the list of team members for that supervisor.
     */
    public final static int MSG_AGENT_TEAM_CONFIG_EVENT = 128;
    /**
     * Request to AGENT desktop settings.
     */
    public final static int MSG_AGENT_DESK_SETTINGS_REQ = 131;
    /**
     * Request to start monitoring an Agent Team.
     */
    public final static int MSG_MONITOR_AGENT_TEAM_START_REQ = 135;
    /**
     * Response to a previous MONITOR_AGENT_TEAM_START_REQ request.
     */
    public final static int MSG_MONITOR_AGENT_TEAM_START_CONF = 136;
    /**
     * Request to stop monitoring an Agent Team.
     */
    public final static int MSG_MONITOR_AGENT_TEAM_STOP_REQ = 137;
    /**
     * Response to a previous MONITOR_AGENT_TEAM_STOP_REQ request.
     */
    public final static int MSG_MONITOR_AGENT_TEAM_STOP_CONF = 138;
    /**
     * Report agent’s current state.
     */
    public final static int MSG_AGENT_INIT_REQ = 182;
    /**
     * Response to AGENT_INIT_REQ.
     */
    public final static int MSG_AGENT_INIT_RESP = 183;
    /**
     * no docs, from sniffing
     */
    public final static int MSG_CONFIG_REQUEST_KEY_EVENT = 230;
    /**
     * The CONFIG_KEY_EVENT message is sent by the CTI Server in response to
     * CONFIG_REQUEST_KEY_EVENT message. It will contain the configuration keys at the time of the
     * request. Note that if the CTI Server doesn’t support separate keys that it may respond with 4 identical keys
     * and it should send the message with no optional fields. Returning any key of all binary 0’s will indicate to
     * the client that particular configuration should be uploaded.
     */
    public final static int MSG_CONFIG_KEY_EVENT = 231;
    /**
     * The CONFIG_REQUEST_EVENT message may be sent by the client whenever it wants to check and
     * receive a particular configuration from the CTI Server. The CTI Server should respond by sending a
     * CONFIG_BEGIN_EVENT, CONFIG_xxx records, then a CONFIG_END block containing all records for
     * that configuration item.
     */
    public final static int MSG_CONFIG_REQUEST_EVENT = 232;
    /**
     * The CONFIG_BEGIN_EVENT signifies the beginning of configuration data (all of the same key) from the
     * CTI Server.
     */
    public final static int MSG_CONFIG_BEGIN_EVENT = 233;
    /**
     * no docs, from sniffing
     */
    public final static int MSG_CONFIG_END_EVENT = 234;
    /**
     * The CONFIG_SKILL_GROUP_EVENT message will be sent to indicate a Skill Group configuration
     * update. Please note that the Peripheral Number field is considered unique for all records. Two records sent
     * with matching Peripheral Numbers will be the considered the same record.
     */
    public final static int MSG_CONFIG_SKILL_GROUP_EVENT = 236;
    /**
     * The CONFIG_AGENT_EVENT message will be sent by the CTI Server to provide information
     * about Agent. Please note that the LoginID field is considered unique for all records. Two records sent with
     * matching LoginID’s will be the considered the same record.
     */
    public final static int MSG_CONFIG_AGENT_EVENT = 237;


    //Service masks
    /**
     * Not used
     */
    public final static int MASK_SERVICE_NOT = 0x00000000;
    /**
     * Client receives call and agent state change events associated with a specific ACD phone.
     */
    public final static int MASK_SERVICE_CLIENT_EVENTS = 0x00000001;
    /**
     * Client may modify call context data.
     */
    public final static int MASK_SERVICE_CALL_DATA_UPDATE = 0x00000002;
    /**
     * Client may control calls and agent states associated with a specific ACD phone.
     */
    public final static int MASK_SERVICE_CLIENT_CONTROL = 0x00000004;
    /**
     * Establishment and termination of this session cause corresponding Unified CCE Alarm events to be generated.
     */
    public final static int MASK_SERVICE_CONNECTION_MONITOR = 0x00000008;
    /**
     * Client receives all call and agent state change events(associated with any ACD phone).
     */
    public final static int MASK_SERVICE_ALL_EVENTS = 0x00000010;
    /**
     * Client may dynamically add and remove devices and/or calls that it wishes to receive call and agent state events for.
     */
    public final static int MASK_SERVICE_PERIPHERAL_MONITOR = 0x00000020;
    /**
     * Client receives notification when all other CTI client sessions are opened and closed, and may monitor the activity of other CTI client sessions.
     */
    public final static int MASK_SERVICE_CLIENT_MONITOR = 0x00000040;
    /**
     * Client may request supervisor services.
     */
    public final static int MASK_SERVICE_SUPERVISOR = 0x00000080;
    /**
     * Client identify itself as server application.
     */
    public final static int MASK_SERVICE_SERVER = 0x00000100;
    /**
     * Client may reporting/routing ARM(Agent Reporting And Management) messages.
     */
    public final static int MASK_SERVICE_AGENT_REPORTING = 0x00000400;
    /**
     * Client receives all task events.
     */
    public final static int MASK_SERVICE_ALL_TASK_EVENTS = 0x00000800;
    /**
     * Client receives monitored task events.
     */
    public final static int MASK_SERVICE_TASK_MONITOR = 0x00001000;
    /**
     * Client can change agent state only. Call control is not allowed. If a client requests for MASK_SERVICE_CLIENT_CONTROL, the server may grant this flag to indicate that only agent state change is allowed.
     */
    public final static int MASK_SERVICE_AGENT_STATE_CONTROL_ONLY = 0x00002000;

    //public final static int UNUSED = 0x00004000;
    /**
     * The client/server wishes to register and get resource state change requests
     */
    public final static int MASK_SERVICE_DEVICE_STATE_CONTROL = 0x00008000;
    /**
     * Requests that this client receive update notification events. (No data)
     */
    public final static int MASK_SERVICE_UPDATE_EVENTS = 0x00080000;
    /**
     * Request to suppress duplicate agent state events.
     */
    public final static int MASK_SERVICE_IGNORE_DUPLICATE_AGENT_EVENTS = 0x00100000;
    /**
     * Do not send confirmations for third party requests.
     */
    public final static int MASK_SERVICE_IGNORE_CONF = 0x00200000;
    /**
     * Request that events for non-ACD lines not be sent.(UCCE only)
     */
    public final static int MASK_SERVICE_ACD_LINE_ONLY = 0x00400000;
    /**
     * Causes all messages exchanged during the current session to be captured to a file for later analysis.
     */
    public final static int MASK_SERVICE_DEBUG = 0x80000000;


    //Call masks
    /**
     * Not used
     */
    public final static int MASK_CALL_NOT = 0x00000000;
    /**
     * Set when client wishes to receive MASK_CALL_DELIVERED_EVENT messages.
     */
    public final static int MASK_CALL_DELIVERED = 0x00000001;
    /**
     * Set when client wishes to receive MASK_CALL_QUEUED_EVENT messages.
     */
    public final static int MASK_CALL_QUEUED = 0x00000002;
    /**
     * Set when client wishes to receive MASK_CALL_ESTABLISHED_EVENT messages.
     */
    public final static int MASK_CALL_ESTABLISHED = 0x00000004;
    /**
     * Set when client wishes to receive MASK_CALL_HELD_ EVENT messages.
     */
    public final static int MASK_CALL_HELD = 0x00000008;
    /**
     * Set when client wishes to receive MASK_CALL_RETRIEVED_EVENT messages.
     */
    public final static int MASK_CALL_RETRIEVED = 0x00000010;
    /**
     * Set when client wishes to receive MASK_CALL_CLEARED_EVENT messages.
     */
    public final static int MASK_CALL_CLEARED = 0x00000020;
    /**
     * Set when client wishes to receive MASK_CALL_CONNECTION_CLEARED_EVENT messages.
     */
    public final static int MASK_CALL_CONNECTION_CLEARED = 0x00000040;
    /**
     * Set when client wishes to receive MASK_CALL_ORIGINATED_EVENT messages.
     */
    public final static int MASK_CALL_ORIGINATED = 0x00000080;
    /**
     * Set when client wishes to receive MASK_CALL_CONFERENCED_EVENT messages.
     */
    public final static int MASK_CALL_CONFERENCED = 0x00000100;
    /**
     * Set when client wishes to receive MASK_CALL_TRANSFERRED_EVENT messages.
     */
    public final static int MASK_CALL_TRANSFERRED = 0x00000200;
    /**
     * Set when client wishes to receive MASK_CALL_DIVERTED_EVENT messages.
     */
    public final static int MASK_CALL_DIVERTED = 0x00000400;
    /**
     * Set when client wishes to receive MASK_CALL_SERVICE_INITIATED_EVENT messages.
     */
    public final static int MASK_CALL_SERVICE_INITIATED = 0x00000800;
    /**
     * Set when client wishes to receive MASK_CALL_TRANSLATION_ROUTE_EVENT messages.
     */
    public final static int MASK_CALL_TRANSLATION_ROUTE = 0x00001000;
    /**
     * Set when client wishes to receive BEGIN_CALL_EVENT messages.
     */
    public final static int MASK_CALL_BEGIN = 0x00002000;
    /**
     * Set when client wishes to receive END_CALL_EVENT messages.
     */
    public final static int MASK_CALL_END = 0x00004000;
    /**
     * Set when client wishes to receive MASK_CALL_DATA_UPDATE_EVENT messages.
     */
    public final static int MASK_CALL_DATA_UPDATE = 0x00008000;
    /**
     * Set when client wishes to receive MASK_CALL_FAILED_EVENT messages.
     */
    public final static int MASK_CALL_FAILED = 0x00010000;
    /**
     * Set when client wishes to receive MASK_CALL_REACHED_NETWORK_EVENT messages.
     */
    public final static int MASK_CALL_REACHED_NETWORK = 0x00020000;
    /**
     * Set when client wished to receive MASK_CALL_DEQUEUED_EVENT messages.
     */
    public final static int MASK_CALL_DEQUEUED = 0x00040000;
    /**
     * Set when client wished to receive AGENT_PRE_CALL_EVENT messages.
     */
    public final static int MASK_CALL_AGENT_PRE_CALL = 0x00080000;
    /**
     * Set when client wished to receive AGENT_PRE_CALL_ABORT_EVENT messages.
     */
    public final static int MASK_CALL_AGENT_PRE_CALL_ABORT = 0x00100000;
    /**
     * Set when client wished to receive RTP_STARTED_EVENT messages.
     */
    public final static int MASK_CALL_RTP_STARTED = 0x00200000;
    /**
     * Set when client wished to receive RTP_STOPPED_EVENT messages.
     */
    public final static int MASK_CALL_RTP_STOPPED = 0x00400000;
    /**
     * Set when client wished to receive AGENT_TEAM_CONFIG_EVENT messages.
     */
    public final static int MASK_CALL_AGENT_TEAM_CONFIG = 0x00800000;
    /**
     * Set when client wishes to receive AGENT_LEGACY_PRE_CALL_EVENT messages.
     */
    public final static int MASK_CALL_AGENT_LEGACY_PRE_CALL = 0x01000000;
    /**
     * MASK_CALL_ATTRIBUTE_CHANGE_EVENT messages.
     */
    public final static int MASK_CALL_ATTRIBUTE_CHANGE = 0x02000000;
    /**
     * Reserved
     */
    //public final static int MASK_CALL_TERMINATION = 0x04000000;
    /**
     * Set when client wishes to receive MASK_CALL_AGENT_GREETING_EVENT messages.
     */
    public final static int MASK_CALL_AGENT_GREETING = 0x08000000;


    //AgentState masks
    /**
     * Not used
     */
    public final static int MASK_AGENT_NOT = 0x00000000;
    /**
     * Set when client wishes to receive “login” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_LOGIN = 0x00000001;
    /**
     * Set when client wishes to receive “logout” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_LOGOUT = 0x00000002;
    /**
     * Set when client wishes to receive “not ready” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_NOT_READY = 0x00000004;
    /**
     * Set when client wishes to receive “available” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_AVAILABLE = 0x00000008;
    /**
     * Set when client wishes to receive “talking” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_TALKING = 0x00000010;
    /**
     * Set when client wishes to receive “work not ready” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_WORK_NOT_READY = 0x00000020;
    /**
     * Set when client wishes to receive “work ready” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_WORK_READY = 0x00000040;
    /**
     * Set when client wishes to receive “busy other” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_BUSY_OTHER = 0x00000080;
    /**
     * Set when client wishes to receive “reserved” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_RESERVED = 0x00000100;
    /**
     * Set when client wishes to receive “hold” MASK_AGENT_STATE_EVENT messages.
     */
    public final static int MASK_AGENT_HOLD = 0x00000200;
}
