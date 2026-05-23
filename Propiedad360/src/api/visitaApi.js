// src/api/visitaApi.js
import client from './client';

export const crearVisita = (visita) => client.post('/api/visitas', visita);
export const obtenerVisita = (id) => client.get(`/api/visitas/${id}`);