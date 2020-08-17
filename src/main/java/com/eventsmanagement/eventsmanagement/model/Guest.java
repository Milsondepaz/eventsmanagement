package com.eventsmanagement.eventsmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Guest implements Serializable {

    private static final long SerialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;

    @NotNull
    @NotEmpty(message="required field")
    private String idNumber;

    private String idDocument;

    @NotNull
    @NotEmpty(message="required field")
    @Size(min=5, max=30, message="length should be min 8 characters")
    private String nome;

    @ManyToOne
    private Event event;



}
