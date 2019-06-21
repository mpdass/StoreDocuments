package com.documents.store.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentsStoreServiceController {
    private String cls = "DocumentsStoreServiceController";
    private DocumentsStore ds = new DocumentsStore();

    @RequestMapping(path = "storage/documents/", method = RequestMethod.POST)
    public ResponseEntity<Object> createDocument (@RequestBody String value) {        
    	System.out.println(cls + ".addData() - processing post value: '" + value + "'");
        String docId = ds.doPost(value);
        if (docId != null) {	//   Put has evicted the tail
           return ResponseEntity.ok().body("201 Created\nContent-Type: text/plain; charset=us-ascii Content-Length: " + value.length() + "\n" + docId + "\n");
        } else {
           return ResponseEntity.ok().body("500 - Internal Error Occurred\n");
        }
    }

    @RequestMapping(path = "storage/documents/{docId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDocument (@PathVariable String docId) {
        System.out.println(cls + ".getData() - processing get for docId: '" + docId + "'");
        KeyValue kv = ds.doGet(docId);
	String cont = kv.getValue();
        if (kv != null) {
           return ResponseEntity.ok().body("200 OK\nContent-Length: " + cont.length() + "\n" + kv.getValue() + "\n");
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - " + docId + ": Not Found\n");
        }
    }

    @RequestMapping(path = "storage/documents/{docId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDocument (@PathVariable String docId, @RequestBody String value) {        
        boolean result;
    	System.out.println(cls + ".updateData() - processing put for docId: '" + docId + "', value: '" + value + "'");
        result = ds.doPut(docId, value);
	if (result) {
           return ResponseEntity.ok().body("204 No Content\n");
        } else {
           return ResponseEntity.ok().body("404 Not Found\n");
        }
    }

    @RequestMapping(path = "storage/documents/{docId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDocument (@PathVariable String docId) {        
        boolean result = ds.doDelete(docId);
    	System.out.println(cls + ".deleteData() - processing delete for docId: '" + docId + "'");
        if (result) {
           return ResponseEntity.ok().body("204 No Content\n");
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - " + docId + ": Not Found\n");
        }
    }
}
