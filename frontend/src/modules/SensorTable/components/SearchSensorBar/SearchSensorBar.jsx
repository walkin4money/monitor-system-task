import React, {useEffect, useRef, useState} from 'react';
import {Button, Col, Input, Row} from "antd";

export function SearchSensorBar({sensors,setFilteredSensors}) {
    function handlerSearch(value){
        setFilteredSensors(sensors.filter(d=>d.name === value))
    }
    function handlerReset(){
        setFilteredSensors(sensors);
    }

    return (
        <Row>
            <Col>
                <Input.Search size="large" onSearch={handlerSearch}/>
            </Col>
            <Col style={{marginLeft:"16px"}}>
                <Button size="large" onClick={handlerReset} type="primary">Reset</Button>
            </Col>
        </Row>
    );
}

