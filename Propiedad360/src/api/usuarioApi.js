// src/api/usuarioApi.js
import client from './client';


export const actualizarPerfil = (usuario) =>
    client.put('/api/usuarios/actualizar-perfil', usuario);