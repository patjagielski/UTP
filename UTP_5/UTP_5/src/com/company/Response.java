package com.company;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Response extends Message {


    public Response(int a, priorities _priority, Requestor _creator, LocalDateTime _timeCreated) {
        super(a, _priority, _creator, _timeCreated);
    }

    @Override
    public String toString() {
        return "Message{" +
                "_a=" + _a +
                ", _priority=" + _priority +
                ", _creator=" + _creator +
                ", _timeCreated=" + _timeCreated +
                '}';
    }
}
