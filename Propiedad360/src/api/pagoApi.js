// src/api/pagoApi.js
import client from './client';

export const obtenerPago = (id) => client.get(`/pagos/${id}`);
export const verificarEstadoPago = (id) => client.get(`/pagos/${id}/estado`);