
import {Form} from "antd";
import {InputFormItem} from "../InputFormItem/InputFormItem.jsx";
import {FormActions} from "../FormActions/FormActions.jsx";
import {rangeFromValidator,integerValidator} from "../../../helpers/validateSensorForm.js";
import {RangeInputFormItem} from "../RangeInputFormItem/RangeInputFormItem.jsx";
import {SelectFormItem} from "../SelectFormItem/SelectFormItem.jsx";
import {TextAreaFormItem} from "../TextAreaFormItem/TextAreaFormItem.jsx";
import {sensorFormItemLayout} from "../../../constants/sensorFormItemLayout.js";

export function SensorForm({handleSubmit,form,sensorTypes,sensorUnits}) {
    return (
        <Form {...sensorFormItemLayout} style={{minWidth:"30%"}} onFinish={handleSubmit} form={form} >
            <InputFormItem rules={[{required:true},{max:30}]} placeholder="Enter the name of the sensor" name="name" label="Name"/>
            <InputFormItem rules={[{required:true},{max:15}]} placeholder="Enter the sensor model" name="model" label="Model"/>
            <Form.Item label="Range" style={{marginBottom:0}}>
                <RangeInputFormItem name="rangeFrom" rules={[{required: true,}, integerValidator(), rangeFromValidator(form)]} placeholder="from"
                                    dependencies={["rangeTo"]} style={{display: 'inline-block',width: 'calc(50% - 3px)'}}
                        />
                <RangeInputFormItem name="rangeTo" rules={[{required: true,}, integerValidator()]} placeholder="from" dependencies={[]}
                                    style={{display: 'inline-block',width: 'calc(50% - 3px)',marginLeft:"3px"}}/></Form.Item>
            <SelectFormItem rules={[{required:true}]} name={["sensorTypeEntity","id"]} label="Type" placeholder="Select sensor type" options={sensorTypes}/>
            <SelectFormItem rules={[{required:true}]} name={["sensorUnitEntity","id"]} label="Units" placeholder="Select the units" options={sensorUnits}/>
            <InputFormItem rules={[{max:40}]} placeholder="Enter the location of the sensor" name="location" label="Location"/>
            <TextAreaFormItem label="Description" name="description" rules={[{max:200}]} placeholder="Enter a description of the sensor"/>
            <FormActions form={form}/>
        </Form>
    )
}

