package com.example.monitorsystemtask.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="sensor_unit")
public class SensorUnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name",length = 40,nullable = false)
    String name;
}
