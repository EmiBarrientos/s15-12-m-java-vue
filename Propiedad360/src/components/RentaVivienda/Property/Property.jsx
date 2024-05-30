import React from 'react';

const Property = () => {
  return (
    <section className="mt-9">
        <h1 className="text-black font-bold text-[32px] text-center">Conoce más sobre este <span className="text-customColor2 text-[32px]">inmueble</span></h1>
        <footer className="footer mt-6 p-10 text-neutral-content bg-yellow-200 opacity-50">
            <div className="container mx-auto grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-10">
                <nav className="flex flex-col">
                    <h6 className="footer-title text-black text-[24px] font-bold mb-6">Generalidades</h6> 
                    <a className="text-[20px] text-black mb-3">2 Habitaciones</a>
                    <a className="text-[20px] text-black mb-3">Cocina equipada</a>
                    <a className="text-[20px] text-black mb-3">Cuarto de Lavado</a>
                    <a className="text-[20px] text-black mb-3">Amueblado</a>
                </nav> 
                <nav className="flex flex-col">
                    <h6 className="footer-title text-black text-[24px] font-bold mb-6">Servicios</h6> 
                    <a className="text-[20px] text-black mb-3">Línea blanca</a>
                    <a className="text-[20px] text-black mb-3">Servicios básicos</a>
                    <a className="text-[20px] text-black mb-3">Internet alta velocidad</a>
                </nav> 
                <nav className="flex flex-col">
                    <h6 className="footer-title text-black text-[24px] font-bold mb-6">Amenidades</h6> 
                    <a className="text-[20px] text-black mb-3">Gimnasio</a>
                    <a className="text-[20px] text-black mb-3">Piscina</a>
                    <a className="text-[20px] text-black mb-3">Área de juegos infantiles</a>
                    <a className="text-[20px] text-black mb-3">Seguridad privada</a>
                </nav>
                <nav className="flex flex-col">
                    <h6 className="footer-title text-black text-[24px] font-bold mb-6">Exteriores</h6> 
                    <a className="text-[20px] text-black mb-3">Estacionamientos</a>
                    <a className="text-[20px] text-black mb-3">Áreas verdes</a>
                    <a className="text-[20px] text-black mb-3">Salón de usos múltiples</a>
                </nav>
            </div>
        </footer>
    </section>
  )
}

export default Property;