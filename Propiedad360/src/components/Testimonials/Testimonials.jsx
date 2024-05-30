import React from 'react';
import testimonio1 from './assets/testimonio1.png';
import testimonio2 from './assets/testimonio2.png';
import ico1 from './assets/ico1.png';

const Testimonials = () => {
  return (
    <section className="w-full bg-customColor2 mt-9">
      <div className="container mx-auto px-4 py-32">
        <h1 className="text-slate-500 text-xl font-bold mr-20">Testimonios</h1>
        <h2 className="text-black text-4xl font-medium">Lo que dicen nuestros usuarios</h2>
        <div className="flex justify-center mt-9">
          <div className="card w-[540px] h-[241px] bg-white text-primary-content mx-2 relative">
            <div className="card-body">
              <div className="avatar absolute top-0 right-0 -mt-6">
                <div className="w-[74px] rounded-full">
                  <img src={testimonio1} alt="Testimonio 1" />
                </div>
              </div>
              <p>“Propiedades 360 es un sitio web excepcional para encontrar inmuebles en venta o alquiler.,su interfaz es fácil de usar. Los listados son detallados con descripciones claras y fotografías de alta calidad. Definitivamente, un recurso valioso para cualquier persona interesada en el mercado inmobiliario.”</p>
              <div className="card-actions justify-start">
                <span className="text-black text-2xl font-sans">Javier Artega</span>
              </div>
              <div><p className="text-slate-500">Agente inmobiliario</p></div>
              <div className="absolute bottom-0 right-0 mb-4 mr-4">
                <img src={ico1} alt="ico" className="w-[74px] h-[64px]" />
              </div>
            </div>
          </div>
          <div className="card w-[540px] h-[241px] ml-32 bg-white text-primary-content mx-2 relative">
            <div className="card-body">
              <div className="avatar absolute top-0 right-0 -mt-8">
                <div className="w-[74px] rounded-full">
                  <img src={testimonio2} alt="Testimonio 2" />
                </div>
              </div>
              <p>“Mi experiencia con Propiedades 360 fue excelente. Encontré un hogar  que se ajusta perfectamente a mis necesidades y presupuesto. El proceso de alquiler fue sencillo y transparente, Estoy muy satisfecha con mi nueva casa y  agradezco por hacer que este proceso fuera tan fácil y sin estrés”</p>
              <div className="card-actions justify-start">
                <span className="text-black text-2xl font-sans">Rebeca Ocampo</span>
              </div>
              <div><p className="text-slate-500">Alquiló su vivienda con nosotros</p></div>
              <div className="absolute bottom-0 right-0 mb-4 mr-4">
                <img src={ico1} alt="ico" className="w-[74px] h-[64px]" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Testimonials;