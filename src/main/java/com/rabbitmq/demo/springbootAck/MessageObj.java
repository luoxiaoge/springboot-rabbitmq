package com.rabbitmq.demo.springbootAck;

public class MessageObj {

    private Boolean Ack;

    private  Integer id;

    private String name;

    private String value;

    public Boolean getAck() {
        return Ack;
    }

    public void setAck(Boolean ack) {
        Ack = ack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
