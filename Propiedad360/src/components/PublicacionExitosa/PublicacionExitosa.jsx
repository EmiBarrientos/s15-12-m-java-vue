import { Link } from "react-router-dom";

const PublicacionExitosa = () => {
    return ( 
        <section className="bg-white">
            <div className="container mx-auto px-4 py-16 md:py-14">
                <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                Revisión de <span className="text-customColor2 font-bold">Publicación</span>
                </h1>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
                    Información, manejo de pagos, ajustes
                </p> 

                <div className="bg-[#EDE4D3] w-full mt-10">
                    <div className="ml-16 pt-12">
                        <p className="text-[32px] text-customColor font-bold ">
                            Configuración de Publicación
                        </p>
                    </div>

                    <p className="text-[24px] text-customColor font-bold mt-12 text-center">
                        Ximena Altamirano
                    </p>
                    <div className="flex justify-center">
                        <ul className="list-disc ">
                            <li className="text-[24px] text-customColor">
                            Cód. del anunciante: 3H78F5 | Cód. de la propiedad: 35698536
                            </li>
                        </ul>
                    </div>

                    <p className="text-[24px] text-customColor font-bold mt-12 text-center">
                       PUBLICACIÓN EXITOSA
                    </p>

                    <p className="text-[24px] text-customColor font-bold mt-3 text-center">
                       Recibirá en su correo registrado los detalles de su publicacón, por favor de revisarlo
                    </p>

                    <div className="flex justify-center">
                        <Link to="/ir-a-anuncio">
                        <button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] mt-24 mb-16">Ir a Anuncio</button>
                        </Link>
                    </div>
                </div>
            </div>
        </section>
    )
}

export default PublicacionExitosa;