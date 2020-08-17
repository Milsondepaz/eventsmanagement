package com.eventsmanagement.eventsmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private static final long SeriVersionUID = 1;

    private long code;

    @NotNull
    @NotEmpty(message="required field")
    @Size(min=5, max=30, message="length should be min 2 characters")
    private String name;

    @NotNull
    @NotEmpty(message="required field")
    @Size(min=5, max=30, message="length should be min 2 characters")
    private String local;

    @NotNull
    @NotEmpty(message="required field")
    private String data;

    @NotNull
    @NotEmpty(message="required field")
    private String time;

    @OneToMany
    public List<Guest> guestList;


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
