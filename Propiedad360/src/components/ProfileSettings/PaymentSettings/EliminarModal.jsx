import React, { useState } from 'react';
import { FaTimes } from 'react-icons/fa';
import mastercad from './assets/mastercad.png';
import ConfirmarEliminacion from './ConfirmarElminacion'

const EliminarModal = ({ isOpen, onClose }) => {
  const [mostrarConfirmacion, setMostrarConfirmacion] = useState(false);

  const handleEliminarClick = () => {
    setMostrarConfirmacion(true); 
  };

  const handleRegresarClick = () => {
    setMostrarConfirmacion(false); 
  };

  return (
    <>
      {isOpen && !mostrarConfirmacion && ( 
        <div className="fixed inset-0 z-50 flex justify-center items-center bg-gray-700 bg-opacity-50">
          <div className="w-[1063px] h-[481px] bg-white rounded-lg p-8 relative">
            <div className="flex justify-between items-center mb-4">
              <h2 className="text-black text-[32px] font-bold">Eliminar tarjeta de crédito</h2>
              <FaTimes className="text-gray-500 cursor-pointer" onClick={onClose} />
            </div>
            <p className="text-black text-[24px] font-bold mb-4">Eliminar Mastercard que termina en **** 7894?</p>
            <div className="flex mb-4">
              <div className="w-[910px] h-[162px] bg-gray-200 rounded-lg mr-6 flex items-center">
                <img src={mastercad} alt="Mastercard" className="w-[130px] h-[90px] ml-9" />
                <div className="ml-9">
                  <p className="text-black text-[20px] font-bold">Mastercard</p>
                  <p className="text-black text-[16px]">Con terminación **** 7894</p>
                </div>
              </div>
            </div>
            <div className="flex justify-end mt-9">
                <button className="bg-buttonColor text-white px-4 py-2 rounded mr-4 cursor-pointer" onClick={onClose}>Cancelar</button>
                <button className="bg-buttonColor2 text-white px-4 py-2 rounded cursor-pointer" onClick={handleEliminarClick}>Eliminar</button>
              </div>
          </div>
        </div>
      )}
      <ConfirmarEliminacion isOpen={mostrarConfirmacion} onClose={handleRegresarClick} /> 
    </>
  );
}

export default EliminarModal;