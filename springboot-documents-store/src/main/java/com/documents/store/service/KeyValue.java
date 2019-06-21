package com.documents.store.service;

public class KeyValue {
    String key;
    String value;

    KeyValue (String k, String v) {
       this.key = k;
       this.value = v;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
