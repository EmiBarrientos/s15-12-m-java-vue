import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import { LuUsers, LuHome, LuBuilding } from "react-icons/lu";
import { useInmueble } from '../../context/InmuebleContext';
import { useUser } from '../../context/UserContext';
import { publicarInmueble } from '../../api/propietarioApi';
import img1 from './assets/img1.png';
import img2 from './assets/img2.png';
import img3 from './assets/img3.png';
import img4 from './assets/img4.png';
import img5 from './assets/img5.png';
import img6 from './assets/img6.png';

const perfilIcono = {
    PROPIETARIO_PARTICULAR: <LuUsers className="w-16 h-16" />,
    AGENTE_INMOBILIARIO: <LuHome className="w-16 h-16" />,
    CONSTRUCTORA_DESARROLLADORA: <LuBuilding className="w-16 h-16" />
};

const perfilLabel = {
    PROPIETARIO_PARTICULAR: 'Propietario particular de inmueble',
    AGENTE_INMOBILIARIO: 'Agente inmobiliario / Inmobiliaria',
    CONSTRUCTORA_DESARROLLADORA: 'Constructora / Desarrolladora'
};

const RevisionPublicacion = () => {
    const { inmuebleData, resetInmueble } = useInmueble();
    console.log('inmuebleData:', inmuebleData);
    const { user } = useUser();
    const navigate = useNavigate();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');

    const handlePublicar = async () => {
        try {
            setLoading(true);
            setError('');
            await publicarInmueble(inmuebleData, user.id);
              console.log('Datos a publicar:', inmuebleData);
              console.log('User id:', user.id);
            resetInmueble();
            navigate('/publicacion-exitosa');
        } catch (err) {
            setError('Error al publicar el inmueble. Intente nuevamente.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <section className="bg-white">
            <div className="container mx-auto px-4 py-16 md:py-14">
                <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                    Revisión de <span className="text-customColor2 font-bold">Publicación</span>
                </h1>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px]">
                    Información, manejo de pagos, ajustes
                </p>

                <div className="flex flex-row">
                    <div>
                        <p className="text-[32px] text-customColor font-bold mt-12">Perfil</p>
                        <div className="card w-[314px] h-[197px] shadow-xl bg-[#F2C44E] text-customColor mt-4">
                            <div className="card-body items-center text-center">
                                {perfilIcono[inmuebleData.perfilUsuario]}
                                <p className="text-[22px]">{perfilLabel[inmuebleData.perfilUsuario]}</p>
                            </div>
                        </div>

                        <p className="text-[32px] text-customColor font-bold mt-12">Tipo de inmueble</p>
                        <p className="text-[32px] text-customColor">{inmuebleData.tipoInmueble}</p>

                        <div className="flex flex-row mt-44">
                            <p className="text-[32px] text-customColor font-bold">Recámaras</p>
                            <div className="ml-20">
                                <input readOnly type="text"  value={inmuebleData.numeroRecamaras} className="input w-[56px] rounded-md bg-white text-customColor text-center border-customColor" />
                            </div>
                        </div>

                        <p className="text-[32px] text-customColor font-bold mt-10">Superficie construida</p>
                        <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-4">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor">m2</button>
                            <input readOnly  value={inmuebleData.superficieConstruida} className="w-[186px] h-[60px] mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center" />
                        </div>
                    </div>

                    <div className="ml-32">
                        <p className="text-[32px] text-customColor font-bold mt-12">Operación</p>
                        <button className="btn w-[314px] h-[120px] bg-[#F2C44E] text-[32px] text-customColor mt-4">
                            {inmuebleData.tipoOperacion}
                        </button>

                        <p className="text-[32px] text-customColor font-bold mt-32">Ubicación</p>
                        <p className="text-[32px] text-customColor w-[708px]">
                            {inmuebleData.ubicacion}
                            <span className="font-bold block">(Se muestra aproximada en el mapa)</span>
                        </p>

                        <div className="flex flex-row mt-20">
                            <p className="text-[32px] text-customColor font-bold">Baños</p>
                            <div className="ml-20">
                                <input readOnly type="number" value={inmuebleData.numeroBanios} className="input w-[56px] rounded-md bg-white text-customColor text-center border-customColor" />
                            </div>
                        </div>

                        <p className="text-[32px] text-customColor font-bold mt-9">Superficie Terreno</p>
                        <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-4">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor">m2</button>
                            <input readOnly  value={inmuebleData.superficieTerreno} className="w-[186px] h-[60px] mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center" />
                        </div>
                    </div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">Descripción de la propiedad</p>
                <div className="w-[1142px] h-[594px] bg-[#E0E0E0] mt-4">
                    <div className="ml-10">
                        <br />
                        <p className="text-[32px] text-customColor font-bold">Título</p>
                        <input readOnly  value={inmuebleData.titulo} className="input w-[1080px] h-[49px] mt-6 bg-white border border-customColor4 rounded-md text-customColor" />
                        <p className="text-[32px] text-customColor font-bold mt-10">Descripción</p>
                        <textarea readOnly value={inmuebleData.descripcion} className="textarea textarea-bordered textarea-md w-[1081px] h-[272px] bg-[#F9F9F9] text-customColor" />
                    </div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-10">Fotografías</p>
                <div className="flex flex-nowrap">
                    <div className="w-[460px] h-[402px]">
                        <div className="flex flex-col">
                            <div className="mt-4"><img src={img1} /></div>
                            <div className="flex flex-row mt-5 h-[193px]">
                                <img src={img2} />
                                <img src={img3} className="ml-5" />
                            </div>
                        </div>
                    </div>
                    <div className="ml-5 w-[268px] h-[402px] mt-4"><img src={img4} /></div>
                    <div className="flex flex-col w-[364px] h-[402px] ml-5 mt-4">
                        <img src={img5} />
                        <img src={img6} className="mt-5" />
                    </div>
                </div>

                {error && <p className="text-red-500 mt-4">{error}</p>}

                <div className="flex flex-row-reverse mt-24">
                    <button
                        className="btn bg-[#179149] text-white w-[208px] h-[62px] rounded-[16px] mr-28"
                        onClick={handlePublicar}
                        disabled={loading}
                    >
                        {loading ? 'Publicando...' : 'Publicar'}
                    </button>
                    <button
                        className="btn bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] mr-10"
                        onClick={() => navigate('/caracteristicas-de-propiedad-vista')}
                    >
                        Modificar
                    </button>
                </div>
            </div>
        </section>
    );
}

export default RevisionPublicacion;