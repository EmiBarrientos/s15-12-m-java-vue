import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useInmueble } from '../../context/InmuebleContext';

const CaracteristicasPropiedad = () => {
    const { actualizarInmueble } = useInmueble();
    const navigate = useNavigate();
    const [recamaras, setRecamaras] = useState(0);
    const [banios, setBanios] = useState(0);
    const [superficieConstruida, setSuperficieConstruida] = useState(0);
    const [superficieTerreno, setSuperficieTerreno] = useState(0);
    const [antiguedad, setAntiguedad] = useState('A_ESTRENAR');
    const [precio, setPrecio] = useState(0);
    const [mantenimiento, setMantenimiento] = useState(0);
    const [titulo, setTitulo] = useState('');
    const [descripcion, setDescripcion] = useState('');

    const handleContinuar = () => {
        actualizarInmueble({
            numeroRecamaras: recamaras,
            numeroBanios: banios,
            superficieConstruida,
            superficieTerreno,
            antiguedad,
            precio,
            mantenimiento,
            titulo,
            descripcion
        });
        navigate('/caracteristicas-de-propiedad-vista');
    };

    return (
        <section className="bg-white">
            <div className="container mx-auto px-4 py-16 md:py-14">
                <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                    Publicación de <span className="text-customColor2 font-bold">Propiedad</span>
                </h1>

                <p className="text-[32px] text-customColor font-bold mt-12">Características principales</p>

                <div className="grid grid-cols-2 gap-4">
                    <div>
                        <p className="text-[24px] text-customColor">Recámaras</p>
                        <div className="flex justify-between bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-2">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor" onClick={() => setRecamaras(r => Math.max(0, r - 1))}>-</button>
                            <p className="text-[24px] text-customColor mt-5">{recamaras}</p>
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 mr-4 bg-[#F2C44E] text-[24px] text-customColor" onClick={() => setRecamaras(r => r + 1)}>+</button>
                        </div>
                    </div>
                    <div>
                        <p className="text-[24px] text-customColor">Baños</p>
                        <div className="flex justify-between bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-2">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor" onClick={() => setBanios(b => Math.max(0, b - 1))}>-</button>
                            <p className="text-[24px] text-customColor mt-5">{banios}</p>
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 mr-4 bg-[#F2C44E] text-[24px] text-customColor" onClick={() => setBanios(b => b + 1)}>+</button>
                        </div>
                    </div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">Superficie</p>
                <div className="grid grid-cols-2 gap-4 mt-2">
                    <div>
                        <p className="text-[24px] text-customColor">Superficie construida</p>
                        <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-2">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor">m2</button>
                            <input
                                placeholder="0"
                                className="w-[186px] h-[60px] mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center placeholder:text-customColor"
                                value={superficieConstruida}
                                onChange={(e) => setSuperficieConstruida(e.target.value)}
                            />
                        </div>
                    </div>
                    <div>
                        <p className="text-[24px] text-customColor">Superficie terreno</p>
                        <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-2">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor">m2</button>
                            <input
                                placeholder="0"
                                className="w-[186px] h-[60px] mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center placeholder:text-customColor"
                                value={superficieTerreno}
                                onChange={(e) => setSuperficieTerreno(e.target.value)}
                            />
                        </div>
                    </div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">Antigüedad</p>
                <div className="flex flex-row">
                    <input type="radio" name="radio-1" className="radio checked:bg-[#DE7E1F] border-[2.5px] border-customColor mt-2" onChange={() => setAntiguedad('A_ESTRENAR')} />
                    <div className="ml-3 text-[26px] text-customColor">A estrenar</div>
                </div>
                <div className="flex flex-row">
                    <input type="radio" name="radio-1" className="radio checked:bg-[#DE7E1F] border-[2.5px] border-customColor mt-2" onChange={() => setAntiguedad('ANIOS_DE_ANTIGUEDAD')} />
                    <div className="ml-3 text-[26px] text-customColor">Años de antigüedad</div>
                </div>
                <div className="flex flex-row">
                    <input type="radio" name="radio-1" className="radio checked:bg-[#DE7E1F] border-[2.5px] border-customColor mt-2" onChange={() => setAntiguedad('EN_CONSTRUCCION')} />
                    <div className="ml-3 text-[26px] text-customColor">En construcción</div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">Precio</p>
                <div className="grid grid-cols-2 gap-4 mt-2">
                    <div>
                        <p className="text-[24px] text-customColor">Precio del inmueble</p>
                        <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-2">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor">$</button>
                            <input
                                placeholder="0"
                                className="w-[186px] h-[60px] mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center placeholder:text-customColor"
                                value={precio}
                                onChange={(e) => setPrecio(e.target.value)}
                            />
                        </div>
                    </div>
                    <div>
                        <p className="text-[24px] text-customColor">Mantenimiento (opcional)</p>
                        <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-2">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor">$</button>
                            <input
                                placeholder="0"
                                className="w-[186px] h-[60px] mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center placeholder:text-customColor"
                                value={mantenimiento}
                                onChange={(e) => setMantenimiento(e.target.value)}
                            />
                        </div>
                    </div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">Descripción de la propiedad</p>
                <div className="w-[1142px] h-[594px] bg-[#E0E0E0] mt-7">
                    <br /><br />
                    <p className="text-[26px] text-customColor font-bold ml-12">Título</p>
                    <div className="w-full ml-9 mt-4">
                        <input
                            type="text"
                            placeholder="Completar el título de tu anuncio"
                            className="input w-[1080px] h-[49px] bg-white border border-customColor4 rounded-md text-customColor"
                            value={titulo}
                            onChange={(e) => setTitulo(e.target.value)}
                        />
                    </div>
                    <p className="text-[26px] text-customColor font-bold ml-12 mt-10">Descripción</p>
                    <textarea
                        placeholder="Escribe un mínimo de 150 caracteres"
                        className="textarea textarea-bordered textarea-sm w-[1081px] h-[272px] ml-7 mt-4 bg-[#F9F9F9] text-customColor"
                        value={descripcion}
                        onChange={(e) => setDescripcion(e.target.value)}
                    />
                </div>

                <div className="flex justify-end mt-20 mr-28">
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

export default CaracteristicasPropiedad;