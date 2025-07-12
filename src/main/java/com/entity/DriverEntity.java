package com.entity;

import com.enumeration.DriverStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "driver")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int driverId;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DriverStatus status;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @OneToOne
    private CarEntity car;

} //ENDCLASS
