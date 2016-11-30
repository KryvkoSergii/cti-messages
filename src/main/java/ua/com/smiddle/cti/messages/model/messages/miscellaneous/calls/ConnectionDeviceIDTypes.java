package ua.com.smiddle.cti.messages.model.messages.miscellaneous.calls;

/**
 * @author ksa on 30.11.16.
 * @project cti-messages
 */
public enum ConnectionDeviceIDTypes {
    CONNECTION_ID_NONE {
        private final int value = 0xffff;
        private final String msg = "No ConnectionDeviceID is provided";

        public String getDescription() {
            return msg;
        }

        @Override
        public int getValue() {
            return (short) value;
        }
    },
    CONNECTION_ID_STATIC {
        private final int value = 0;
        private final String msg = "The ConnectionDeviceID value is stable over time (between calls)";

        public String getDescription() {
            return msg;
        }

        @Override
        public int getValue() {
            return (short) value;
        }
    },
    CONNECTION_ID_DYNAMIC {
        private final int value = 1;
        private final String msg = "The ConnectionDeviceID value is dynamic and may change between calls";

        public String getDescription() {
            return msg;
        }

        @Override
        public int getValue() {
            return (short) value;
        }
    };

    //Methods
    public abstract String getDescription();

    public abstract int getValue();

    public static ConnectionDeviceIDTypes getType(int mask) {
        for (ConnectionDeviceIDTypes code : ConnectionDeviceIDTypes.values()) {
            if (code.getValue() == mask) return code;
        }
        return CONNECTION_ID_NONE;
    }

    public static short getValue(ConnectionDeviceIDTypes type) {
        return (short) type.getValue();
    }
}
