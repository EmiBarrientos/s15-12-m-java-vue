import React, { useEffect, useState } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';
import { useUser } from '../../../context/UserContext';
import { realizarPago } from '../../../api/clientApi';
import { obtenerPago } from '../../../api/pagoApi';
import maste from './assets/maste.png';

const Pay = () => {
    const { user } = useUser();
    const navigate = useNavigate();
    const [searchParams] = useSearchParams();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');

    const reservaId = searchParams.get('reservaId') || 1;
    const monto = searchParams.get('monto') || 5200;
    const metodoPago = 'MASTERCARD';

    const handlePagar = async () => {
        try {
            setLoading(true);
            setError('');
            const response = await realizarPago({
                clienteId: user.id,
                reservaId,
                monto,
                metodoPago
            });
            navigate(`/orden-de-pago?pagoId=${response.data.id}`);
        } catch (err) {
            setError('Error al procesar el pago.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <section className="bg-slate-200 mx-auto px-4 py-16 md:py-32 mb-12 flex flex-col items-center">
            <div className="w-full ml-[490px]">
                <h1 className="text-black text-[32px] font-bold text-left">Pago</h1>
            </div>
            <div className="w-full text-left mt-4 ml-[490px]">
                <p className="text-black text-[24px]">{user?.nombre} (Inquilino)</p>
                <p className="text-black text-[24px]">Reserva: #{reservaId}</p>
            </div>
            <div className="w-full flex justify-between items-start mt-4">
                <div className="flex flex-col ml-[240px]">
                    <h2 className="text-black text-[24px] font-semibold">Método de pago</h2>
                    <div className="flex items-center mt-2">
                        <img src={maste} alt="tarjeta" className="mr-2" />
                        <div>
                            <p className="text-black text-[20px]">Tarjeta de crédito</p>
                            <p className="text-black text-[20px]">Mastercard terminación **** 7894</p>
                        </div>
                    </div>
                </div>
                <div className="text-right mr-[800px]">
                    <h2 className="text-black text-[24px] font-semibold">Total a pagar: ${monto}</h2>
                </div>
            </div>
            {error && <p className="text-red-500 mt-4">{error}</p>}
            <div className="mt-8 flex space-x-12">
                <button
                    className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor text-white"
                    onClick={() => navigate('/pago-de-alquiler')}
                >
                    Modificar método de pago
                </button>
                <button
                    className="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg bg-buttonColor2 text-white"
                    onClick={handlePagar}
                    disabled={loading}
                >
                    {loading ? 'Procesando...' : 'Pagar'}
                </button>
            </div>
        </section>
    );
}

export default Pay;