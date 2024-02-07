package com.example.monitorsystemtask.entity;


import com.example.monitorsystemtask.exception.InvalidRangeException;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "sensor")
@Data
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name",length = 30,nullable = false)
    String name;
    @Column(name = "model",length = 15,nullable = false)
    String model;
    @Column(name = "rangeFrom",nullable = false)
    Integer rangeFrom;
    @Column(name = "rangeTo",nullable = false)
    Integer rangeTo;
    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false)
    SensorTypeEntity sensorTypeEntity;
    @ManyToOne
    @JoinColumn(name="unit_id",nullable = false)
    SensorUnitEntity sensorUnitEntity;
    @Column(name="location",length = 40)
    String location;
    @Column(name="description",length = 200)
    String description;
    public void setRangeTo(Integer rangeTo) {
        if(rangeTo > rangeFrom) {
            this.rangeTo = rangeTo;
        }else
            throw new InvalidRangeException("RangeFrom is greater than RangeTo");
    }

}
