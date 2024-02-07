import React from 'react';
import {SensorCreateForm} from "../../../modules/SensorCreateForm/index.js";
import {Button,Layout, Typography} from "antd";
import {Content, Header} from "antd/es/layout/layout.js";
import {PageHeader} from "../../../modules/PageHeader/index.js";


function SensorCreatePage(props) {
    return (
        <Layout style={{minHeight:"100vh"}}>
            <PageHeader title="Create Sensor"/>
            <Content style={{display: "flex", justifyContent: "center", alignItems: "center",flexDirection: "column"}}>
                <SensorCreateForm/>
            </Content>
        </Layout>
    );
}

export default SensorCreatePage;