import React, { useEffect, useState } from 'react';
import { Link, useSearchParams } from 'react-router-dom';
import { useUser } from '../../../context/UserContext';
import { obtenerPago } from '../../../api/pagoApi';
import maste from './assets/maste.png';

const SuccessfulPayment = () => {
    const { user } = useUser();
    const [searchParams] = useSearchParams();
    const [pago, setPago] = useState(null);
    const [loading, setLoading] = useState(true);
    const pagoId = searchParams.get('pagoId');

    useEffect(() => {
        const fetchPago = async () => {
            try {
                if (pagoId) {
                    const response = await obtenerPago(pagoId);
                    setPago(response.data);
                }
            } catch (err) {
                console.error('Error al obtener el pago:', err);
            } finally {
                setLoading(false);
            }
        };
        fetchPago();
    }, [pagoId]);

    if (loading) return <p className="text-center text-black mt-8">Cargando...</p>;

    return (
        <section className="bg-ConfiFondo mx-auto px-4 py-16 md:py-32 mb-12 flex flex-col items-center justify-center">
            <h1 className="text-black text-[24px] md:text-[32px] font-bold">PAGO EXITOSO</h1>
            <div className="text-center">
                <p className="text-black text-[20px] md:text-[24px] font-extrabold text-center mt-9">
                    Se registró el pago con los siguientes datos
                </p>
            </div>
            <div className="mt-12">
                <p className="text-black text-[24px] md:text-[30px] font-normal text-center">
                    {user?.nombre} (Inquilino)
                </p>
            </div>
            <div className="flex items-center justify-between w-full max-w-2xl mt-8">
                <div className="flex items-center">
                    <img src={maste} alt="tarjeta" className="mr-4" />
                    <div>
                        <p className="text-black text-[20px]">{pago?.metodoPago}</p>
                    </div>
                </div>
                <div className="text-right">
                    <h2 className="text-black text-[24px] font-semibold">
                        Monto: ${pago?.monto}
                    </h2>
                </div>
            </div>
            <p className="text-black text-[24px] font-medium mt-8">
                Se envió un correo con la confirmación y detalles del pago, favor de revisarlo
            </p>
            <div className="mt-12 text-center">
                <Link to="/home">
                    <button className="btn btn-wide bg-buttonColor text-white border-none">
                        Volver a inicio
                    </button>
                </Link>
            </div>
        </section>
    );
}

export default SuccessfulPayment;