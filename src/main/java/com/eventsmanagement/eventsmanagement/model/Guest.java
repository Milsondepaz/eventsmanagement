package com.eventsmanagement.eventsmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Guest {

    private static final long SerialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Number cannot be empty")
    @Column(name = "idNumber")
    @Size(min=4, max=25, message="ID Number should be in between 4 to 25")
    private String idNumber;

    private String idDocument;

    @NotBlank(message = "Nameof is mandatory field")
    @Column(name = "name")
    @Size(min=4, max=25, message="Name should be in between 4 to 80")
    private String name;

    @ManyToOne
    private Event event;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
