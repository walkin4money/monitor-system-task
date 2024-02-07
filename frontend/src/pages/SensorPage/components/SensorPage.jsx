import React from 'react';
import {SensorTable} from "../../../modules/SensorTable/index.js";
import {Button, Layout, Typography} from "antd";
import {Content, Header} from "antd/es/layout/layout.js";
import {PageHeader} from "../../../modules/PageHeader/index.js";


function SensorPage(props) {
    return (
        <Layout style={{minHeight:"100vh"}}>
            <PageHeader title="Sensor Table"/>
            <Content style={{display: "flex", justifyContent: "center", alignItems: "center",flexDirection: "column"}}>
                <SensorTable/>
            </Content>
        </Layout>
    );
}

export default SensorPage;