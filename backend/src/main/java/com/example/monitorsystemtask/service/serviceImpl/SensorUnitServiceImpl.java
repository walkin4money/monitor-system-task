package com.example.monitorsystemtask.service.serviceImpl;

import com.example.monitorsystemtask.entity.SensorUnitEntity;
import com.example.monitorsystemtask.repository.SensorUnitRepository;
import com.example.monitorsystemtask.service.SensorUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorUnitServiceImpl implements SensorUnitService {

    SensorUnitRepository sensorUnitRepository;
    @Override
    public List<SensorUnitEntity> getAllSensorUnits() {
        return sensorUnitRepository.findAll();
    }

    @Autowired
    public SensorUnitServiceImpl(SensorUnitRepository sensorUnitRepository){
       this.sensorUnitRepository = sensorUnitRepository;
    }
}
