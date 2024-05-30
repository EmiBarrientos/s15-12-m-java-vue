import React from 'react';
import { FaSearch } from 'react-icons/fa';
import SelectedCards from './SelectedCards/SelectedCards'; 
import Descripción from './Descripción/Descripción';
import Map from './Map/Map';
import Property from './Property/Property'
import Diary from './Diary/Diary';
import SelectAnAvailable from './SelectAnAvailable/SelectAnAvailable';
import Message from './Message/Message';

const RentaVivienda = () => {
  return (
    <section className="w-full">
      <div className="container mx-auto px-4 py-32">
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
        <div className="mt-24">
          <p className="text-black text-[24px]">Propiedad seleccionada:</p>
        </div>
      </div>
      <SelectedCards />
      <Descripción />
      <Map />
      <Property />
      <Diary />
      <SelectAnAvailable/>
      <Message />
    </section>
  );
}

export default RentaVivienda;