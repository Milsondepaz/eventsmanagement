package com.eventsmanagement.eventsmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Event {

    private static final long SerialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@NotBlank(message = "Name of Event is mandatory")
    //@Column(name = "name")
    //@Size(min=4, max=100, message="ID Number should be in between 4 to 100")
    private String name;

    //@NotBlank(message = "Local cannot be empty")
    //@Column(name = "local")
    //@Size(min=4, max=100, message="ID Number should be in between 4 to 100")
    private String local;

    //@NotBlank(message = "Data cannot be empty")
    //@Column(name = "data")
    private String data;

    //@NotBlank(message = "Time is mandatory")
    //@Column(name = "time")
    private String time;

    @OneToMany
    public List<Guest> guestList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
