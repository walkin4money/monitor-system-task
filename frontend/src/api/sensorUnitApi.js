import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";

export const sensorUnitApi = createApi({
    reducerPath:"sensorUnitApi",
    baseQuery:fetchBaseQuery({baseUrl:"http://localhost:8080/api/sensorUnits"}),
    endpoints:(build)=>({
        getAllSensorUnits:build.query({
            query:()=>({
                url:""
            }),
            transformResponse(baseQueryReturnValue) {
                return baseQueryReturnValue.map(u=>({
                    value:u.id,
                    label:u.name
                }))
            }
        })
    })
})

export const {useGetAllSensorUnitsQuery} = sensorUnitApi;