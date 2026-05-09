import React, { useState } from 'react'
import { FaSearch } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';

const ResultsTitle = () => {
    const [ubicacion, setUbicacion] = useState('');
    const navigate = useNavigate();

    const handleBuscar = () => {
        if (ubicacion.trim()) {
            navigate(`/resultados-obtenidos?ubicacion=${ubicacion}`);
        }
    };

    return (
        <section className="container mx-auto px-4 py-32">
            <h1 className="text-black font-bold text-4xl md:text-5xl lg:text-6xl">
                Busca propiedades en la <span className="text-customColor2 font-bold">Zona</span>
            </h1>
            <p className="text-customColor3 font-normal text-lg md:text-xl lg:text-2xl mt-4 md:mt-6 lg:mt-8">
                Se mostrarán los resultados obtenidos
            </p>
            <div className="relative mt-4 md:mt-6 lg:mt-8">
                <input
                    type="text"
                    placeholder="Busca la ubicación deseada..."
                    className="w-full px-4 py-3 md:py-4 lg:py-5 pl-10 bg-white border border-customColor4 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-base md:text-lg lg:text-xl"
                    value={ubicacion}
                    onChange={(e) => setUbicacion(e.target.value)}
                    onKeyDown={(e) => e.key === 'Enter' && handleBuscar()}
                />
                <FaSearch className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-500" />
            </div>
        </section>
    )
}

export default ResultsTitle;