import React from 'react';

import {Flex} from "antd";
import {LoginForm, store} from "../../../modules/LoginForm/index.js";
import {Provider} from "react-redux";

function LoginPage(props) {
    return (
        <Flex justify="center" align="center" style={{height:"100vh"}}>
            <Provider store={store}>
                <LoginForm/>
            </Provider>
        </Flex>
    );
}

export default LoginPage;