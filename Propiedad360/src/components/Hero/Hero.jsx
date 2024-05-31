import React, { useState, useEffect } from 'react';
import { FaSearch } from 'react-icons/fa';

import hero1 from './assets/hero1.png';
import hero2 from './assets/hero2.png';
import hero3 from './assets/hero3.png';

const slides = [hero1, hero2, hero3];

const Hero = () => {
    const [currentSlide, setCurrentSlide] = useState(0);

    useEffect(() => {
      const interval = setInterval(() => {
        setCurrentSlide((prevSlide) => (prevSlide + 1) % slides.length);
      }, 3000); 
  
      return () => clearInterval(interval);
    }, []);
  
    const goToSlide = (slideIndex) => {
      setCurrentSlide(slideIndex);
    };
  
  return (
    <section>
      <div className="relative mt-1">
        <input
          type="text"
          placeholder="Buscar propiedades..."
          className="w-full px-4 py-2 pl-10 bg-white border border-customColor4 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
        <FaSearch className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-500" />
      </div>
      <div className="carousel w-full mt-4">
        {slides.map((slide, index) => (
          <div
            key={index}
            id={`slide${index + 1}`}
            className={`carousel-item relative w-full ${index === currentSlide ? 'block' : 'hidden'}`}
          >
            <img src={slide} className="w-full" alt={`Slide ${index + 1}`} />
            <div className="absolute flex justify-between transform -translate-y-1/2 left-5 right-5 top-1/2">
              <button onClick={() => goToSlide((index - 1 + slides.length) % slides.length)} className="btn btn-circle">❮</button>
              <button onClick={() => goToSlide((index + 1) % slides.length)} className="btn btn-circle">❯</button>
            </div>
          </div>
        ))}
      </div>
    </section>
  )
}

export default Hero;