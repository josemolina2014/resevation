package com.example.resevation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
@Data

@NamedQuery(name = "Client.findByIdentification", query = "select c from Client c where c.identification= ?1")
public class Client {

    @Id
    @GeneratedValue(generator = "system.uuid")
    @GenericGenerator(name = "system.uuid", strategy = "uuid2")
    private String idClient;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String identification;
    @OneToMany(mappedBy = "client")
    private Set<Reservation> reserves;
}
