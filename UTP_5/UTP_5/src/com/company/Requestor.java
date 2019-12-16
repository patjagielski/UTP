package com.company;

import javafx.scene.layout.Priority;

import java.time.LocalDateTime;
import java.util.*;

public class Requestor implements Runnable {
    private static int RID;
    private int id = RID++;
    private static int a;
    private static int b;
    //creates random for the enum
    private static final Random random = new Random();
    PriorityQueue<Message> MyQueue;
    PriorityQueue<Message> GeneralQueue;

    public Requestor(PriorityQueue<Message> MyQueue) {
        this.GeneralQueue = MyQueue;
        this.MyQueue = new PriorityQueue<>();
    }

    synchronized public void createRequest() {
        GeneralQueue.add(new Request(1, 2, priorities.values()[random.nextInt(priorities.values().length)], this, LocalDateTime.now()));
    }

    public void run() {
        while (true) {
            createRequest();
            while (true) {
                Response response = null;
                synchronized (MyQueue) {
                    response = (Response) MyQueue.poll();
                }
                if (response != null) {
                    System.out.println(response);
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Requestor{" +
                "id=" + id +
                '}';
    }
}
