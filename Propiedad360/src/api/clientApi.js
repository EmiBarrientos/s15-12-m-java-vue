import client from './client';


export const iniciarSesion = (email, contrasena) => 
    client.post('/usuarios/iniciar-sesion', { email, contrasena });

export const registrarHuesped = (huesped) =>
    client.post('/clientes/registrar', huesped);

export const registrarAnfitrion = (anfitrion) =>
    client.post('/propietarios/registrar', anfitrion);
