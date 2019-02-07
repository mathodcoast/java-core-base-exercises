package com.mathodcoast.model;

import java.util.Arrays;



public class AnagramString {
    private String value;

    public AnagramString(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        AnagramString that = (AnagramString) obj;
        char[] chA = this.value.toCharArray();
        char[] chB = that.value.toCharArray();
        Arrays.sort(chA);
        Arrays.sort(chB);
        return Arrays.equals(chA,chB);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return value;
    }
}
