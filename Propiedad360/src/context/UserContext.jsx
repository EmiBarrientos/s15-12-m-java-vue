import React, { createContext, useContext, useState, useEffect } from 'react';
import { iniciarSesion, cerrarSesion, verificarSesion } from '../api/authApi';

const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    verificarSesion()
      .then(res => setUser(res.data))
      .catch(() => setUser(null))
      .finally(() => setLoading(false));
}, []);
  
  
  const login = (userData) => {
    setUser(userData);
  };

  const logout = () => {
    setUser(null);
  };



  return (
    <UserContext.Provider value={{ user, login, logout }}>
      {children}
    </UserContext.Provider>
  );
};


export const useUser = () => {
  return useContext(UserContext);
};