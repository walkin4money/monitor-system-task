import React from 'react'
import ReactDOM from 'react-dom/client'
import App, {router} from './components/App/App.jsx'
import {RouterProvider} from "react-router-dom";
import './main.css';
import {Provider} from "react-redux";
import {store} from "./store/store.js";


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
      <Provider store={store}>
          <RouterProvider router={router}>
              <App />
          </RouterProvider>
      </Provider>
  </React.StrictMode>
)
