import React, { useState } from 'react';
import { FaCreditCard, FaPlus, FaPen, FaTimes } from 'react-icons/fa';
import tarjeta from './assets/tarjeta.png';
import Modal from './Modal';
import EditModal from './EditModal';

const PaymentSettings = () => {
  const [showModal, setShowModal] = useState(false);
  const [showEditModal, setShowEditModal] = useState(false);

  const handleOpenModal = () => {
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
  };

  const handleOpenEditModal = () => {
    setShowEditModal(true);
  };

  const handleCloseEditModal = () => {
    setShowEditModal(false);
  };

  return (
    <section className="w-[1206px] h-[592px] bg-ConfiFondo mx-auto rounded-2xl mt-14">
      <div>
        <div className="text-center">
          <h1 className="text-black text-[48px] font-bold">Configuración de pagos</h1>
        </div>
        <div className="mt-8 ml-11">
          <h2 className="text-black text-[32px] font-bold">Tarjetas y cuentas</h2>
        </div>
        <div className="mt-6 flex items-center">
          <FaCreditCard className="mr-6 ml-10 w-[80px] h-[80px]" />
          <div className="flex items-center">
            <p className="text-black text-[20px] font-normal" onClick={handleOpenModal}>Agregar nuevo método de pago</p>
            <FaPlus className="ml-6 text-black cursor-pointer" onClick={handleOpenModal} />
          </div>
        </div>
        <div className="mt-9 flex items-center">
          <img src={tarjeta} alt="Tarjeta" className="w-[91px] h-[79px] mr-6 ml-10" />
          <p className="text-black text-[20px] font-normal" onClick={handleOpenEditModal}>Editar método de pago</p>
        </div>
        <div className="mt-2">
          <div className="flex items-center">
            <span className="text-black text-[20px] font-normal ml-10">Mastercard terminación **** 7894 </span>
            <FaPen className="ml-6 text-black cursor-pointer" onClick={handleOpenEditModal} />
          </div>
        </div>
        <div className="mt-16 flex justify-end mr-14">
          <button className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor text-white">
            Pagar alquiler
          </button>
        </div>
      </div>
      {showModal && <Modal isOpen={showModal} onClose={handleCloseModal} />}
      {showEditModal && <EditModal isOpen={showEditModal} onClose={handleCloseEditModal} />}
    </section>
  );
}

export default PaymentSettings;