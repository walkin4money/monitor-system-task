import React, {useEffect,useState} from 'react';
import {Button, Col, Row, Space, Spin, Table, Typography} from "antd";

import {useNavigate} from "react-router-dom";
import {useDeleteSensorMutation, useGetAllSensorsQuery} from "../../../../api/sensorApi.js";
import {AddSensorButton} from "../AddSensorButton/AddSensorButton.jsx";
import {SearchSensorBar} from "../SearchSensorBar/SearchSensorBar.jsx";
import {LoadingOutlined} from "@ant-design/icons";


export function SensorTable(props) {
    const {data:sensors,isLoading:isLoadingSensors} = useGetAllSensorsQuery();
    const [deleteSensor,{isLoading:isLoadingDeleteSensor}] = useDeleteSensorMutation();
    const [filteredSensors,setFilteredSensors] = useState([]);
    const columns = [
        {
            title:"Name",
            dataIndex:"name",
            key:"name"
        },
        {
            title:"Model",
            dataIndex: "model",
            key:"model"
        },
        {
            title:"Type",
            dataIndex:"sensorTypeEntity",
            key:"type",
            render:(_, record)=>`${record.sensorTypeEntity.name}`,
        },
        {
           title:"Range",
            dataIndex: ['rangeTo','rangeFrom'],
            key:"range",
            render:(_,record)=> `${record.rangeTo} - ${record.rangeFrom}`
        },
        {
            title: "Unit",
            dataIndex: "sensorUnitEntity",
            key:"unit",
            render:(_, record)=>`${record.sensorUnitEntity.name}`,
        },
        {
            title: "Location",
            dataIndex:"location",
            key:"location"
        },
        {
          title: "Action",
            key:"action",
            render:(_,record)=><Space>
                <Button type="primary" onClick={()=>deleteSensor(record.id)}>Delete</Button>
                <Button type="primary" onClick={()=>navigate(`/sensorEditPage/${record.id}`)}>Update</Button>
            </Space>
        },

    ]
    const navigate = useNavigate();

    useEffect(() => {
        setFilteredSensors(sensors);
    }, [sensors]);

    return (
        <div>
            {(isLoadingSensors || isLoadingDeleteSensor) ? <Spin indicator={<LoadingOutlined style={{ fontSize: 100,color:'#1677ff' }} spin />}/>
                :
                <>
                    <SearchSensorBar sensors={sensors} setFilteredSensors={setFilteredSensors}/>
                    <Row style={{marginTop:"30px"}}>
                    <Col>
                        <Table columns={columns} dataSource={filteredSensors} rowKey="id" pagination={{pageSize:4}}
                               size="large"
                               expandable={{
                                   expandedRowRender:(record)=>
                                       <Typography.Text>
                                           {record.description}
                                       </Typography.Text>
                        }}>
                        </Table>
                    </Col>
                    </Row>
                    <AddSensorButton/>
                </>
            }
        </div>
    );
}
