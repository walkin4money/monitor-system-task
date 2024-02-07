import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";


export const sensorTypeApi = createApi({
    reducerPath:"sensorTypeApi",
    baseQuery:fetchBaseQuery(
        {baseUrl:"http://localhost:8080/api/sensorTypes"}
    ),
    endpoints:(build)=>({
        getAllSensorTypes:build.query({
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

export const {useGetAllSensorTypesQuery} = sensorTypeApi;