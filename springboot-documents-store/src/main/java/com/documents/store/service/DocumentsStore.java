package com.documents.store.service;

import java.util.HashMap;
import java.util.Random;
import java.lang.StringBuilder;

public class DocumentsStore {
    private HashMap<String, String> docMap = new HashMap<String, String>();
    private String cls = "DocumentsStore";

    private String randomString(int len) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    // Function to handle 'PUT' request from client
    public String doPost(String val) {
        // Generate an ID (as a key) for the new document
        String id = randomString(20);
        System.out.println(cls + ".doPost() - add new data: '" + val + "' with the ID: '" + id + "'");
	docMap.put(id, val);
    	return id;
    }

    // Function to handle 'PUT' request from client
    public boolean doPut(String key, String val) {
        boolean result = true;
        System.out.println(cls + ".doPut() - update key: '" + key + " with value: '" + val + "'");
	if (docMap.containsKey(key)) {
           docMap.put(key, val);
	} else {
           result = false;
	}
	return result;
    }

    // Function to handle 'GET' request from the client
    public KeyValue doGet(String key) {
        String value = null;
        System.out.println(cls + ".doGet() - get document with key: '" + key + "'");
    	if (docMap.containsKey(key)) {   	   
           value = docMap.get(key);
    	} else {
     	   return null;
    	}
    	return new KeyValue(key, value);
    }

    // Function to handle 'DELETE' request from client
    public boolean doDelete(String key) {
        boolean result = true;
        System.out.println(cls + ".doDelete() - delete document: '" + key + "'");
    	if (docMap.containsKey(key)) {   	   
	   docMap.remove(key);
        } else {
           result = false;
        }
        return result;
    }

/**
    // Stand alone function to test functions in this class
    public static void main(String[] argv) {
    	DocumentsStore ds = new DocumentsStore(3);
    }
**/
}
