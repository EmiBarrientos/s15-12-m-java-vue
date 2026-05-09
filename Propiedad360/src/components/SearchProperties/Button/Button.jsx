import React from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';

const Button = () => {
    const [searchParams] = useSearchParams();
    const navigate = useNavigate();

    const handleClick = () => {
        const ubicacion = searchParams.get('ubicacion') || '';
        navigate(`/resultados-obtenidos?ubicacion=${ubicacion}`);
    };

    return (
        <div className="flex justify-center mt-9">
            <button 
                className="btn btn-wide bg-buttonColor text-white"
                onClick={handleClick}
            >
                Seleccionar ubicación
            </button>
        </div>
    )
}

export default Button;