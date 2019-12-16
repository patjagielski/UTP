package com.company;

import java.time.LocalDateTime;

public abstract class Message implements Comparable<Message>{
    protected int _a;
    protected int _b;
    protected priorities _priority;
    protected Requestor _creator;
    protected LocalDateTime _timeCreated;


    //Request template
    public Message(int a, int b, priorities priority, Requestor creator, LocalDateTime timeCreated){
        this._a = a;
        this._b = b;
        this._priority = priority;
        this._creator = creator;
        this._timeCreated = timeCreated;
    }

    //Response template
    public Message(int a, priorities _priority, Requestor _creator, LocalDateTime _timeCreated) {
        this._a = a;
        this._priority = _priority;
        this._creator = _creator;
        this._timeCreated = _timeCreated;
    }

    public int get_a() {
        return _a;
    }

    public int get_b() {
        return _b;
    }

    public priorities get_priority() {
        return _priority;
    }

    public Requestor get_creator() {
        return _creator;
    }

    public LocalDateTime get_timeCreated() {
        return _timeCreated;
    }
    @Override
    public int compareTo(Message o) {
       return this._priority.compareTo(o._priority);
    }

    @Override
    public String toString() {
        return "Message{" +
                "_a=" + _a +
                ", _b=" + _b +
                ", _priority=" + _priority +
                ", _creator=" + _creator +
                ", _timeCreated=" + _timeCreated +
                '}';
    }
}
