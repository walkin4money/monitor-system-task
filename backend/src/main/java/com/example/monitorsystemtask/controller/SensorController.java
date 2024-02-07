package com.example.monitorsystemtask.controller;


import com.example.monitorsystemtask.dto.ResponseDTO;
import com.example.monitorsystemtask.entity.SensorEntity;
import com.example.monitorsystemtask.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/sensors")
public class SensorController {
    SensorService sensorService;

    @GetMapping()
    public ResponseEntity<List<SensorEntity>> getAllSensors(){
        return ResponseEntity.ok(sensorService.getAllSensors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorEntity> getOneSensor(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(sensorService.getOneSensor(id));
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> createSensor(@RequestBody SensorEntity sensorEntity){
        sensorService.createSensor(sensorEntity);
        return ResponseEntity.ok(new ResponseDTO("The sensor was created!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteSensor(@PathVariable Integer id){
        sensorService.deleteSensor(id);
        return ResponseEntity.ok(new ResponseDTO("The sensor was deleted"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateSensor(@PathVariable Integer id,@RequestBody SensorEntity sensorEntity) throws ChangeSetPersister.NotFoundException {
        sensorService.updateSensor(id,sensorEntity);
        return ResponseEntity.ok(new ResponseDTO("The sensor was updated"));
    }

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

}
