package com.company;

import java.time.LocalDateTime;
import java.util.*;

enum priorities {
    High,
    Medium,
    Low
}public class Request extends Message {
    private static int _id = 0;
    private int _a = 0;
    private int _b = 0;
    private int lastId = _id++;


    public Request( int a, int b, priorities priority, Requestor creator, LocalDateTime timeCreated) {
        super(a, b, priority, creator, timeCreated);
    }



    @Override
    public String toString() {
        return "Request{" +
                "_a=" + _a +
                ", _b=" + _b +
                ", lastId=" + lastId + _creator+ get_priority() +
                '}';
    }
}
