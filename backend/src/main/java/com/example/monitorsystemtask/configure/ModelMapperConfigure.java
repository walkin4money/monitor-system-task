package com.example.monitorsystemtask.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfigure extends ModelMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
