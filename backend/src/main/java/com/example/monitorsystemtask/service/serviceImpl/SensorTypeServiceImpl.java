package com.example.monitorsystemtask.service.serviceImpl;

import com.example.monitorsystemtask.entity.SensorTypeEntity;
import com.example.monitorsystemtask.repository.SensorTypeRepository;
import com.example.monitorsystemtask.service.SensorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorTypeServiceImpl implements SensorTypeService {
    SensorTypeRepository sensorTypeRepository;
    @Override
    public List<SensorTypeEntity> getAllSensorTypes() {
        return sensorTypeRepository.findAll();
    }

    @Autowired
    public SensorTypeServiceImpl(SensorTypeRepository sensorTypeRepository){
        this.sensorTypeRepository = sensorTypeRepository;
    }
}
