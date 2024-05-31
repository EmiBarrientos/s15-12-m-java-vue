import React from 'react';
import { FaMapMarkerAlt } from 'react-icons/fa';

const Descripción = () => {
  return (
    <section className="container mx-auto px-4 py-8 md:py-16 lg:py-24">
      <h1 className="text-black text-2xl md:text-3xl lg:text-4xl font-bold mb-2">Departamento · 110m² · 2 recámaras · 2 estacionamientos</h1>
      <h2 className="text-lg md:text-xl lg:text-2xl text-black mb-4">Renta $5,200 · Zona: Barrio Norte</h2>
      <div className="flex items-center text-lg md:text-xl lg:text-2xl text-black">
        <FaMapMarkerAlt className="mr-2" /> 
        <p className="text-lg md:text-xl lg:text-2xl text-black">Avenida Santa Fe 2755 Piso 7º 1425, Ciudad autónoma de Buenos Aires</p>
      </div>
    </section>
  )
}

export default Descripción;