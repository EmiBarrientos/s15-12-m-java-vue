import React, { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import RentYourNew from '../RentYourNew/RentYourNew';
import SelectedCards from './SelectedCards/SelectedCards';
import Descripción from './Descripción/Descripción';
import Map from './Map/Map';
import Property from './Property/Property';
import Diary from './Diary/Diary';
import SelectAnAvailable from './SelectAnAvailable/SelectAnAvailable';
import Message from './Message/Message';
import { obtenerInmueble } from '../../api/inmuebleApi';

const RentaVivienda = () => {
    const [inmueble, setInmueble] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');
    const [searchParams] = useSearchParams();
    const id = searchParams.get('id');

    useEffect(() => {
        const fetchInmueble = async () => {
            try {
                setLoading(true);
                const response = await obtenerInmueble(id);
                setInmueble(response.data);
            } catch (err) {
                setError('Error al cargar el inmueble.');
            } finally {
                setLoading(false);
            }
        };

        if (id) fetchInmueble();
    }, [id]);

    if (loading) return <p className="text-center text-black mt-8">Cargando...</p>;
    if (error) return <p className="text-center text-red-500 mt-8">{error}</p>;
    if (!inmueble) return <p className="text-center text-black mt-8">Inmueble no encontrado.</p>;

    return (
        <section className="w-full">
            <div className="container mx-auto px-4 py-32">
                <RentYourNew />
                <div className="mt-24">
                    <p className="text-black text-[24px]">Propiedad seleccionada:</p>
                </div>
            </div>
            <SelectedCards foto={inmueble.foto} />
            <Descripción inmueble={inmueble} />
            <Map />
            <Property inmueble={inmueble} />
            <Diary inmuebleId={id} />
            <SelectAnAvailable />
            <Message inmuebleId={id} />
        </section>
    );
}

export default RentaVivienda;