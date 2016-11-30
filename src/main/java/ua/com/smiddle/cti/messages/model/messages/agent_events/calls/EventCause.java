package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public enum EventCause {
    CEC_NONE {
        private final int value = 0xffff;

        public int getValue() {
            return value;
        }
    },
    CEC_ACTIVE_MONITOR {
        private final int value = 1;

        public int getValue() {
            return value;
        }
    },
    CEC_ALTERNATE {
        private final int value = 2;

        public int getValue() {
            return value;
        }
    },
    CEC_BUSY {
        private final int value = 3;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_BACK {
        private final int value = 4;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_CANCELLED {
        private final int value = 5;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_FORWARD_ALWAYS {
        private final int value = 6;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_FORWARD_BUSY {
        private final int value = 7;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_FORWARD_NO_ANSWER {
        private final int value = 8;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_FORWARD {
        private final int value = 9;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_NOT_ANSWERED {
        private final int value = 10;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_PICKUP {
        private final int value = 11;

        public int getValue() {
            return value;
        }
    },
    CEC_CAMP_ON {
        private final int value = 12;

        public int getValue() {
            return value;
        }
    },
    CEC_DEST_NOT_OBTAINABLE {
        private final int value = 13;

        public int getValue() {
            return value;
        }
    },
    CEC_DO_NOT_DISTURB {
        private final int value = 14;

        public int getValue() {
            return value;
        }
    },
    CEC_INCOMPATIBLE_DESTINATION {
        private final int value = 15;

        public int getValue() {
            return value;
        }
    },
    CEC_INVALID_ACCOUNT_CODE {
        private final int value = 16;

        public int getValue() {
            return value;
        }
    },
    CEC_KEY_CONFERENCE {
        private final int value = 17;

        public int getValue() {
            return value;
        }
    },
    CEC_LOCKOUT {
        private final int value = 18;

        public int getValue() {
            return value;
        }
    },
    CEC_MAINTENANCE {
        private final int value = 19;

        public int getValue() {
            return value;
        }
    },
    CEC_NETWORK_CONGESTION {
        private final int value = 20;

        public int getValue() {
            return value;
        }
    },
    CEC_NETWORK_NOT_OBTAINABLE {
        private final int value = 21;

        public int getValue() {
            return value;
        }
    },
    CEC_NO_AVAILABLE_AGENTS {
        private final int value = 23;

        public int getValue() {
            return value;
        }
    },
    CEC_OVERRIDE {
        private final int value = 24;

        public int getValue() {
            return value;
        }
    },
    CEC_PARK {
        private final int value = 25;

        public int getValue() {
            return value;
        }
    },
    CEC_OVERFLOW {
        private final int value = 26;

        public int getValue() {
            return value;
        }
    },
    CEC_RECALL {
        private final int value = 27;

        public int getValue() {
            return value;
        }
    },
    CEC_REDIRECTED {
        private final int value = 28;

        public int getValue() {
            return value;
        }
    },
    CEC_REORDER_TONE {
        private final int value = 29;

        public int getValue() {
            return value;
        }
    },
    CEC_RESOURCES_NOT_AVAILABLE {
        private final int value = 30;

        public int getValue() {
            return value;
        }
    },
    CEC_SILENT_MONITOR {
        private final int value = 31;

        public int getValue() {
            return value;
        }
    },
    CEC_TRANSFER {
        private final int value = 32;

        public int getValue() {
            return value;
        }
    },
    CEC_TRUNKS_BUSY {
        private final int value = 33;

        public int getValue() {
            return value;
        }
    },
    CEC_VOICE_UNIT_INITIATOR {
        private final int value = 34;

        public int getValue() {
            return value;
        }
    },
    CEC_TIME_OUT {
        private final int value = 35;

        public int getValue() {
            return value;
        }
    },
    CEC_NEW_CALL_INTERFLOW {
        private final int value = 36;

        public int getValue() {
            return value;
        }
    },
    CEC_SIMULATION_INIT_REQUEST {
        private final int value = 37;

        public int getValue() {
            return value;
        }
    },
    CEC_SIMULATION_RESET_REQUEST {
        private final int value = 38;

        public int getValue() {
            return value;
        }
    },
    CEC_CTI_LINK_DOWN {
        private final int value = 39;

        public int getValue() {
            return value;
        }
    },
    CEC_PERIPHERAL_RESET_REQUEST {
        private final int value = 40;

        public int getValue() {
            return value;
        }
    },
    CEC_MD110_CONFERENCE_TRANSFER {
        private final int value = 41;

        public int getValue() {
            return value;
        }
    },
    CEC_REMAINS_IN_Q {
        private final int value = 42;

        public int getValue() {
            return value;
        }
    },
    CEC_SUPERVISOR_ASSIST {
        private final int value = 43;

        public int getValue() {
            return value;
        }
    },
    CEC_EMERGENCY_CALL {
        private final int value = 44;

        public int getValue() {
            return value;
        }
    },
    CEC_SUPERVISOR_CLEAR {
        private final int value = 45;

        public int getValue() {
            return value;
        }
    },
    CEC_SUPERVISOR_MONITOR {
        private final int value = 46;

        public int getValue() {
            return value;
        }
    },
    CEC_SUPERVISOR_WHISPER {
        private final int value = 47;

        public int getValue() {
            return value;
        }
    },
    CEC_SUPERVISOR_BARGE_IN {
        private final int value = 48;

        public int getValue() {
            return value;
        }
    },
    CEC_SUPERVISOR_INTERCEPT {
        private final int value = 49;

        public int getValue() {
            return value;
        }
    },
    CEC_CALL_PARTY_UPDATE_IND {
        private final int value = 50;

        public int getValue() {
            return value;
        }
    },
    CEC_CONSULT {
        private final int value = 51;

        public int getValue() {
            return value;
        }
    },
    CEC_NIC_CALL_CLEAR {
        private final int value = 52;

        public int getValue() {
            return value;
        }
    };


    //Methods
    public abstract int getValue();

    public static EventCause getCause(int mask) {
        for (EventCause code : EventCause.values()) {
            if (code.getValue() == mask) return code;
        }
        return CEC_NONE;
    }
}
