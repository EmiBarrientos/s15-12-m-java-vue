import React from 'react';
import { Link } from 'react-router-dom';

const Agenda = () => {
  return (
    <section>
        <div>
            <h1>Agenda una visita con el anunciante</h1>
            <h3>Inmobiliaria Santa Fé</h3>
            <p>Cód. del anunciante: 3H78F5 | Cód. de la propiedad: 35698536</p>
        </div>
        <div>
            <h2>CONFIRMACIÓN:</h2>
            <span>*FECHA: Viernes 13 Mayo 204</span>
            <span>*HORARIO: Tarde 2pm a 4 pm</span>
        </div>
        <div>
            <Link to="/confirmar-cita">
                <button className="btn btn-wide">Confirmar</button>
            </Link>
            <button className="btn btn-wide">Modificar</button>
        </div>
    </section>
  )
}

export default Agenda;