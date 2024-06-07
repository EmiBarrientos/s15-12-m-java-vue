import React from 'react';
import { FaTimes } from 'react-icons/fa';

const Modal = ({ isOpen, onClose }) => {
  return (
    isOpen && (
      <div className="fixed inset-0 z-50 flex justify-center items-center bg-gray-700 bg-opacity-50">
        <div className="w-[1063px] h-[481px] bg-white rounded-lg p-8 relative">
          <div className="flex justify-between items-center mb-4">
            <h2 className="text-black text-[32px] font-bold">Añadir nueva tarjeta de crédito</h2>
            <FaTimes className="text-gray-500 cursor-pointer" onClick={onClose} />
          </div>
          <div className="mb-4 flex items-center">
            <label htmlFor="cardNumber" className="text-black text-[28px] font-medium mr-4">Número de tarjeta:</label>
            <input type="text" id="cardNumber" className="border border-gray-300 rounded px-3 py-2 bg-slate-200 text-black" value="0000 3232 4561 7894" readOnly />
          </div>
          <div className="mb-4 flex items-center">
            <label htmlFor="cardName" className="text-black text-[28px] font-medium mr-4">Nombre en la tarjeta:</label>
            <input type="text" id="cardName" className="border border-gray-300 rounded px-3 py-2 bg-slate-200 text-black" value="Javier Ferreyra Leiva" readOnly />
          </div>
          <div className="mb-4 flex items-center">
            <label htmlFor="expiration" className="text-black text-[28px] font-medium mr-4">Fecha vencimiento:</label>
            <div className="flex items-center">
              <select id="expirationMonth" className="border border-gray-300 rounded px-3 py-2 bg-slate-200 text-black mr-2">
                {[...Array(12)].map((_, index) => (
                  <option key={index + 1} value={index + 1}>{index + 1}</option>
                ))}
              </select>
              <span className="text-black text-[20px] font-medium"></span>
              <select id="expirationDay" className="border border-gray-300 rounded px-3 py-2 bg-slate-200 text-black ml-2">
                {[...Array(31)].map((_, index) => (
                  <option key={index + 1} value={index + 1}>{index + 1}</option>
                ))}
              </select>
            </div>
          </div>
          <div className="mb-4 flex items-center">
            <label htmlFor="securityCode" className="text-black text-[20px] font-medium mr-4">Código seguridad:</label>
            <input type="text" id="securityCode" className="border border-gray-300 rounded px-3 py-2 w-20 bg-slate-200 text-black" maxLength="3" />
          </div>
          <div className="flex justify-end">
            <button className="bg-buttonColor text-white px-4 py-2 rounded mr-4 cursor-pointer" onClick={onClose}>Cancelar</button>
            <button className="bg-buttonColor2 text-white px-4 py-2 rounded cursor-pointer">Agregar tarjeta</button>
          </div>
        </div>
      </div>
    )
  );
}

export default Modal;