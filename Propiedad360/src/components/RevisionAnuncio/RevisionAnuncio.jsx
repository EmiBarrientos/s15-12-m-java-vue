import { useState } from 'react';
import { PiMapPin } from "react-icons/pi";
import DatePicker from 'react-datepicker';
import Property from '../RentaVivienda/Property/Property';
import SelectedCards from '../RentaVivienda/SelectedCards/SelectedCards';
import Map from '../RentaVivienda/Map/Map';
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
                <SelectedCards />
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
                <Map />
                <Property />
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
                <select className="select select-bordered bg-white text-black w-[1141px] ml-6">
                    <option value="" disabled defaultValue>Añade por lo menos 2 horarios diferentes</option>
                    <option value="manana" className="text-black text-lg md:text-xl lg:text-2xl">Mañana 10am a 12pm</option>
                    <option value="tarde" className="text-black text-lg md:text-xl lg:text-2xl">Tarde 2pm a 4pm</option>
                    <option value="noche" className="text-black text-lg md:text-xl lg:text-2xl">Tarde/Noche 5pm a 8pm</option>
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