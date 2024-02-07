import {Button, Typography} from "antd";
import React from "react";
import {Header} from "antd/es/layout/layout.js";
import {useNavigate} from "react-router-dom";

export function PageHeader({title}) {
    const navigate = useNavigate();
    function handleLogout(){
        localStorage.clear();
        navigate("/");
    }
    return (
        <Header style={{background: "#1677ff", display: "flex", alignItems: "center"}}>
            <Typography.Text style={{flex: 7, fontSize: 25, color: "#fff"}}>
                {title}
            </Typography.Text>
            <Button style={{flex: 1}} onClick={handleLogout} size="large" type="primary">Logout</Button>
        </Header>
    );
}