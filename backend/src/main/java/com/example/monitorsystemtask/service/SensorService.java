package com.example.monitorsystemtask.service;

import com.example.monitorsystemtask.entity.SensorEntity;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface SensorService  {
    List<SensorEntity> getAllSensors();
    SensorEntity getOneSensor (Integer id) throws ChangeSetPersister.NotFoundException;
    void createSensor(SensorEntity sensorEntity);
    void deleteSensor(Integer id);
    void updateSensor(Integer id,SensorEntity sensorEntity) throws ChangeSetPersister.NotFoundException;
}
