import client from './client';

export const iniciarSesion = (username, contrasena) =>
    client.post('/auth/login', { username, contrasena });

export const cerrarSesion = () =>
    client.post('/auth/logout');

export const verificarSesion = () =>
    client.get('/auth/me');

export const registrarHuesped = (huesped) =>
    console.log('Registrando huesped con datos estoy en authapi:', huesped) ||
    client.post('/auth/register/cliente', huesped);

export const registrarAnfitrion = (anfitrion) =>
    client.post('/auth/register/propietario', anfitrion);
