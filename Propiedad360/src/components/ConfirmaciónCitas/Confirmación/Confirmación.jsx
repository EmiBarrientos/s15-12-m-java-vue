import React from 'react';
import { Link, useSearchParams } from 'react-router-dom';
import { useUser } from '../../../context/UserContext';

const Confirmación = () => {
    const { user } = useUser();
    const [searchParams] = useSearchParams();
    const fecha = searchParams.get('fecha');
    const inmuebleId = searchParams.get('inmuebleId');

    return (
        <section className="bg-ConfiFondo mx-auto px-4 py-16 md:py-32 mb-12 flex flex-col items-center justify-center">
            <div className="text-left">
                <h1 className="text-black text-[24px] md:text-[32px] font-bold ml-7">Confirmación de visita</h1>
                <p className="text-black text-[20px] md:text-[24px] font-normal text-center">{user?.nombre}</p>
                <p className="text-black text-[20px] md:text-[24px] font-normal ml-4">
                    Cód. de la propiedad: {inmuebleId}
                </p>
                {fecha && (
                    <p className="text-black text-[20px] md:text-[24px] font-normal ml-4">
                        Fecha agendada: {fecha}
                    </p>
                )}
            </div>
            <div className="mt-12">
                <h2 className="text-black text-[26px] md:text-[30px] font-semibold text-center">CONFIRMACIÓN EXITOSA</h2>
                <span className="text-black text-[20px] md:text-[24px] font-semibold text-center">
                    Recibirá en su correo registrado los detalles de su visita, favor de revisarlos
                </span>
            </div>
            <div className="mt-12 text-center">
                <Link to="/home">
                    <button className="btn btn-wide bg-buttonColor text-white">Volver a inicio</button>
                </Link>
            </div>
        </section>
    );
}

export default Confirmación;