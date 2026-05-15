import client from './client';
export const obtenerInmuebles = () => 
    client.get('/inmuebles');

export const buscarPorUbicacion = (ubicacion) => 
    client.get(`/inmuebles/buscar?ubicacion=${ubicacion}`);

export const obtenerInmueble = (id) => 
    client.get(`/inmuebles/${id}`);