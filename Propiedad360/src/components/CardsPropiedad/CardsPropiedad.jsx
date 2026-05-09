// src/components/CardsPropiedad/CardsPropiedad.jsx
import React from 'react';
import { useNavigate } from 'react-router-dom';

function CardPropiedad({ inmueble }) {
    const navigate = useNavigate();
    if (!inmueble) return null;

    return (
        <div className="card w-full shadow-xl mt-4 cursor-pointer" onClick={() => navigate(`/detalle-de-vivienda?id=${inmueble.id}`)}>
            <div className="mt-4 items-center text-center">
                <figure>
                    <img src={inmueble.foto || 'https://placehold.co/400x300'} alt={inmueble.titulo} />
                </figure>
                <div className="card-body bg-[#191A18] mt-5 rounded-tr-lg text-[20px] h-[140px] border-2 border-[#C3922E]">
                    <p className="text-[#C3922E]">{inmueble.titulo}</p>
                    <p>Zona: {inmueble.ubicacion}</p>
                    <p>${inmueble.precio} mensuales</p>
                </div>
            </div>
        </div>
    );
}

export default CardPropiedad;