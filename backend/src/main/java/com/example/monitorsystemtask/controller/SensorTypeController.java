package com.example.monitorsystemtask.controller;


import com.example.monitorsystemtask.entity.SensorTypeEntity;
import com.example.monitorsystemtask.service.SensorTypeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/sensorTypes")
public class SensorTypeController {
    SensorTypeService sensorTypeService;
    @GetMapping()
    public ResponseEntity<List<SensorTypeEntity>> getAllSensorTypes(){
        return ResponseEntity.ok(sensorTypeService.getAllSensorTypes());
    }

    @Autowired
    public SensorTypeController(SensorTypeService sensorTypeService){
        this.sensorTypeService = sensorTypeService;
    }
}
