import React from 'react';
import Hero from '../../components/Hero/Hero';
import CardsPropiedad from '../../components/CardsPropiedad/CardsPropiedad';
import MásPropiedadesCard from '../../components/MásPropiedadesCard/MásPropiedadesCard';
import Testimonials from '../../components/Testimonials/Testimonials';


const Home = () => {
  return (
    <section className="bg-white">
      <Hero />
      <CardsPropiedad />
      <MásPropiedadesCard />
      <Testimonials />
    </section>
  )
}

export default Home;