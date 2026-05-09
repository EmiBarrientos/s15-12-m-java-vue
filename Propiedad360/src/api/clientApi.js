import client from './client';

export const registrarCliente = (cliente) => client.post('/clientes/registrar', cliente);
export const obtenerCliente = (id) => client.get(`/clientes/${id}`);
export const reservarInmueble = (reserva) => client.post('/clientes/reservar', reserva);
export const realizarPago = (pago) => client.post('/clientes/pagar', pago);

export const iniciarSesion = (email, contrasena) => 
    client.post('/usuarios/iniciar-sesion', { email, contrasena });