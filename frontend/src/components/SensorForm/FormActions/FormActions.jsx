import React from 'react';
import {Button, Form, Space} from "antd";
import {useNavigate} from "react-router-dom";

export function FormActions({form}) {
    const navigate = useNavigate();
    return (
        <Form.Item wrapperCol={{offset:12}}>
            <Space>
                <Button type="primary" onClick={()=>navigate(-1)}>Cancel</Button>
                <Button type="primary" onClick={()=>form.resetFields()}>Reset</Button>
                <Button type="primary" htmlType="submit">Save</Button>
            </Space>
        </Form.Item>
    );
}
