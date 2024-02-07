import React from 'react';
import {Select,Form} from "antd";

export function SelectFormItem({rules,name,label,placeholder,options}) {
    return (
        <Form.Item rules={rules} name={name} label={label}>
            <Select
                placeholder={placeholder}
                options={options}
            />
        </Form.Item>
    );
}

