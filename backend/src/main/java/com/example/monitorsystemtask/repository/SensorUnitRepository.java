package com.example.monitorsystemtask.repository;

import com.example.monitorsystemtask.entity.SensorTypeEntity;
import com.example.monitorsystemtask.entity.SensorUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorUnitRepository extends JpaRepository<SensorUnitEntity,Integer> {
}
