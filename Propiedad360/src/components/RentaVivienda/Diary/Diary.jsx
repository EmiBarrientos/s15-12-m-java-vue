import React, { useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './customDatepicker.css'

const Diary = () => {
    const [startDate, setStartDate] = useState(new Date());
  return (
    <section className="container mx-auto px-4 py-32 flex flex-col mt-[-30px]">
      <h1 className="text-black text-[32px] font-bold mb-6">Agenda una visita con el anunciante</h1>
      <h2 className="text-black text-[24px] font-bold ">Inmobiliaria Santa Fé</h2>
      <p className="text-black text-[24px] font-sans mb-6">Cód. del anunciante: 3H78F5 | Cód. de la propiedad: 35698536</p>
      <h2 className="text-black text-[24px] font-bold mb-9">Selecciona una fecha disponible:</h2>
      <div className="flex justify-center">
        <DatePicker
          className="w-[572px] h-[378px]"
          selected={startDate}
          onChange={(date) => setStartDate(date)}
          inline
          calendarClassName="custom-datepicker"
        />
      </div>
    </section>
  )
}

export default Diary;