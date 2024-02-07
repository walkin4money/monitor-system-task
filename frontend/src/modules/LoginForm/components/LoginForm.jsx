import React, {useEffect} from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import {Button, Form, Input, Typography} from "antd";
import {useLoginMutation} from "../api/authApi.js";
import {useNavigate} from "react-router-dom";

export function LoginForm(props) {
    const [login,{error,isSuccess,isError}] = useLoginMutation();
    const navigate = useNavigate();
    const handleSubmit = ({username,password}) => {
        login({username,password});
    };
    useEffect(() => {
        if(isSuccess){
           navigate("sensorPage",{replace:true});
        }
    }, [isSuccess]);

    useEffect(() => {
        if(isError){
            navigate("errorPage",{state:error});
        }
    }, [isError]);


    return (
            <>
                <Form style={{width:'30%'}} onFinish={handleSubmit}>
                    <Form.Item style={{textAlign:"center"}}>
                        <Typography.Title>
                            Login Form
                        </Typography.Title>
                        <Typography.Paragraph style={{fontSize:"19px"}}>
                            enter login and password for access
                        </Typography.Paragraph>
                    </Form.Item>
                   <Form.Item name="username" rules={[{required:true},{min:3},{max:30}]}>
                     <Input prefix={<UserOutlined/>} placeholder="Username" size="large"/>
                   </Form.Item>

                    <Form.Item name="password" rules={[{required:true},{min:3},{max:30}]}>
                        <Input.Password prefix={<LockOutlined/>} placeholder="Password" size="large"/>
                    </Form.Item>
                    <Form.Item>
                        <Button style={{width:"100%"}} type="primary" htmlType="submit" size="large">Login</Button>
                    </Form.Item>
                </Form>
                </>
    );
}


