import React from 'react';

const SelectAnAvailable = () => {
  return (
    <section className="container mx-auto px-4 py-32 mt-[-100px]">
      <h1 className="text-black font-bold text-[24px] mb-6">Selecciona un horario disponible:</h1>
      <div>
        <select className="select select-bordered bg-white text-black w-full p-2">
          <option className="text-black text-[24px]" disabled selected>Selecciona una opción</option>
          <option className="text-black text-[24px]">Mañana 10am a 12pm</option>
          <option className="text-black text-[24px]">Tarde 2pm a 4pm</option>
          <option className="text-black text-[24px]">Tarde/Noche 5pm a 8pm</option>
        </select>
      </div>
    </section>
  );
}

export default SelectAnAvailable;