import React from 'react';
import FormItem from "antd/es/form/FormItem/index.js";
import {Input} from "antd";

export function InputFormItem({rules,name,label,placeholder}) {
    return (
        <FormItem rules={rules} name={name} label={label}>
            <Input placeholder={placeholder}/>
        </FormItem>
    );
}

