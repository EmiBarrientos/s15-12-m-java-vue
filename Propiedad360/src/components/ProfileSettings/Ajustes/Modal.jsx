import React from 'react';

const Modal = ({ message, onClose }) => {
  return (
    <div className="fixed inset-0 flex items-center justify-center z-50">
      <div className="bg-white rounded-lg p-8 shadow-lg">
        <p className="text-lg text-black">{message}</p>
        <div className="mt-4 flex justify-center">
          <button onClick={onClose} className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor text-white">Aceptar</button>
        </div>
      </div>
    </div>
  );
};

export default Modal;