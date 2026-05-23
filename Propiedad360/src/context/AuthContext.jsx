import { createContext, useState, useEffect } from 'react';
import { iniciarSesion } from '../../api/authApi';
import { set } from 'date-fns';

export const AuthContext = createContext();

export function AuthProvider ({ children }) {
    const [token, setToken] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

//  Validar si ya había un token guardado al abrir la app
    useEffect(() => {
        const loadToken = async () => {
            try{
                const token = localStorage.getItem('token');
                if (token) {
                    setToken(token);
                }
            }catch (error) {
                console.error('Error al cargar el token:', error);
            }finally{
                setIsLoading(false);
            }
        };
        loadToken();
    }, []);

    
  const login = async (username, password) => {
    try {
      const response = await iniciarSesion(username, password);
      const userToken = response.data.token; // Ajustalo a tu JSON de Spring Boot
      
      localStorage.setItem('token', userToken);
      setToken(userToken);
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Error al iniciar sesión');
    }
  };

 
  const logout = () => {
    localStorage.removeItem('token');
    setToken(null);
  };

    return (
        <AuthContext.Provider value={{ token, isLoading, login, logout }}>
        {children}
        </AuthContext.Provider>
    );
}