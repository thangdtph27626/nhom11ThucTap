package com.thang.demo.entity;


    // Status.java
    public enum Status {
        ACTIVE("ACTIVE"),
        INACTIVE("INACTIVE"),
        PENDING("PENDING");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Status fromValue(String value) {
            for (Status status : values()) {
                if (status.getValue().equalsIgnoreCase(value)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid Status value: " + value);
        }
    }




