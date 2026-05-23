// src/routes/protectedLoader.js
import { redirect } from 'react-router-dom';
import { getAuthToken } from '../utils/auth';

// Si no hay token, redirige al login inmediatamente
export const protectedLoader = () => {
  const token = getAuthToken();
  if (!token) {
    return redirect('/');
  }
  return null; // Permite el acceso
};

// Si YA está logueado, no lo dejes entrar al login
export const loginLoader = () => {
  const token = getAuthToken();
  if (token) {
    return redirect('/home');
  }
  return null;
};