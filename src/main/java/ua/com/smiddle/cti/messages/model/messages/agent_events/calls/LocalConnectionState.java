package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

import java.io.Serializable;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public enum LocalConnectionState implements Serializable {
    LCS_NONE {
        private final int value = 0xffff;
        private final String msg = "Not applicable";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LCS_NULL {
        private final int value = 0;
        private final String msg = "No relationship between call and device";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LCS_INITIATE {
        private final int value = 1;
        private final String msg = "Device requesting service (“dialing”).";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LCS_ALERTING {
        private final int value = 2;
        private final String msg = "Device is alerting (“ringing”).";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LCS_CONNECT {
        private final int value = 3;
        private final String msg = "Device is alerting (“ringing”).";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LCS_HOLD {
        private final int value = 4;
        private final String msg = "Device is inactively participating in the call.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LCS_QUEUED {
        private final int value = 5;
        private final String msg = "Device is stalled attempting to connect to a call, or a call is stalled attempting to connect to a device.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LCS_FAIL {
        private final int value = 6;
        private final String msg = "A device-to-call or call-to-device connection attempt has been aborted.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    };


    //Methods
    public abstract String getDescription();

    public abstract int getValue();

    public static LocalConnectionState getState(int mask) {
        for (LocalConnectionState code : LocalConnectionState.values()) {
            if (code.getValue() == mask) return code;
        }
        return LCS_NONE;
    }
}
