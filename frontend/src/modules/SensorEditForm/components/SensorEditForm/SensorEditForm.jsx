import React, {useEffect} from 'react';
import {useParams} from "react-router-dom";
import {Spin} from "antd";
import {useForm} from "antd/es/form/Form.js";
import {useGetAllSensorUnitsQuery} from "../../../../api/sensorUnitApi.js";
import {useGetOneSensorQuery, useUpdateSensorMutation} from "../../../../api/sensorApi.js";
import {useGetAllSensorTypesQuery} from "../../../../api/sensorTypeApi.js";
import { LoadingOutlined } from '@ant-design/icons';
import {SensorForm} from "../../../../components/SensorForm/SensorForm/SensorForm.jsx";

export function SensorEditForm(props) {
    const {id} = useParams();
    const {data:sensorUnits,isLoading:isLoadingUnits} = useGetAllSensorUnitsQuery();
    const {data:sensorTypes,isLoading:isLoadingTypes} = useGetAllSensorTypesQuery();
    const {data:sensor,isLoading:isLoadingSensor} = useGetOneSensorQuery(id);
    const [updateSensor,{isLoading:isLoadingUpdateSensor}] = useUpdateSensorMutation();
    const [form] = useForm();
    function handleSubmit(values){
        updateSensor({body:values,id:id});
    }

    useEffect(() => {
        if(sensor){
            form.setFieldsValue(sensor);
        }
    }, [sensor]);

    return (
        <div>
            {((isLoadingSensor && isLoadingTypes && isLoadingUnits) || isLoadingUpdateSensor) ?
                <Spin indicator={<LoadingOutlined style={{ fontSize: 100,color:'#1677ff' }} spin />}/>
                :
                <SensorForm form={form} sensorTypes={sensorTypes} sensorUnits={sensorUnits} handleSubmit={handleSubmit}/>
            }
        </div>
    )
}
