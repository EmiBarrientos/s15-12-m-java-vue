import client from './client';


export const registrarHuesped = (huesped) =>
    client.post('/clientes/registrar', huesped);

export const registrarAnfitrion = (anfitrion) =>
    client.post('/propietarios/registrar', anfitrion);

export const realizarPago = (pagoData) =>
    client.post('/clientes/pagar', pagoData);

