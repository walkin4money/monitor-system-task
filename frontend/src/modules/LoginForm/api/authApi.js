import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";


export const authApi = createApi({
    reducerPath: "authApi",
    baseQuery: fetchBaseQuery({baseUrl: "http://localhost:8080/api/auth/"}),
    endpoints: build => ({
        login: build.mutation({
            query:(body)=>({
                url:"login",
                method:"post",
                body
            }),
            transformResponse(baseQueryReturnValue) {
                localStorage.setItem("access_token",baseQueryReturnValue.token);
                localStorage.setItem("authorities",JSON.stringify(baseQueryReturnValue.authorities));
            }
        })
    })
})

export const {useLoginMutation} = authApi;