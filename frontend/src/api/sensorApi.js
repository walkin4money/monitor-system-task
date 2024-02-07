import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import {router} from "../components/App/App.jsx";

export const sensorApi = createApi({
    reducerPath:"sensorApi",
    baseQuery:fetchBaseQuery(
        {
            baseUrl:"http://localhost:8080/api/sensors",
            prepareHeaders:(headers)=>{
                const access_token = localStorage.getItem("access_token");
                headers.set("Authorization",`Bearer ${access_token}`);
            }
        }
    ),
    endpoints:(build)=>({
        getAllSensors:build.query({
            query:(arg)=> ({
                url:""
            }),
            transformErrorResponse(baseQueryReturnValue) {
                router.navigate("/errorPage",{state:baseQueryReturnValue})
            },
            providesTags: (result, error, arg) =>
                result
                    ? [...result.map(({ id }) => ({ type: 'Sensors', id })), 'Sensors']
                    : ['Sensors'],
        }),

        getOneSensor:build.query({
            query:(id) =>({
                url:`/${id}`,
            }),
            transformErrorResponse:(baseQueryReturnValue)=> {
                router.navigate("/errorPage",{state:baseQueryReturnValue});
            },
        }),

        createSensor:build.mutation({
            query:(body)=> ({
                url:"",
                method:"POST",
                body
            }),
            transformErrorResponse(baseQueryReturnValue) {
                console.log(baseQueryReturnValue);
                router.navigate("/errorPage",{state:baseQueryReturnValue});
            },
            transformResponse(baseQueryReturnValue ) {
                console.log(baseQueryReturnValue);
                router.navigate("/sensorPage");
            },
            invalidatesTags:["Sensors"],

        }),

        updateSensor:build.mutation({
            query:({body,id})=>({
                url:`/${id}`,
                method:"PATCH",
                body,
            }),
            transformErrorResponse:(baseQueryReturnValue)=> {
                router.navigate("/errorPage",{state:baseQueryReturnValue});
            },
            transformResponse:(baseQueryReturnValue)=> {
                router.navigate("/sensorPage");
            },
            invalidatesTags:["Sensors"]
        }),

        deleteSensor:build.mutation({
            query:(id)=> ({
                url:`/${id}`,
                method:"DELETE"
            }),
            transformErrorResponse(baseQueryReturnValue) {
                console.log(baseQueryReturnValue);
                router.navigate("/errorPage",{state:baseQueryReturnValue})
            },
            invalidatesTags:["Sensors"],
        }),
        tagTypes:["Sensors"]
    })
})

export const {
    useGetAllSensorsQuery,
    useGetOneSensorQuery,
    useDeleteSensorMutation,
    useCreateSensorMutation,
    useUpdateSensorMutation
} = sensorApi;