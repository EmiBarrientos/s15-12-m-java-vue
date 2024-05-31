import React from 'react';
import { Link } from 'react-router-dom';

const Agenda = () => {
  return (
    <section className="bg-slate-300 mx-auto px-4 py-16 md:py-32 mb-12 flex flex-col items-center justify-center">
      <div className="text-center mb-8">
        <h1 className="text-black text-[24px] md:text-[32px] font-bold">Agenda una visita con el anunciante</h1>
        <h3 className="text-black text-[20px] md:text-[24px] font-normal">Inmobiliaria Santa Fé</h3>
        <p className="text-black text-[20px] md:text-[24px] font-normal">Cód. del anunciante: 3H78F5 | Cód. de la propiedad: 35698536</p>
      </div>
      <div className="text-center mb-8">
        <h2 className="text-black text-[26px] md:text-[30px] font-semibold">CONFIRMACIÓN:</h2>
        <div className="flex flex-col md:flex-row justify-center items-center">
          <div className="flex items-center mb-2 md:mb-0 md:mr-4">
            <p className="text-black text-[20px] md:text-[24px] font-semibold">*FECHA:</p>
            <span className="text-black text-[18px] md:text-[20px] font-normal ml-2">Viernes 13 Mayo 204</span>
          </div>
          <div className="flex items-center">
            <p className="text-black text-[20px] md:text-[24px] font-semibold">*HORARIO:</p>
            <span className="text-black text-[18px] md:text-[20px] font-normal ml-2">Tarde 2pm a 4 pm</span>
          </div>
        </div>
      </div>
      <div className="flex flex-col md:flex-row space-y-4 md:space-y-0 md:space-x-28">
        <Link to="/detalle-de-vivienda">
          <button className="btn btn-wide bg-buttonColor text-white">Modificar</button>
        </Link>
        <Link to="/confirmar-cita">
          <button className="btn btn-wide bg-buttonColor2 text-white">Confirmar</button>
        </Link>
      </div>
    </section>
  );
}

export default Agenda;