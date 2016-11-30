package ua.com.smiddle.cti.messages.model.messages.miscellaneous.calls;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public enum CallTypes {
    CALLTYPE_UNKNOWN {
        private final int value = 0;
        private final String msg = "Unknown call type";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_ACD_IN {
        private final int value = 1;
        private final String msg = "Inbound ACD call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_PREROUTE_ACD_IN {
        private final int value = 2;
        private final String msg = "Translation routed inbound ACD call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_PREROUTE_DIRECT_AGENT {
        private final int value = 3;
        private final String msg = "Translation routed call to a specific agent";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_TRANSFER_IN {
        private final int value = 4;
        private final String msg = "Transferred inbound call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_OVERFLOW_IN {
        private final int value = 5;
        private final String msg = "Overflowed inbound call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_OTHER_IN {
        private final int value = 6;
        private final String msg = "Inbound call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_AUTO_OUT {
        private final int value = 7;
        private final String msg = "Automatic out call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_AGENT_OUT {
        private final int value = 8;
        private final String msg = "Agent out call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_OUT {
        private final int value = 9;
        private final String msg = "Outbound call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_AGENT_INSIDE {
        private final int value = 10;
        private final String msg = "Agent inside call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_OFFERED {
        private final int value = 11;
        private final String msg = "Blind transferred call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_CONSULT {
        private final int value = 12;
        private final String msg = "Consult call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_CONSULT_OFFERRED {
        private final int value = 13;
        private final String msg = "Announced transferred call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_CONSULT_CONFERENCE {
        private final int value = 14;
        private final String msg = "Conferenced consult call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_CONFERENCE {
        private final int value = 15;
        private final String msg = "Conference call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_UNMONITORED {
        private final int value = 16;
        private final String msg = "Inside or outbound call for which no call events will be received";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_PREVIEW {
        private final int value = 17;
        private final String msg = "Automatic out call in which the agent is given the option to proceed to dial a contact";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_RESERVATION {
        private final int value = 18;
        private final String msg = "Call made to reserve an agent for some other function";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_ASSIST {
        private final int value = 19;
        private final String msg = "Call to supervisor for assistance";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_EMERGENCY {
        private final int value = 20;
        private final String msg = "Emergency call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_SUPERVISOR_MONITOR {
        private final int value = 21;
        private final String msg = "Supervisor silently monitoring call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_SUPERVISOR_WHISPER {
        private final int value = 22;
        private final String msg = "Supervisor monitoring call, agent can hear supervisor";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_SUPERVISOR_BARGEIN {
        private final int value = 23;
        private final String msg = "Supervisor conferenced into call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_SUPERVISOR_INTERCEPT {
        private final int value = 24;
        private final String msg = "Supervisor replaces agent on call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_TASK_ROUTED_BY_ICM {
        private final int value = 25;
        private final String msg = "Task routed by Unified CCE";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_TASK_ROUTED_BY_APPLICATION {
        private final int value = 26;
        private final String msg = "Task routed by application";

        public String getDescription() {
            return msg;
        }
    },

    //    CALLTYPE_NON_ACD {private final int value = 27; private final String msg ="Agent call that is a non-ACD routed call";public String getDescription() {return msg;}},

    RESERVATION_PREVIEW {
        private final int value = 27;
        private final String msg = "Call type for Outbound Option Reservation calls for Preview mode";

        public String getDescription() {
            return msg;
        }
    },
    RESERVATION_PREVIEW_DIRECT {
        private final int value = 28;
        private final String msg = "Call type for Outbound Option Reservation calls for Direct Preview mode";

        public String getDescription() {
            return msg;
        }
    },
    RESERVATION_PREDICTIVE {
        private final int value = 29;
        private final String msg = "Call type for Outbound Option Reservation calls for Predictive mode and Progressive mode";

        public String getDescription() {
            return msg;
        }
    },
    RESERVATION_CALLBACK {
        private final int value = 30;
        private final String msg = "Call type for Outbound Option Reservation calls for Callback calls";

        public String getDescription() {
            return msg;
        }
    },
    RESERVATION_PERSONAL_CALLBACK {
        private final int value = 31;
        private final String msg = "Call type for Outbound Option Reservation calls for Personal Callback calls";

        public String getDescription() {
            return msg;
        }
    },
    CUSTOMER_PREVIEW {
        private final int value = 32;
        private final String msg = "Call type for Outbound Option Customer calls for Preview mode";

        public String getDescription() {
            return msg;
        }
    },
    CUSTOMER_PREVIEW_DIRECT {
        private final int value = 33;
        private final String msg = "Call type for Outbound Option Customer calls for Direct Preview";

        public String getDescription() {
            return msg;
        }
    },
    CUSTOMER_PREDICTIVE {
        private final int value = 34;
        private final String msg = "Call type for Outbound Option Customer calls for Predictive mode and Progreassive modefor agentbased campaigns";

        public String getDescription() {
            return msg;
        }
    },
    CUSTOMER_CALLBACK {
        private final int value = 35;
        private final String msg = "Call type for Outbound Option Customer calls for callback calls";

        public String getDescription() {
            return msg;
        }
    },
    CUSTOMER_PERSONAL {
        private final int value = 36;
        private final String msg = "Call type for Outbound Option Customer calls for personal callback calls";

        public String getDescription() {
            return msg;
        }
    },
    CUSTOMER_IVR {
        private final int value = 37;
        private final String msg = "Call type for Outbound Option Customer calls for Transfer to IVR campaigns";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_NON_ACD {
        private final int value = 38;
        private final String msg = "Agent call that is a non-ACD call";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_PLAY_AGENT_GREETING {
        private final int value = 39;
        private final String msg = "An agent greeting route request";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_RECORD_AGENT_GREETING {
        private final int value = 40;
        private final String msg = "Record agent greeting call initiated by AGENT_GREETING_CONTROL_REQ";

        public String getDescription() {
            return msg;
        }
    },
    CALLTYPE_VOICE_CALL_BACK {
        private final int value = 41;
        private final String msg = "Voice callback using the Agent Request API";

        public String getDescription() {
            return msg;
        }
    };


    //Methods
    public abstract String getDescription();

    public static CallTypes getType(int mask) {
        for (CallTypes code : CallTypes.values()) {
            if (code.ordinal() == mask) return code;
        }
        return CALLTYPE_UNKNOWN;
    }

    public static short getValue(CallTypes type) {
        return (short) type.ordinal();
    }
}
