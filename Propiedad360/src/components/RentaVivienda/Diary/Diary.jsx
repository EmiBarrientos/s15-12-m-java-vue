import React, { useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './customDatepicker.css';

const Diary = ({ inmuebleId }) => {
    const [startDate, setStartDate] = useState(new Date());
    const [searchParams, setSearchParams] = useSearchParams();

    const handleFechaChange = (date) => {
        setStartDate(date);
        setSearchParams({ 
            id: inmuebleId, 
            fecha: date.toISOString().split('T')[0] 
        });
    };

    return (
        <section className="container mx-auto px-4 py-8 md:py-16 lg:py-32 flex flex-col mt-[-30px]">
            <h1 className="text-black text-lg md:text-xl lg:text-2xl font-bold mb-4 md:mb-6">Agenda una visita con el anunciante</h1>
            <h2 className="text-black text-base md:text-lg font-bold">Inmobiliaria Santa Fé</h2>
            <p className="text-black text-base md:text-lg font-sans mb-4 md:mb-6">Cód. del anunciante: 3H78F5 | Cód. de la propiedad: {inmuebleId}</p>
            <h2 className="text-black text-base md:text-lg font-bold mb-4 md:mb-9">Selecciona una fecha disponible:</h2>
            <div className="flex justify-center">
                <DatePicker
                    className="w-full md:w-[572px] h-[378px] md:h-[450px]"
                    selected={startDate}
                    onChange={handleFechaChange}
                    inline
                    calendarClassName="custom-datepicker"
                />
            </div>
        </section>
    );
}

export default Diary;