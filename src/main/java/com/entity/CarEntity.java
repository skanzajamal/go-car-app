package com.entity;

import com.enumeration.CarStatus;
import com.enumeration.EngineType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String licensePlate;

    @Column
    @NotNull
    private Integer seatCount;

    @Column
    private Boolean convertible;

    @Column
    private Integer rating;

    @Enumerated(EnumType.STRING)
    @Column
    private EngineType engineType;

    @Enumerated(EnumType.STRING)
    @Column
    private CarStatus carStatus;

    @Column(nullable = false)
    private String manufacturer;

} //ENDCLASS
