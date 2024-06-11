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
      <div className="flex flex-nowrap justify-center">
                <div className="w-[460px] h-[402px]">
                    <div className="flex flex-col ...">
                        <div className="mt-4"> <img src={img1}  /></div>
                        <div>
                            <div className="flex flex-row mt-5 h-[193px]">
                                <div className=""><img src={img2}  /></div>
                                <div className="ml-12"><img src={img3}  /></div>     
                            </div>
                        </div>     
                    </div>
                </div>
                <div className="ml-12 w-[268px] h-[402px] mt-4">
                   <img src={img4}  /> 
                </div>
                <div>
                    <div className="flex flex-col w-[364px] h-[402px] ml-12 mt-4">
                        <div className=""><img src={img5}  /></div>
                        <div className="mt-5"><img src={img6}  /></div>     
                    </div>
                </div>
            </div>
    </section>
  );
};

export default MásPropiedadesCard;