import React from 'react';
import { FaSearch } from 'react-icons/fa';
import  RentYourNew from '../RentYourNew/RentYourNew'
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
        <RentYourNew />
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