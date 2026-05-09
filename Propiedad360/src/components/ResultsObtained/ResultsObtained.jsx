// src/components/ResultsObtained/ResultsObtained.jsx
import React, { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import ResultsTitle from '../SearchProperties/ResultsTitle/ResultsTitle';
import Map from './Map/Map';
import Button from './Button/Button';
import CardPropiedad from '../CardsPropiedad/CardsPropiedad';
import { buscarPorUbicacion, obtenerInmuebles } from '../../api/inmuebleApi';

const ResultsObtained = () => {
    const [inmuebles, setInmuebles] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');
    const [searchParams] = useSearchParams();
    const ubicacion = searchParams.get('ubicacion');

    useEffect(() => {
        const fetchInmuebles = async () => {
            try {
                setLoading(true);
                const response = ubicacion
                    ? await buscarPorUbicacion(ubicacion)
                    : await obtenerInmuebles();
                setInmuebles(response.data);
            } catch (err) {
                setError('Error al cargar los inmuebles.');
            } finally {
                setLoading(false);
            }
        };

        fetchInmuebles();
    }, [ubicacion]);

    return (
        <section className="pb-16">
            <ResultsTitle />
            <Map />
            {loading && <p className="text-center text-black mt-8">Cargando...</p>}
            {error && <p className="text-center text-red-500 mt-8">{error}</p>}
            {!loading && !error && inmuebles.length === 0 && (
                <p className="text-center text-black mt-8">No se encontraron propiedades en esa zona.</p>
            )}
            {!loading && !error && inmuebles.length > 0 && (
                <div className="grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-4 p-4">
                   {inmuebles.filter(i => i).map((inmueble) => (
                        <CardPropiedad key={inmueble.id} inmueble={inmueble} />
                    ))}
                </div>
            )}
            <Button />
        </section>
    );
};

export default ResultsObtained;