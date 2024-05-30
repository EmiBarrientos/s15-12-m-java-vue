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
    <section  className="container mx-auto px-4 py-32">
        <RentYourNew />
        <div className="mt-4">
            <Mapa />
        </div>   
        <div> 
            <p className="text-[#191A18]">
               Hemos encontrado 15 propiedades en la ubicación seleccionada
            </p>
            <div className="grid grid-cols-3 gap-16">
                <Link to="/detalle-de-vivienda"> 
                    <div className="card w-50 cursor-pointer">
                        <figure className="px-10 pt-10">
                            <img src={img1} alt="Shoes" className="rounded-xl" />
                        </figure>
                        <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                            <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                            <p>Zona: Barrio Norte</p>
                            <p>$5200 mensuales</p>
                        </div>
                    </div>
                </Link>
                <div className="card w-50 cursor-pointer ">
                    <figure className="px-10 pt-10">
                        <img src={img2} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$4500 mensuales</p>
                    </div>
                </div>
                <div className="card w-50 cursor-pointer">
                    <figure className="px-10 pt-10">
                        <img src={img3} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$4300 mensuales</p>
                    </div>
                </div>        
            </div>
            <div className="grid grid-cols-3 gap-16">
                <div className="card w-50 cursor-pointer">
                    <figure className="px-10 pt-10">
                        <img src={img4} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$4200 mensuales</p>
                    </div>
                </div>
                <div className="card w-50 cursor-pointer">
                    <figure className="px-10 pt-10">
                        <img src={img5} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$5000 mensuales</p>
                    </div>
                </div>
                <div className="card w-50 cursor-pointer">
                    <figure className="px-10 pt-10">
                        <img src={img6} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$4800 mensuales</p>
                    </div>
                </div>        
            </div>
            <div className="grid grid-cols-3 gap-16">
                <div className="card w-50 cursor-pointer">
                    <figure className="px-10 pt-10">
                        <img src={img7} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$4600 mensuales</p>
                    </div>
                </div>
                <div className="card w-50 cursor-pointer">
                    <figure className="px-10 pt-10">
                        <img src={img8} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$3900 mensuales</p>
                    </div>
                </div>
                <div className="card w-50 cursor-pointer">
                    <figure className="px-10 pt-10">
                        <img src={img9} alt="Shoes" className="rounded-xl" />
                    </figure>
                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E]  rounded-tr-lg">
                        <p className="text-[#C3922E]">Apartamentos <br/> 2 habitaciones</p>
                        <p>Zona: Barrio Norte</p>
                        <p>$4000 mensuales</p>
                    </div>
                </div>        
            </div>
            <div className="ml-[500px] ">
                <button className="btn  bg-[#DE7E1F] w-[347px] h-[62px] mt-5 ">Ver más resultados</button>
            </div>
             <br/>
        </div>
    </section>
    );
  }
  
  export default CardsRentas;