import img1 from './assets/img1.png';
import img2 from './assets/img2.png';
import img3 from './assets/img3.png';
import img4 from './assets/img4.png';
import img5 from './assets/img5.png';
import img6 from './assets/img6.png';
import img7 from './assets/img7.png';
import img8 from './assets/img8.png';
import img9 from './assets/img9.png';
import img10 from './assets/img10.png';
import img11 from './assets/img11.png';
import img12 from './assets/img12.png';
import { PiMapPin } from "react-icons/pi";
import DatePicker from 'react-datepicker';
import { useState } from 'react';
import './customDatepicker.css';


const RevisionAnuncio = () => {
    const [startDate, setStartDate] = useState(new Date());
    return ( 
        <section className="bg-white">
            <div className="container mx-auto px-4 py-16 md:py-14">
                <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                  Revisión de <span className="text-customColor2 font-bold">Anuncio</span>
                </h1>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
                    Puede ser modificado en cualquier momento
                </p> 

                <p className="text-[24px] text-customColor font-bold mt-12 ">
                    Publicación:
                </p>

                <div className="flex flex-nowrap">
                    <div className="w-[460px] h-[402px]">
                        <div className="flex flex-col ...">
                            <div className="mt-4"> <img src={img1}  /></div>
                            <div>
                                <div className="flex flex-row mt-5 h-[193px]">
                                    <div className=""><img src={img2}  /></div>
                                    <div className="ml-5"><img src={img3}  /></div>     
                                </div>
                            </div>     
                        </div>
                    </div>

                    <div className="ml-5 w-[268px] h-[402px] mt-4">
                    <img src={img4}  /> 
                    </div>

                    <div>
                        <div className="flex flex-col w-[364px] h-[402px] ml-5 mt-4">
                            <div className=""><img src={img5}  /></div>
                            <div className="mt-5"><img src={img6}  /></div>     
                        </div>
                    
                    </div>
                </div>

                <div className="flex flex-nowrap mt-7">
                    <div className="w-[460px] h-[402px]">
                        <div className="flex flex-col ...">
                            <div className="mt-4"> <img src={img7}  /></div>
                            <div>
                                <div className="flex flex-row mt-5 h-[193px]">
                                    <div className=""><img src={img8}  /></div>
                                    <div className="ml-5"><img src={img9}  /></div>     
                                </div>
                            </div>     
                        </div>
                    </div>

                    <div className="ml-5 w-[268px] h-[402px] mt-4">
                    <img src={img10}  /> 
                    </div>

                    <div>
                        <div className="flex flex-col w-[364px] h-[402px] ml-5 mt-4">
                            <div className=""><img src={img11}  /></div>
                            <div className="mt-5"><img src={img12}  /></div>     
                        </div>
                    
                    </div>
                </div>

                <p className="text-[36px] text-customColor font-bold mt-16 ">
                    Departamento · 110m² · 2 recámaras · 2 estacionamientos
                </p>

                <p className="text-[24px] text-customColor font-bold mt-3 ">
                    Renta $5.200    Zona: Barrio Norte
                </p>

                <div className="flex flex-row ...">
                    <div className='mt-5' style={{color:'#1A1A1A'}}><PiMapPin  className='w-6 h-6'/></div>
                    <div className="ml-4 mt-3 text-[24px] text-customColor">Avenida Santa Fe 2755 Piso 7º 1425, Ciudad autónoma de Buenos Aires</div>
                </div>

                <p>falt mapa</p>

                <p className="text-customColor font-bold text-[32px] mt-8 ml-10">Conoce más sobre este <span className="text-customColor2 text-[32px]">inmueble</span></p>
                <footer className="footer mt-6 p-10 text-neutral-content bg-ConfiFondo">
                    <div className="container mx-auto grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-10">
                        <nav className="flex flex-col">
                            <h6 className="text-black text-[24px] font-bold mb-6">Generalidades</h6> 
                            <a className="text-[20px] text-black mb-3">2 Habitaciones</a>
                            <a className="text-[20px] text-black mb-3">Cocina equipada</a>
                            <a className="text-[20px] text-black mb-3">Cuarto de Lavado</a>
                            <a className="text-[20px] text-black mb-3">Amueblado</a>
                        </nav> 
                        <nav className="flex flex-col">
                            <h6 className="text-black text-[24px] font-bold mb-6">Servicios</h6> 
                            <a className="text-[20px] text-black mb-3">Línea blanca</a>
                            <a className="text-[20px] text-black mb-3">Servicios básicos</a>
                            <a className="text-[20px] text-black mb-3">Internet alta velocidad</a>
                        </nav> 
                        <nav className="flex flex-col">
                            <h6 className="text-black text-[24px] font-bold mb-6">Amenidades</h6> 
                            <a className="text-[20px] text-black mb-3">Gimnasio</a>
                            <a className="text-[20px] text-black mb-3">Piscina</a>
                            <a className="text-[20px] text-black mb-3">Área de juegos infantiles</a>
                            <a className="text-[20px] text-black mb-3">Seguridad privada</a>
                        </nav>
                        <nav className="flex flex-col">
                            <h6 className="text-black text-[24px] font-bold mb-6">Exteriores</h6> 
                            <a className="text-[20px] text-black mb-3">Estacionamientos</a>
                            <a className="text-[20px] text-black mb-3">Áreas verdes</a>
                            <a className="text-[20px] text-black mb-3">Salón de usos múltiples</a>
                        </nav>
                    </div>
                </footer>

                <p className="text-customColor text-[32px] font-bold mb-4 md:mb-6 ml-8 mt-8">Agenda una visita con el anunciante</p>
                <p className="text-customColor text-[24px] font-bold ml-8 ">Inmobiliaria Santa Fé</p>
                <ul className="list-disc ml-20">
                    <li className="text-[24px] text-customColor">
                      Cód. del anunciante: 3H78F5 | Cód. de la propiedad: 35698536
                    </li>
                </ul>

                <p className="text-customColor text-[24px] font-bold mb-4 md:mb-9 ml-8 mt-8">Selecciona una fecha disponible para visitas:</p>
                <div className="flex justify-center">
                    <DatePicker
                        className="w-full md:w-[572px] h-[378px] md:h-[450px]"
                        selected={startDate}
                        onChange={(date) => setStartDate(date)}
                        inline
                        calendarClassName="custom-datepicker"
                    />
                </div>

                <p className="text-customColor text-[24px] font-bold mb-4 md:mb-9 ml-8 mt-8">Añador horarios disponibles para visitas:</p>
                <div className="w-[1207px] h-[310px] bg-[#E0E0E0] pt-9">
                    <select className="select select-bordered bg-white text-black w-[1141px] ml-6  ">
                    <option className="text-black text-lg md:text-xl lg:text-2xl" disabled selected>Añade por los menos 2 horarios diferentes</option>
                    <option className="text-black text-lg md:text-xl lg:text-2xl">Mañana 10am a 12pm</option>
                    <option className="text-black text-lg md:text-xl lg:text-2xl">Tarde 2pm a 4pm</option>
                    <option className="text-black text-lg md:text-xl lg:text-2xl">Tarde/Noche 5pm a 8pm</option>
                    </select>
                </div>

                <div className="flex flex-row-reverse mt-24">
                    <div>
                       
                        <button className="btn  bg-[#179149] text-white w-[208px] h-[62px] rounded-[16px] mr-10">Guardar fechas</button>  

                    </div>
                    <div>
                       
                        <button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] mr-10">Modificar</button>    
                    </div>
                
                </div>
            </div>

        </section>
     )
}

export default RevisionAnuncio;