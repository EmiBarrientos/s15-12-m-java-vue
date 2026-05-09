import React from 'react';
import { FaMapMarkerAlt } from 'react-icons/fa';

const Descripción = ({ inmueble }) => {
    return (
        <section className="container mx-auto px-4 py-8 md:py-16 lg:py-24">
            <h1 className="text-black text-2xl md:text-3xl lg:text-4xl font-bold mb-2">
                {inmueble.tipoInmueble} · {inmueble.superficieConstruida}m² · {inmueble.numeroRecamaras} recámaras
            </h1>
            <h2 className="text-lg md:text-xl lg:text-2xl text-black mb-4">
                Renta ${inmueble.precio} · Zona: {inmueble.ubicacion}
            </h2>
            <div className="flex items-center text-lg md:text-xl lg:text-2xl text-black">
                <FaMapMarkerAlt className="mr-2" />
                <p className="text-lg md:text-xl lg:text-2xl text-black">{inmueble.ubicacion}</p>
            </div>
        </section>
    );
}

export default Descripción;