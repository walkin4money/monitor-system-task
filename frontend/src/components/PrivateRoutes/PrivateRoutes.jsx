import React from 'react';
import {Navigate} from "react-router-dom";


export function PrivateRoutes({allowedAuthorities,children}) {
    const authorities = localStorage.getItem("authorities");

    const error = {
      status:403,
        data:{
          status:"FORBIDDEN",
            message:"Insufficient permissions to access this page"
        }
    }

    return (
        allowedAuthorities?.find(a=>authorities?.includes(a)) ? children
            : <Navigate to="/errorPage" state={error} replace/>
    );

}
