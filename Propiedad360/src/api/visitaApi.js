// src/api/visitaApi.js
import client from './client';

export const crearVisita = (visita) => client.post('/visitas', visita);
export const obtenerVisita = (id) => client.get(`/visitas/${id}`);