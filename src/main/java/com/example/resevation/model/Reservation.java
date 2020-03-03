package com.example.resevation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(generator = "system.uuid")
    @GenericGenerator(name = "system.uuid", strategy = "uuid2")
    private String idReservation;
    @Temporal(TemporalType.DATE)
    private Date getIneDate;
    @Temporal(TemporalType.DATE)
    private Date getOutDate;
    private int peopleNumber;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
}
