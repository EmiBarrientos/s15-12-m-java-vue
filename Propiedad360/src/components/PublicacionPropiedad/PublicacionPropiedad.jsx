import React, { useState } from 'react';
import { LuUsers } from "react-icons/lu";
import { CiHome } from "react-icons/ci";
import { PiCodepenLogoThin } from "react-icons/pi";
import { useNavigate } from "react-router-dom";
import { useInmueble } from '../../context/InmuebleContext';

const PublicacionPropiedad = () => {
    const { actualizarInmueble } = useInmueble();
    const navigate = useNavigate();
    const [perfilUsuario, setPerfilUsuario] = useState('');
    const [tipoOperacion, setTipoOperacion] = useState('');
    const [tipoInmueble, setTipoInmueble] = useState('');
    const [ubicacion, setUbicacion] = useState('');

    const handleContinuar = () => {
        actualizarInmueble({ perfilUsuario, tipoOperacion, tipoInmueble, ubicacion });
        navigate('/caracteristicas-de-propiedad');
    };

    return (
        <section>
            <div className="container mx-auto px-4 py-16 md:py-14">
                <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                    Publicación de <span className="text-customColor2 font-bold">Propiedad</span>
                </h1>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px]">
                    Gratis y en simples pasos
                </p>

                <p className="text-[32px] text-customColor font-bold mt-12">
                    Selecciona el perfil que más se ajuste a tus necesidades
                </p>

                <div className="grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-x-96 pt-7">
                    <div
                        className={`card w-[314px] h-[197px] shadow-xl cursor-pointer ${perfilUsuario === 'PROPIETARIO_PARTICULAR' ? 'bg-[#F2C44E]' : 'bg-[#E0E0E0]'} text-customColor`}
                        onClick={() => setPerfilUsuario('PROPIETARIO_PARTICULAR')}
                    >
                        <div className="card-body items-center text-center">
                            <LuUsers className="w-16 h-16" />
                            <p className="text-[22px]">Propietario particular de inmueble</p>
                        </div>
                    </div>

                    <div
                        className={`card w-[314px] h-[197px] shadow-xl cursor-pointer ${perfilUsuario === 'AGENTE_INMOBILIARIO' ? 'bg-[#F2C44E]' : 'bg-[#E0E0E0]'} text-customColor`}
                        onClick={() => setPerfilUsuario('AGENTE_INMOBILIARIO')}
                    >
                        <div className="card-body items-center text-center">
                            <CiHome className="w-16 h-16" />
                            <p className="text-[22px]">Agente inmobiliario / Inmobiliaria</p>
                        </div>
                    </div>

                    <div
                        className={`card w-[314px] h-[197px] shadow-xl cursor-pointer ${perfilUsuario === 'CONSTRUCTORA_DESARROLLADORA' ? 'bg-[#F2C44E]' : 'bg-[#E0E0E0]'} text-customColor`}
                        onClick={() => setPerfilUsuario('CONSTRUCTORA_DESARROLLADORA')}
                    >
                        <div className="card-body items-center text-center">
                            <PiCodepenLogoThin className="w-16 h-16" />
                            <p className="text-[22px]">Constructora / Desarrolladora</p>
                        </div>
                    </div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">Tipo de operación a realizar</p>

                <button
                    className={`btn w-[314px] h-[120px] text-[32px] text-customColor mt-4 ${tipoOperacion === 'VENTA' ? 'bg-[#F2C44E]' : 'bg-[#E0E0E0]'}`}
                    onClick={() => setTipoOperacion('VENTA')}
                >VENTA</button>
                <button
                    className={`btn ml-24 w-[314px] h-[120px] text-[32px] text-customColor mt-4 ${tipoOperacion === 'RENTA' ? 'bg-[#F2C44E]' : 'bg-[#E0E0E0]'}`}
                    onClick={() => setTipoOperacion('RENTA')}
                >RENTA</button>

                <p className="text-[32px] text-customColor font-bold mt-12">Tipo de inmueble</p>

                <div className="bg-[#E0E0E0] w-[1142px] h-[776px] rounded-lg mt-6">
                    <select
                        className="select select-bordered bg-white text-black w-[1059px] mt-9 mx-8"
                        value={tipoInmueble}
                        onChange={(e) => setTipoInmueble(e.target.value)}
                    >
                        <option value="" disabled>Selecciona una opción</option>
                        <option value="CASA">Casa</option>
                        <option value="DEPARTAMENTO">Departamento</option>
                        <option value="EDIFICIO">Edificio</option>
                        <option value="LOCAL_COMERCIAL">Local comercial</option>
                        <option value="TERRENO">Terreno</option>
                    </select>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">Ubicación</p>

                <div className="bg-[#E0E0E0] w-[1142px] h-[236px] rounded-lg mt-6">
                    <br />
                    <div className="flex justify-start ml-7">
                        <CiHome className="w-10 h-10 text-customColor" />
                        <span className="text-[#191A18] text-[32px] font-bold">Ingresar la dirección completa</span>
                    </div>
                    <div className="w-full ml-7 mt-4">
                        <input
                            type="text"
                            placeholder="Ingresa dirección"
                            className="input w-[1080px] h-[49px] bg-white border border-customColor4 rounded-md text-customColor"
                            value={ubicacion}
                            onChange={(e) => setUbicacion(e.target.value)}
                        />
                    </div>
                </div>

                <div className="flex justify-end">
                    <button
                        className="btn bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px]"
                        onClick={handleContinuar}
                    >
                        Continuar
                    </button>
                </div>
            </div>
        </section>
    );
}

export default PublicacionPropiedad;