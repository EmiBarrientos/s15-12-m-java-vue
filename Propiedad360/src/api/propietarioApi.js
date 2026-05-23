// src/api/propietarioApi.js
import client from './client';

export const publicarInmueble = (inmueble, propietarioId) =>
    client.post(`/api/propietarios/${propietarioId}/inmuebles`, inmueble);

export const obtenerPropietario = (id) =>
    client.get(`/api/propietarios/${id}`);