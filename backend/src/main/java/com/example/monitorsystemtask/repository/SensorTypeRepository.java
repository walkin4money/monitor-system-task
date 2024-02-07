package com.example.monitorsystemtask.repository;

import com.example.monitorsystemtask.entity.SensorTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorTypeEntity,Integer> {
}
