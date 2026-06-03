
import axios from 'axios';
import { config } from 'dotenv';
import { createRoutes } from '../routes/Routes.jsx';

const client = axios.create({
    baseURL:  import.meta.env.VITE_API_URL,
    withCredentials: true,
    headers: {
        'Content-Type': 'application/json'
    }
});

client.interceptors.request.use(
    config => config,  // no hay nada que agregar, la cookie va sola
    error => Promise.reject(error)
);

client.interceptors.response.use(
    response => response,
    error => {
        if (error.response?.status === 401 || error.response?.status === 403) {
            console.log("Sesión expirada o inválida.");
                routes.navigate('/');
        }
        return Promise.reject(error);
    }
);

export default client;
