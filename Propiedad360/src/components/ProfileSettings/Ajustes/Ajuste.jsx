import React, { useState } from 'react';
import { FaUser, FaEnvelope, FaLock } from 'react-icons/fa';
import { useUser } from '../../../context/UserContext';
import { actualizarPerfil } from '../../../api/usuarioApi';
import perfil from './assets/perfil.png';

const Ajuste = () => {
    const { user, login: loginContext } = useUser();
    const [editable, setEditable] = useState(false);
    const [nombre, setNombre] = useState(user?.nombre || '');
    const [email, setEmail] = useState(user?.email || '');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');
    const [exito, setExito] = useState(false);

    const handleConfirm = async () => {
        try {
            setLoading(true);
            setError('');
            const response = await actualizarPerfil({
                ...user,
                nombre,
                email,
                contrasena: password || user.contrasena
            });
            loginContext(response.data);
            setExito(true);
            setEditable(false);
        } catch (err) {
            setError('Error al actualizar el perfil.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <section className="relative w-[1206px] h-[767px] bg-slate-200 mt-36 mx-auto border rounded-2xl">
            <form className="relative">
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
                                onChange={(e) => setNombre(e.target.value)}
                                className="bg-white w-[1141px] h-[51px] border rounded-xl text-slate-500 text-[24px] mt-2 ml-10"
                            />
                        ) : (
                            <span onClick={() => setEditable(true)} className="ml-10 cursor-pointer">{nombre}</span>
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
                                onChange={(e) => setEmail(e.target.value)}
                                className="bg-white w-[1141px] h-[51px] border rounded-xl text-slate-500 text-[24px] mt-2 ml-10"
                            />
                        ) : (
                            <span onClick={() => setEditable(true)} className="ml-10 cursor-pointer">{email}</span>
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
                                placeholder="Nueva contraseña"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                className="bg-white w-[1141px] h-[51px] border rounded-xl text-slate-500 text-[24px] mt-2 ml-10"
                            />
                        ) : (
                            <span onClick={() => setEditable(true)} className="ml-10 cursor-pointer">********</span>
                        )}
                    </div>
                    {error && <p className="text-red-500 ml-10">{error}</p>}
                    {exito && <p className="text-green-500 ml-10">Perfil actualizado correctamente.</p>}
                    {editable && (
                        <div className="text-center mt-16">
                            <button
                                type="button"
                                onClick={handleConfirm}
                                className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor text-white mx-auto"
                                disabled={loading}
                            >
                                {loading ? 'Guardando...' : 'Aplicar cambios'}
                            </button>
                        </div>
                    )}
                </div>
            </form>
        </section>
    );
}

export default Ajuste;