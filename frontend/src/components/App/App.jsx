import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider, Routes} from "react-router-dom";
import LoginPage from "../../pages/LoginPage/components/LoginPage.jsx";
import SensorPage from "../../pages/SensorPage/components/SensorPage.jsx";
import ErrorPage from "../../pages/ErrorPage/components/ErrorPage.jsx";
import SensorCreatePage from "../../pages/SensorCreatePage/components/SensorCreatePage.jsx";
import SensorEditPage from "../../pages/SensorEditPage/components/SensorEditPage.jsx";
import NotFoundPage from "../../pages/NotFoundPage/components/NotFoundPage.jsx";
import {PrivateRoutes} from "../PrivateRoutes/PrivateRoutes.jsx";

const routes = createRoutesFromElements(
    <Route>
    <Route path="/" element={<LoginPage/>}/>
        <Route path="/sensorPage" element={
            <PrivateRoutes allowedAuthorities={["user:reading"]}>
                <SensorPage/>
            </PrivateRoutes>
        }/>
        <Route path="/errorPage" element={<ErrorPage/>}/>
        <Route path="/sensorCreatePage" element={
            <PrivateRoutes allowedAuthorities={["user:writing"]}>
                <SensorCreatePage/>
            </PrivateRoutes>
        }/>
        <Route path="/sensorEditPage/:id" element={
            <PrivateRoutes allowedAuthorities={["user:updating"]}>
                <SensorEditPage/>
            </PrivateRoutes>
        }/>
        <Route path="*" element={<NotFoundPage/>}/>
    </Route>
)

export const router = createBrowserRouter(routes);

function App() {
  return (
      <>
     </>
  )
}

export default App
