import React from 'react'
import { FaSearch } from 'react-icons/fa';

const RentYourNew = () => {
  return (
    <section>
        <h1 className="text-black font-bold text-[64px]">Alquila tu nuevo <span className="text-customColor2 font-bold text-[64px]">Hogar</span></h1>
        <p className="text-customColor3 font-normal text-[24px]">Revisa posibles propiedades en la zona seleccionada</p>
        <div className="relative mt-4">
          <input
            type="text"
            placeholder="Buenos Aires, Argentina..."
            className="w-full px-4 py-2 pl-10 bg-white border border-customColor4 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
          <FaSearch className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-500" />
        </div>
    </section>
  )
}

export default RentYourNew;