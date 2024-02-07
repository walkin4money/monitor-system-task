package com.example.monitorsystemtask.repository;


import com.example.monitorsystemtask.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository <SensorEntity,Integer> {

}
