import React from 'react';
import img1 from '../MásPropiedadesCard/assets/img1.png';
import img2 from '../MásPropiedadesCard/assets/img2.png';
import img3 from '../MásPropiedadesCard/assets/img3.png';
import img4 from '../MásPropiedadesCard/assets/img4.png';
import img5 from '../MásPropiedadesCard/assets/img5.png';
import img6 from '../MásPropiedadesCard/assets/img6.png';

const MásPropiedadesCard = () => {
  return (
    <section className="mt-9">
      <div className="w-full sm:w-[447px] h-auto gap-16 bg-yellow-300 mx-auto md:ml-[250px] rounded-md px-4 py-6 md:p-8">
        <h1 className="text-black text-lg font-bold">Inmuebles</h1>
        <h2 className="text-black text-3xl font-bold">Más propiedades en tu ciudad</h2>
      </div>
      <div className="mt-9 flex flex-wrap justify-center items-start">
        <div className="w-[499px] h-[212px] mt-20 mr-9">
          <img src={img1} alt="" className="w-full h-full object-cover" />
        </div>
        <div className="flex flex-col items-center">
          <div className="w-[237px] h-[218px]">
            <img src={img2} alt="" className="w-full h-full object-cover" />
          </div>
          <div className="w-[237px] h-[218px] mt-4">
            <img src={img3} alt="" className="w-full h-full object-cover" />
          </div>
        </div>
        <div className="w-[291px] h-[454px] ml-8">
          <img src={img4} alt="" className="w-full h-full object-cover" />
        </div>
        <div className="flex flex-col items-center ml-8">
          <div className="w-[395px] h-[212px] mt-4">
            <img src={img5} alt="" className="w-full h-full object-cover" />
          </div>
          <div className="w-[395px] h-[218px] mt-4">
            <img src={img6} alt="" className="w-full h-full object-cover" />
          </div>
        </div>
      </div>
    </section>
  );
};

export default MásPropiedadesCard;