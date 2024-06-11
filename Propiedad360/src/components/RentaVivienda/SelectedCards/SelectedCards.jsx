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
       <div className="flex flex-nowrap justify-center">
                <div className="w-[460px] h-[402px]">
                    <div className="flex flex-col ...">
                        <div className="mt-4"> <img src={image1}  /></div>
                        <div>
                            <div className="flex flex-row mt-5 h-[193px]">
                                <div className=""><img src={image2}  /></div>
                                <div className="ml-12"><img src={image3}  /></div>     
                            </div>
                        </div>     
                    </div>
                </div>
                <div className="ml-12 w-[268px] h-[402px] mt-4">
                   <img src={image4}  /> 
                </div>
                <div>
                    <div className="flex flex-col w-[364px] h-[402px] ml-12 mt-4">
                        <div className=""><img src={image5}  /></div>
                        <div className="mt-5"><img src={image6}  /></div>     
                    </div>
                </div>
            </div>
            <div className="flex flex-nowrap justify-center mt-9">
                <div className="w-[460px] h-[402px]">
                    <div className="flex flex-col ...">
                        <div className="mt-4"> <img src={image7}  /></div>
                        <div>
                            <div className="flex flex-row mt-5 h-[193px]">
                                <div className=""><img src={image8}  /></div>
                                <div className="ml-12"><img src={image9}  /></div>     
                            </div>
                        </div>     
                    </div>
                </div>
                <div className="ml-12 w-[268px] h-[402px] mt-4">
                   <img src={image10}  /> 
                </div>
                <div>
                    <div className="flex flex-col w-[364px] h-[402px] ml-12 mt-4">
                        <div className=""><img src={image11}  /></div>
                        <div className="mt-5"><img src={image12}  /></div>     
                    </div>
                   
                </div>
            </div>
    </section>
  )
}

export default SelectedCards;