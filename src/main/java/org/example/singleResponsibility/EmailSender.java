package org.example.singleResponsibility;

public class EmailSender {
    public void send(String action, String receipt) {

        System.out.printf(action + " " + receipt);
    }
}
