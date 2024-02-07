import {configureStore} from "@reduxjs/toolkit/react";
import {sensorApi} from '../api/sensorApi.js';
import {sensorTypeApi} from '../api/sensorTypeApi.js';
import {sensorUnitApi} from '../api/sensorUnitApi.js';


export const store = configureStore({
    reducer:{
        [sensorApi.reducerPath]:sensorApi.reducer,
        [sensorTypeApi.reducerPath]:sensorTypeApi.reducer,
        [sensorUnitApi.reducerPath]:sensorUnitApi.reducer
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(
        sensorApi.middleware,
        sensorTypeApi.middleware,
        sensorUnitApi.middleware
    )
})
