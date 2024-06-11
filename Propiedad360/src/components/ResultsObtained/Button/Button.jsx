import React from 'react';
import { Link } from 'react-router-dom'; 

const Button = () => {
    return (
        <div className="flex justify-center mt-9">
            <Link to="/buscar-propiedades-en-zona">
                <button className="btn btn-wide bg-buttonColor text-white">Búsqueda nueva</button>
            </Link>
        </div>
    )
}

export default Button;