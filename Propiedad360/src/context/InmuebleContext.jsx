import React, { createContext, useContext, useState } from 'react';

const InmuebleContext = createContext();

export const InmuebleProvider = ({ children }) => {
    const [inmuebleData, setInmuebleData] = useState({
        perfilUsuario: '',
        tipoOperacion: '',
        tipoInmueble: '',
        ubicacion: '',
        numeroRecamaras: 0,
        numeroBanios: 0,
        superficieConstruida: 0,
        superficieTerreno: 0,
        antiguedad: '',
        precio: 0,
        mantenimiento: 0,
        titulo: '',
        descripcion: ''
    });

    const actualizarInmueble = (datos) => {
        setInmuebleData(prev => ({ ...prev, ...datos }));
    };

    const resetInmueble = () => {
        setInmuebleData({});
    };

    return (
        <InmuebleContext.Provider value={{ inmuebleData, actualizarInmueble, resetInmueble }}>
            {children}
        </InmuebleContext.Provider>
    );
};

export const useInmueble = () => useContext(InmuebleContext);