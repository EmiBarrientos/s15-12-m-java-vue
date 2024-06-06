import React, { useState } from 'react';
import { FaUser, FaEnvelope, FaLock } from 'react-icons/fa';
import Modal from './Modal';
import perfil from './assets/perfil.png';

const Ajuste = () => {
  const [editable, setEditable] = useState(false);
  const [nombre, setNombre] = useState("Javier Ferreyra Leiva");
  const [email, setEmail] = useState("ferreyra_javier@mailito.com");
  const [password, setPassword] = useState("********");
  const [showModal, setShowModal] = useState(false);
  const [confirmationMessage, setConfirmationMessage] = useState("");

  const handleEdit = () => {
    setEditable(true);
  };

  const handleChange = (e, field) => {
    const value = e.target.value;
    if (field === 'nombre') setNombre(value);
    if (field === 'email') setEmail(value);
    if (field === 'password') setPassword(value);
  };

  const handleConfirm = () => {
    const confirmMessage = `¿Estás seguro de cambiar los datos?
                           Nombre: ${nombre}
                           Email: ${email}
                           Contraseña: ${password}`;
    setConfirmationMessage(confirmMessage);
    setShowModal(true);
    setEditable(false);
  };

  const closeModal = () => {
    setShowModal(false);
  };

  return (
    <section className="relative w-[1206px] h-[767px] bg-slate-200 mt-36 mx-auto border rounded-2xl">
      <form action="" className="relative">
        <div className="absolute -left-24 -top-28">
          <div className="w-[250px] h-[250px] rounded-full overflow-hidden">
            <img src={perfil} alt="Avatar" />
          </div>
        </div>
        <h1 className="text-black text-[48px] font-bold text-center">Ajustes de perfil</h1>
        <div className="mt-28 space-y-6">
          <div className="mb-6">
            <div className="flex items-center">
              <FaUser className="inline-block mr-3 text-[32px]" />
              <span className="text-black text-[32px] font-bold">Nombre:</span>
            </div>
            {editable ? (
              <input
                type="text"
                value={nombre}
                onChange={(e) => handleChange(e, 'nombre')}
                className="bg-white w-[1141px] h-[51px] border rounded-xl text-slate-500 text-[24px] mt-2 ml-10"
              />
            ) : (
              <span onClick={handleEdit} className="ml-10 cursor-pointer">{nombre}</span>
            )}
          </div>
          <div className="mb-6">
            <div className="flex items-center">
              <FaEnvelope className="inline-block mr-3 text-[32px]" />
              <span className="text-black text-[32px] font-bold">Email:</span>
            </div>
            {editable ? (
              <input
                type="email"
                value={email}
                onChange={(e) => handleChange(e, 'email')}
                className="bg-white w-[1141px] h-[51px] border rounded-xl text-slate-500 text-[24px] mt-2 ml-10"
              />
            ) : (
              <span onClick={handleEdit} className="ml-10 cursor-pointer">{email}</span>
            )}
          </div>
          <div className="mb-6">
            <div className="flex items-center">
              <FaLock className="inline-block mr-3 text-[32px]" />
              <span className="text-black text-[32px] font-bold">Contraseña:</span>
            </div>
            {editable ? (
              <input
                type="password"
                value={password}
                onChange={(e) => handleChange(e, 'password')}
                className="bg-white w-[1141px] h-[51px] border rounded-xl text-slate-500 text-[24px] mt-2 ml-10"
              />
            ) : (
              <span onClick={handleEdit} className="ml-10 cursor-pointer">{password}</span>
            )}
          </div>
          {editable && (
            <div className="text-center mt-16">
              <button onClick={handleConfirm} className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor text-white mx-auto">Aplicar cambios</button>
            </div>
          )}
        </div>
      </form>
      {showModal && <Modal message={confirmationMessage} onClose={closeModal} />}
    </section>
  );
}

export default Ajuste;