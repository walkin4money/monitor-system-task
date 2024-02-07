import React from 'react';
import {Form, InputNumber} from "antd";

export const RangeInputFormItem = ({ name, placeholder, rules, style, dependencies }) => {
    return (
        <Form.Item name={name} dependencies={dependencies} rules={rules} style={style}>
            <InputNumber style={{ width: "100%" }} placeholder={placeholder} />
        </Form.Item>
    );
};