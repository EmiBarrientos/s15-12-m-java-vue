import React from 'react'
import ReactDOM from 'react-dom/client'
import { UserProvider } from './context/UserContext'
import { InmuebleProvider } from './context/InmuebleContext';
import App from './App.jsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <UserProvider>
       <InmuebleProvider>
            <App />
        </InmuebleProvider>
    </UserProvider>
  </React.StrictMode>,
)
