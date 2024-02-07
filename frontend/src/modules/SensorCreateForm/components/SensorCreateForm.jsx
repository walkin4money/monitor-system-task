import React from 'react';
import {useForm} from "antd/es/form/Form.js";
import {useCreateSensorMutation} from "../../../api/sensorApi.js";
import {useGetAllSensorUnitsQuery} from "../../../api/sensorUnitApi.js";
import {useGetAllSensorTypesQuery} from "../../../api/sensorTypeApi.js";
import {SensorForm} from "../../../components/SensorForm/SensorForm/SensorForm.jsx";
import {Spin} from "antd";
import {LoadingOutlined} from "@ant-design/icons";



export function SensorCreateForm(props) {
    const [createSensor,{isLoading:isLoadingCreateSensor}] = useCreateSensorMutation();
    const {data:sensorUnits,isLoading:isLoadingUnits} = useGetAllSensorUnitsQuery();
    const {data:sensorTypes,isLoading:isLoadingTypes} = useGetAllSensorTypesQuery();
    const [form] = useForm();
    function handleSubmit(values){
       createSensor(values);
    }

    return (
        <div>
            {(isLoadingCreateSensor || (isLoadingUnits && isLoadingTypes)) ?
                <Spin indicator={<LoadingOutlined style={{ fontSize: 100,color:'#1677ff' }} spin />}/>
                :
                <SensorForm form={form} sensorUnits={sensorUnits} sensorTypes={sensorTypes} handleSubmit={handleSubmit}/>
            }
        </div>
    );
}
