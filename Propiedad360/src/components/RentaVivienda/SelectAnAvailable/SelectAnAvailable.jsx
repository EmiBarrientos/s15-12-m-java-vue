import React from 'react';

const SelectAnAvailable = () => {
  return (
    <section className="container mx-auto px-4 py-8 md:py-16 lg:py-32 mt-[-100px]">
      <h1 className="text-black font-bold text-lg md:text-xl lg:text-2xl mb-6">Selecciona un horario disponible:</h1>
      <div>
        <select className="select select-bordered bg-white text-black w-full p-2">
          <option value="" disabled defaultValue>Selecciona una opción</option>
          <option value="manana" className="text-black text-lg md:text-xl lg:text-2xl">Mañana 10am a 12pm</option>
          <option value="tarde" className="text-black text-lg md:text-xl lg:text-2xl">Tarde 2pm a 4pm</option>
          <option value="noche" className="text-black text-lg md:text-xl lg:text-2xl">Tarde/Noche 5pm a 8pm</option>
        </select>
      </div>
    </section>
  );
}

export default SelectAnAvailable;