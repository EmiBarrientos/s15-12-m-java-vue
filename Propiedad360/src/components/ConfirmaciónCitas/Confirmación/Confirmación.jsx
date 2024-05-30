import React from 'react';
import { Link } from 'react-router-dom';

const Confirmación = () => {
  return (
    <section>
        <div>
            <h1>Confirmación de visita</h1>
            <p>Inmobiliaria Santa Fé</p>
            <p>Cód. del anunciante: 3H78F5 | Cód. de la propiedad: 35698536</p>
        </div>
        <div>
            <h2>CONFIRMACIÓN EXITOSA</h2>
            <span>Recibirá en su correo registrado los detalles de su visita, favor de revisarlos</span>
        </div>
        <div>
            <Link to="/">
                <button className="btn btn-wide">Volver a inicio</button>
            </Link>
        </div>
    </section>
  )
}

export default Confirmación;