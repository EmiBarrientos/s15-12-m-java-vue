import client from './client';

export const realizarPago = (pagoData) =>
    client.post('/api/clientes/pagar', pagoData);

