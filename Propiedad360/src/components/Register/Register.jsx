import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { MdEmail, MdLock, MdPerson, MdPhone } from 'react-icons/md';
import { useUser } from '../../context/UserContext';
import { registrarHuesped, registrarAnfitrion } from '../../api/authApi';

const Register = () => {
    const [tipo, setTipo] = useState(null); // 'huesped' o 'anfitrion'
    const [nombre, setNombre] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [telefono, setTelefono] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);
    const { login: loginContext } = useUser();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!nombre || !username || !email || !telefono || !password) {
            setError('Por favor, complete todos los campos.');
            return;
        }

        try {
            setLoading(true);
            setError('');

            const datos = { nombre, username, email, telefono, contrasena: password };
            console.log('Datos a registrar:', datos); // Verifica los datos antes de enviarlos
            const response = tipo === 'huesped'
                ? await registrarHuesped(datos)
                : await registrarAnfitrion(datos);

            loginContext(response.data);
            navigate('/home');
        } catch (err) {
            setError('Error al registrarse. Intente nuevamente.');
        } finally {
            setLoading(false);
        }
    };

    // Selección de tipo de usuario
    if (!tipo) {
        return (
            <div className="bg-white pb-16">
                <div className="container mx-auto px-4 py-16 md:py-32">
                    <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                        Crear <span className="text-customColor2 font-bold">Cuenta</span>
                    </h1>
                    <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] mt-4">
                        ¿Cómo querés usar Propiedad360?
                    </p>
                </div>
                <div className="flex justify-center items-center gap-8 mb-14">
                    <div
                        className="card w-[580px] h-[300px] shadow-2xl bg-slate-300 cursor-pointer hover:bg-slate-400 transition-all"
                        onClick={() => setTipo('huesped')}
                    >
                        <div className="card-body flex flex-col justify-center items-center">
                            <h2 className="text-black font-bold text-[32px]">Soy Huésped</h2>
                            <p className="text-black text-[18px] text-center mt-4">
                                Busco propiedades para alquilar
                            </p>
                        </div>
                    </div>
                    <div
                        className="card w-[580px] h-[300px] shadow-2xl bg-slate-300 cursor-pointer hover:bg-slate-400 transition-all"
                        onClick={() => setTipo('anfitrion')}
                    >
                        <div className="card-body flex flex-col justify-center items-center">
                            <h2 className="text-black font-bold text-[32px]">Soy Anfitrión</h2>
                            <p className="text-black text-[18px] text-center mt-4">
                                Quiero publicar mi propiedad
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

    // Formulario de registro
    return (
        <div className="bg-white pb-16">
            <div className="container mx-auto px-4 py-16 md:py-32">
                <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                    Registro <span className="text-customColor2 font-bold">
                        {tipo === 'huesped' ? 'Huésped' : 'Anfitrión'}
                    </span>
                </h1>
                <p
                    className="text-customColor3 font-normal text-[18px] mt-4 cursor-pointer hover:underline"
                    onClick={() => setTipo(null)}
                >
                    ← Volver
                </p>
            </div>
            <div className="flex justify-center items-center mb-14">
                <div className="card w-[1206px] shadow-2xl bg-base-100">
                    <form className="card-body bg-slate-300 rounded-lg w-full h-full" onSubmit={handleSubmit}>
                        <div className="form-control">
                            <label className="flex items-center">
                                <MdEmail className="mr-4" size={32} color="black" />
                                <span className="label-text text-[32px] font-semibold text-black">Username</span>
                            </label>
                            <input
                                type="text"
                                placeholder="username"
                                className="input input-bordered text-slate-700 bg-white mt-4"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-control mt-8">
                            <label className="flex items-center">
                                <MdPerson className="mr-4" size={32} color="black" />
                                <span className="label-text text-[32px] font-semibold text-black">Nombre</span>
                            </label>
                            <input
                                type="text"
                                placeholder="nombre completo"
                                className="input input-bordered text-slate-700 bg-white mt-4"
                                value={nombre}
                                onChange={(e) => setNombre(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-control">
                            <label className="flex items-center">
                                <MdEmail className="mr-4" size={32} color="black" />
                                <span className="label-text text-[32px] font-semibold text-black">Email</span>
                            </label>
                            <input
                                type="email"
                                placeholder="email"
                                className="input input-bordered text-slate-700 bg-white mt-4"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-control">
                            <label className="flex items-center">
                                <MdPhone className="mr-4" size={32} color="black" />
                                <span className="label-text text-[32px] font-semibold text-black">Teléfono</span>
                            </label>
                            <input
                                type="tel"
                                placeholder="teléfono"
                                className="input input-bordered text-slate-700 bg-white mt-4"
                                value={telefono}
                                onChange={(e) => setTelefono(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-control">
                            <label className="flex items-center">
                                <MdLock className="mr-4" size={32} color="black" />
                                <span className="label-text text-[32px] font-semibold text-black">Contraseña</span>
                            </label>
                            <input
                                type="password"
                                placeholder="contraseña"
                                className="input input-bordered text-slate-700 bg-white mt-4"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required
                            />
                        </div>
                        {error && <p className="text-red-500 mt-4">{error}</p>}
                        <div className="form-control mt-9 flex justify-center items-center">
                            <button
                                type="submit"
                                className="btn btn-wide text-white bg-buttonColor"
                                disabled={loading}
                            >
                                {loading ? 'Cargando...' : 'Registrarse'}
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Register;