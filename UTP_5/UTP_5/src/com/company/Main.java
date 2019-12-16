package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.naming.ldap.PagedResultsControl;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Message> pr = new PriorityQueue<>();
        for(int i = 0; i<5; i++) {
            new Thread(new Requestor(pr)).start();
        }
        for(int i = 0; i<5; i++) {
            new Thread(new Responder(pr)).start();
        }


    }

}
