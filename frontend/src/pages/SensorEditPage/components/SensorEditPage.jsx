import React from 'react';
import {Layout} from "antd";
import {Content} from "antd/es/layout/layout.js";
import {SensorEditForm} from "../../../modules/SensorEditForm/index.js";
import {PageHeader} from "../../../modules/PageHeader/index.js";



function SensorEditPage(props) {
    return (
        <Layout style={{minHeight:"100vh"}}>
            <PageHeader title="Edit Sensor"/>
            <Content style={{display: "flex", justifyContent: "center", alignItems: "center",flexDirection: "column"}}>
                <SensorEditForm/>
            </Content>
        </Layout>
    );
}

export default SensorEditPage;