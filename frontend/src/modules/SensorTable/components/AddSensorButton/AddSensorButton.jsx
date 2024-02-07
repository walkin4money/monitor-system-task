import React from 'react';
import {Button, Col, Row} from "antd";
import {useNavigate} from "react-router-dom";

export function AddSensorButton(props) {
    const navigate = useNavigate();
    return (
        <Row style={{marginTop:"16px"}}>
            <Col>
                <Button onClick={()=>navigate("/sensorCreatePage")} type="primary" size="large">Add sensor</Button>
            </Col>
        </Row>
    );
}

