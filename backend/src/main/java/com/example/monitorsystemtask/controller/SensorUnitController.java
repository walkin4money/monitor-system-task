package com.example.monitorsystemtask.controller;
import com.example.monitorsystemtask.entity.SensorUnitEntity;
import com.example.monitorsystemtask.service.SensorUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/sensorUnits")
public class SensorUnitController {
    SensorUnitService sensorUnitService;

    @GetMapping()
    public ResponseEntity<List<SensorUnitEntity>> getAllSensorTypes(){
        return ResponseEntity.ok(sensorUnitService.getAllSensorUnits());
    }

    @Autowired
    public SensorUnitController(SensorUnitService sensorUnitService){
        this.sensorUnitService = sensorUnitService;
    }
}
