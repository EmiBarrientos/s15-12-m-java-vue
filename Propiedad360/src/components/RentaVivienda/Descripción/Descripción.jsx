import React from 'react';
import { FaMapMarkerAlt } from 'react-icons/fa';

const Descripción = () => {
  return (
    <section className="container mx-auto px-4 py-32">
      <h1 className="text-black text-[36px] font-bold mb-2">Departamento · 110m² · 2 recámaras · 2 estacionamientos</h1>
      <h2 className="text-[24px] text-black mb-4">Renta $5,200 · Zona: Barrio Norte</h2>
      <div className="flex text-black text-[24px]">
        <FaMapMarkerAlt className="mr-2" /> 
        <p className="text-[24px] text-black">Avenida Santa Fe 2755 Piso 7º 1425, Ciudad autónoma de Buenos Aires</p>
      </div>
    </section>
  )
}

export default Descripción;