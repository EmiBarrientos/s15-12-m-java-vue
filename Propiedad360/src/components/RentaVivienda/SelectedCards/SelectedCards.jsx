import React from 'react';

import image1 from './assets/image1.png';
import image2 from './assets/image2.png';
import image3 from './assets/image3.png';
import image4 from './assets/image4.png';
import image5 from './assets/image5.png';
import image6 from './assets/image6.png';
import image7 from './assets/image7.png';
import image8 from './assets/image8.png';
import image9 from './assets/image9.png';
import image10 from './assets/image10.png';
import image11 from './assets/image11.png';
import image12 from './assets/image12.png';

const SelectedCards = () => {
  return (
    <section className="mt-3">
      <div className="mt-9 flex flex-wrap justify-center items-start">
        <div className="w-[499px] h-[212px] mt-20 mr-9">
          <img src={image1} alt="" className="w-full h-full object-cover" />
        </div>
        <div className="flex flex-col items-center">
          <div className="w-[237px] h-[218px]">
            <img src={image2} alt="" className="w-full h-full object-cover" />
          </div>
          <div className="w-[237px] h-[218px] mt-4">
            <img src={image3} alt="" className="w-full h-full object-cover" />
          </div>
        </div>
        <div className="w-[291px] h-[454px] ml-8">
          <img src={image4} alt="" className="w-full h-full object-cover" />
        </div>
        <div className="flex flex-col items-center ml-8">
          <div className="w-[395px] h-[212px] mt-4">
            <img src={image5} alt="" className="w-full h-full object-cover" />
          </div>
          <div className="w-[395px] h-[218px] mt-4">
            <img src={image6} alt="" className="w-full h-full object-cover" />
          </div>
        </div>
      </div>
      <div className="mt-9 flex flex-wrap justify-center items-start">
        <div className="w-[499px] h-[212px] mt-20 mr-9">
          <img src={image7} alt="" className="w-full h-full object-cover" />
        </div>
        <div className="flex flex-col items-center">
          <div className="w-[237px] h-[218px]">
            <img src={image8} alt="" className="w-full h-full object-cover" />
          </div>
          <div className="w-[237px] h-[218px] mt-4">
            <img src={image9} alt="" className="w-full h-full object-cover" />
          </div>
        </div>
        <div className="w-[291px] h-[454px] ml-8">
          <img src={image10} alt="" className="w-full h-full object-cover" />
        </div>
        <div className="flex flex-col items-center ml-8">
          <div className="w-[395px] h-[212px] mt-4">
            <img src={image11} alt="" className="w-full h-full object-cover" />
          </div>
          <div className="w-[395px] h-[218px] mt-4">
            <img src={image12} alt="" className="w-full h-full object-cover" />
          </div>
        </div>
      </div>
    </section>
  )
}

export default SelectedCards;