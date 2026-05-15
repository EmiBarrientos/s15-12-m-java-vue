// src/api/usuarioApi.js
import client from './client';

export const iniciarSesion = (email, contrasena) =>
    client.post('/usuarios/iniciar-sesion', { email, contrasena });

export const actualizarPerfil = (usuario) =>
    client.put('/usuarios/actualizar-perfil', usuario);