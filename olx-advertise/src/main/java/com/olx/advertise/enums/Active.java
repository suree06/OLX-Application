package com.olx.advertise.enums;

public enum Active {
    YES(0), NO(1);

    private int value;

    Active(int value) {
    	this.value = value; 
    	}

    public int getValue() {
    	return value; 
    	}
}
