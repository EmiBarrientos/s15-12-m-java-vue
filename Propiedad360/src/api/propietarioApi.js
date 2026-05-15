// src/api/propietarioApi.js
import client from './client';

export const publicarInmueble = (inmueble, propietarioId) =>
    client.post(`/propietarios/${propietarioId}/inmuebles`, inmueble);

export const obtenerPropietario = (id) =>
    client.get(`/propietarios/${id}`);