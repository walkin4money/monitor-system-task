package com.example.monitorsystemtask.service.serviceImpl;

import com.example.monitorsystemtask.entity.SensorEntity;
import com.example.monitorsystemtask.exception.SensorNotFoundException;
import com.example.monitorsystemtask.repository.SensorRepository;
import com.example.monitorsystemtask.service.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    SensorRepository sensorRepository;
    ModelMapper modelMapper;
    @Override
    public List<SensorEntity> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public SensorEntity getOneSensor(Integer id){
        return sensorRepository.findById(id).orElseThrow(()->new SensorNotFoundException(String.format("Sensor with id %d was not found",id)));
    }

    @Override
    public void createSensor(SensorEntity sensorEntity) {
       sensorRepository.save(sensorEntity);
    }

    @Override
    public void deleteSensor(Integer id) {
        sensorRepository.findById(id).orElseThrow(()->new SensorNotFoundException(String.format("Sensor with id %d was not found",id)));
        sensorRepository.deleteById(id);
    }
    @Override
    public void updateSensor(Integer id,SensorEntity sensorUpdatedEntity) {
        SensorEntity sensorEntity = sensorRepository.findById(id).orElseThrow(()->new SensorNotFoundException(String.format("Sensor with id %d was not found",id)));
        sensorUpdatedEntity.setId(sensorEntity.getId());
       sensorRepository.save(sensorUpdatedEntity);
    }

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository, ModelMapper modelMapper) {
        this.sensorRepository = sensorRepository;
        this.modelMapper = modelMapper;
    }

}
