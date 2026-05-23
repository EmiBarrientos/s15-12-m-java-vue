import client from './client';
export const obtenerInmuebles = () => 
    client.get('/api/inmuebles');

export const buscarPorUbicacion = (ubicacion) => 
    client.get(`/api/inmuebles/buscar?ubicacion=${ubicacion}`);

export const obtenerInmueble = (id) => 
    client.get(`/api/inmuebles/${id}`);