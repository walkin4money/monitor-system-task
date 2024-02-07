import React from 'react';
import {useLocation, useNavigate} from "react-router-dom";
import {Button, Result} from "antd";

export function ErrorInfo(props) {
    const {state:{status:codeStatus,data:{message:errorMessage,status:textStatus}}} = useLocation();
    const navigate = useNavigate();
    return (
        <Result
            title={`${textStatus} ${codeStatus}`}
            subTitle={errorMessage}
            extra={<Button type="primary"  onClick={()=> codeStatus === 401 ? navigate('/') : navigate(-1)}>{codeStatus === 401 ? "Go login" : "Go back"}</Button>}
        />
    );
}

