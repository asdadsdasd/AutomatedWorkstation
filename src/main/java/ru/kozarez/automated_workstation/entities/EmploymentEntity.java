package ru.kozarez.automated_workstation.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "work_period")
    private int workPeriod;

    @Column(name = "post")
    private String post;

    @Column(name = "organisation_name")
    private String organisationName;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
