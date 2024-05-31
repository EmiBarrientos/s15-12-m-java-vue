import React from 'react';
import { Link } from 'react-router-dom';

import RentYourNew from '../RentYourNew/RentYourNew';
import Mapa from '../CardsRentas/Mapa/Map';

import img1 from '../CardsRentas/assets/img01.png';
import img2 from '../CardsRentas/assets/img02.png';
import img3 from '../CardsRentas/assets/img03.png';
import img4 from '../CardsRentas/assets/img04.png';
import img5 from '../CardsRentas/assets/img05.png';
import img6 from '../CardsRentas/assets/img06.png';
import img7 from '../CardsRentas/assets/img07.png';
import img8 from '../CardsRentas/assets/img08.png';
import img9 from '../CardsRentas/assets/img09.png';

function CardsRentas() {
  return (
    <section className="container mx-auto px-4 py-8 md:py-16 lg:py-24">
      <RentYourNew />
      <div className="mt-8 md:mt-12">
        <Mapa />
      </div>
      <div className="mt-8">
        <p className="text-[#191A18] text-[24px] mb-4 md:mb-6">
          Hemos encontrado 15 propiedades en la ubicación seleccionada
        </p>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 md:gap-12">
          {[img1, img2, img3, img4, img5, img6, img7, img8, img9].map((img, index) => (
            <Link to="/detalle-de-vivienda" key={index}>
              <div className="card cursor-pointer">
                <figure className="px-6 pt-6 md:px-10 md:pt-10">
                  <img src={img} alt={`Property ${index + 1}`} className="rounded-xl" />
                </figure>
                <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E] rounded-tr-lg p-4 md:p-6 lg:p-8">
                  <p className="text-[#C3922E] mb-2 md:mb-4">Apartamentos <br /> 2 habitaciones</p>
                  <p className="mb-2 md:mb-4">Zona: Barrio Norte</p>
                  <p className="mb-2 md:mb-4">$5200 mensuales</p>
                </div>
              </div>
            </Link>
          ))}
        </div>
      </div>
      <div className="flex justify-center mt-8">
        <button className="btn bg-[#DE7E1F] text-white w-full md:w-auto lg:w-[347px] h-[62px]">
          Ver más resultados
        </button>
      </div>
    </section>
  );
}

export default CardsRentas;