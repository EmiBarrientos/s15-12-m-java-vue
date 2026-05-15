import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import RentYourNew from '../RentYourNew/RentYourNew';
import Mapa from '../CardsRentas/Mapa/Map';
import { obtenerInmuebles } from '../../api/inmuebleApi';

function CardsRentas() {
    const [inmuebles, setInmuebles] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        const fetchInmuebles = async () => {
            try {
                const response = await obtenerInmuebles();
                console.log('Inmuebles:', response.data);
                setInmuebles(response.data);
            } catch (err) {
              console.log('Error:', err);
                setError('Error al cargar los inmuebles.');
            } finally {
                setLoading(false);
            }
        };
        fetchInmuebles();
    }, []);

    return (
        <section className="container mx-auto px-4 py-8 md:py-16 lg:py-24">
            <RentYourNew />
            <div className="mt-8 md:mt-12">
                <Mapa />
            </div>
            <div className="mt-8">
                {loading && <p className="text-center text-black mt-8">Cargando...</p>}
                {error && <p className="text-center text-red-500 mt-8">{error}</p>}
                {!loading && !error && (
                    <>
                        <p className="text-[#191A18] text-[24px] mb-4 md:mb-6">
                            Hemos encontrado {inmuebles.length} propiedades disponibles
                        </p>
                        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 md:gap-12">
                            {inmuebles.filter(i => i).map((inmueble) => (
                                <div
                                    key={inmueble.id}
                                    className="card cursor-pointer"
                                    onClick={() => navigate(`/detalle-de-vivienda?id=${inmueble.id}`)}
                                >
                                    <figure className="px-6 pt-6 md:px-10 md:pt-10">
                                        <img
                                            src={inmueble.foto || 'https://placehold.co/400x300'}
                                            alt={inmueble.titulo}
                                            className="rounded-xl"
                                        />
                                    </figure>
                                    <div className="card-body items-center text-center bg-[#191A18] mt-5 border-2 border-[#C3922E] rounded-tr-lg p-4 md:p-6 lg:p-8">
                                        <p className="text-[#C3922E] mb-2 md:mb-4">
                                            {inmueble.tipoInmueble} <br /> {inmueble.numeroRecamaras} habitaciones
                                        </p>
                                        <p className="mb-2 md:mb-4">Zona: {inmueble.ubicacion}</p>
                                        <p className="mb-2 md:mb-4">${inmueble.precio} mensuales</p>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </>
                )}
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