import React, { useState } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';
import { useUser } from '../../../context/UserContext';
import { crearVisita } from '../../../api/visitaApi';

const Message = ({ inmuebleId }) => {
    const [mensaje, setMensaje] = useState('');
    const [loading, setLoading] = useState(false);
    const [searchParams] = useSearchParams();
    const { user } = useUser();
    const navigate = useNavigate();
    const fecha = searchParams.get('fecha');

    const handleAgendar = async () => {
        try {
            setLoading(true);
            console.log('cliente id:', user.id);
            console.log('inmueble id:', inmuebleId);
            console.log('fecha:', fecha);
            await crearVisita({
                cliente: { id: user.id },
                inmueble: { id: inmuebleId },
                fechaVisita: fecha
            });
             
            navigate(`/agenda-una-visita?inmuebleId=${inmuebleId}&fecha=${fecha}`);
        } catch (err) {
            console.error('Error al agendar visita:', err);
        } finally {
            setLoading(false);
        }
    };

    return (
        <section className="container mx-auto px-4 py-32 mt-[-100px]">
            <h1 className="text-black text-[24px] font-bold mb-6">Mensaje al anunciante opcional:</h1>
            <div>
                <textarea
                    placeholder="Mensaje..."
                    className="textarea textarea-bordered bg-white border-gray-300 text-black w-full h-[200px] resize-none mb-6"
                    value={mensaje}
                    onChange={(e) => setMensaje(e.target.value)}
                />
            </div>
            <div className="flex justify-center">
                <button
                    className="btn btn-wide bg-gustomColor6 text-white cursor-pointer"
                    onClick={handleAgendar}
                    disabled={loading}
                >
                    {loading ? 'Agendando...' : 'Agendar'}
                </button>
            </div>
        </section>
    );
}

export default Message;