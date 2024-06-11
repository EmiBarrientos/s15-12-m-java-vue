import React from 'react';
import { Link } from 'react-router-dom';
import maste from './assets/maste.png';

const Pay = () => {
  return (
    <section className="bg-slate-200 mx-auto px-4 py-16 md:py-32 mb-12 flex flex-col items-center">
      <div className="w-full ml-[490px]">
        <h1 className="text-black text-[32px] font-bold text-left">Pago</h1>
      </div>
      <div className="w-full text-left mt-4 ml-[490px]">
        <p className="text-black text-[24px]">Ximena Altamirano (Inquilino)</p>
        <p className="text-black text-[24px]">Cód. de la propiedad: 35698536</p>
      </div>
      <div className="w-full flex justify-between items-start mt-4">
        <div className="flex flex-col ml-[240px]">
          <h2 className="text-black text-[24px] font-semibold">Seleccionar método de pago</h2>
          <div className="flex items-center mt-2">
            <img src={maste} alt="tarjeta" className="mr-2" />
            <div>
              <p className="text-black text-[20px]">Tarjeta de crédito</p>
              <p className="text-black text-[20px]">Mastercard terminación **** 7894</p>
            </div>
          </div>
        </div>
        
      </div>
      <div className="mt-8 flex space-x-28">
        <Link to="/configuración-de-perfil" className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor  text-white">Regresar</Link>
        <Link to="/revisa-tu-pago" className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor2 text-white text-center py-2 px-4 rounded">
          Confirmar
        </Link>
      </div>
    </section>
  );
}

export default Pay;