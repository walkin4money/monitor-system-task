import React from 'react';
import {Form, Input} from "antd";

export function TextAreaFormItem({name,label,rules,placeholder}) {
    return (
        <Form.Item label={label} name={name} rules={rules}>
            <Input.TextArea placeholder={placeholder}/>
        </Form.Item>
    );
}
