import React from 'react';
import { FaSearch } from 'react-icons/fa';

const RentYourNew = () => {
  return (
    <section className="py-12 md:py-16 lg:py-20">
      <h1 className="text-black font-bold text-4xl md:text-5xl lg:text-6xl">Alquila tu nuevo <span className="text-customColor2 font-bold">Hogar</span></h1>
      <p className="text-customColor3 font-normal text-lg md:text-xl lg:text-2xl mt-4 md:mt-6 lg:mt-8">Revisa posibles propiedades en la zona seleccionada</p>
      <div className="relative mt-4 md:mt-6 lg:mt-8">
        <input
          type="text"
          placeholder="Buenos Aires, Argentina..."
          className="w-full px-4 py-3 md:py-4 lg:py-5 pl-10 bg-white border border-customColor4 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-base md:text-lg lg:text-xl"
        />
        <FaSearch className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-500" />
      </div>
    </section>
  );
}

export default RentYourNew;