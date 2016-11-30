package ua.com.smiddle.cti.messages.model.messages.agent_events.calls;

import java.io.Serializable;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public enum LineTypes implements Serializable {
    LINETYPE_INBOUND_ACD {
        private final int value = 0;
        private final String msg = "Line used for inbound ACD calls.";

        public String getDescription() {
            return msg;
        }

        public int getValue() {
            return value;
        }
    },
    LINETYPE_OUTBOUND_ACD {
        private final int value = 1;
        private final String msg = "Line used for outbound ACD calls.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_INSIDE {
        private final int value = 2;
        private final String msg = "Line used for inside calls.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_UNKNOWN {
        private final int value = 3;
        private final String msg = "Line used for any purpose.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_SUPERVISOR {
        private final int value = 4;
        private final String msg = "Line used for supervisor calls.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_MESSAGE {
        private final int value = 5;
        private final String msg = " Line used for voice messages.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_HELP {
        private final int value = 6;
        private final String msg = " Line used for assistance.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_OUTBOUND {
        private final int value = 7;
        private final String msg = " Line used for outbound non-ACD calls.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_DID {
        private final int value = 8;
        private final String msg = " Line used for direct inward dialed calls.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_SILENT_MONITOR {
        private final int value = 9;
        private final String msg = " Line used for silent monitor.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_NON_ACD_IN {
        private final int value = 10;
        private final String msg = " Line used for inbound non-ACD calls.";

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return msg;
        }
    },
    LINETYPE_NON_ACD_OUT {
        private final int value = 11;
        private final String msg = " Line used for outbound non-ACD calls.";

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

    public static LineTypes getType(int mask) {
        for (LineTypes code : LineTypes.values()) {
            if (code.ordinal() == mask) return code;
        }
        return LINETYPE_NON_ACD_OUT;
    }
}
