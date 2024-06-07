import { LuShare } from "react-icons/lu";
import { Link } from "react-router-dom";
const CaracteristicasPropiedadVista = () => {
    return (
      
        <section className="bg-white">
            <div className="container mx-auto px-4 py-16 md:py-14">
                <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
                    Publicación de <span className="text-customColor2 font-bold">Propiedad</span>
                </h1>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
                    Gratis y en simples pasos
                </p>

                <p className="text-[32px] text-customColor font-bold mt-12">
                  Fotografías
                </p>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
                    Carga entre 5 y 30 fotografías. Se admiten formatos .jpg .peg .png desde 500 x 500px hasta 6000 x 6000px
                </p> 

                <div className="flex  ">
                    <div> 
                        <div className="flex justify-center w-[782px] h-[444px] bg-[#E0E0E0] mt-7 border-dashed border-[3px] border-[#DE7E1F]">
                            <div className="flex flex-col justify-center">
                                <div className="flex justify-center"><button><LuShare className="w-[40px] h-[50px]" style={{color:'#DE7E1F'}}/></button></div>
                                <div><p className="">Agrega o arrastra las fotografías de la propiedad</p></div>    
                            </div>
                        
                        </div>
                        
                    </div>          
                   <div className="flex flex-col-reverse ml-20">
                       <button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] ">Subir imágenes</button>
                   </div> 
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">
                  Videos (opcional)
                </p>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
                    Carga un video de YouTube mostando tu propiedad
                </p>
                <div className="flex flex-row mt-8">
                    <div className="w-[790px]"><input type="text" placeholder="Agrega la URL del video" className="input  w-[790px] h-[56px] border-customColor bg-white text-customColor rounded-md " /></div>
                    <div className="ml-16 "><button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] ">Añadir enlace</button></div>
                </div>

                <p className="text-[32px] text-customColor font-bold mt-12">
                  Planos
                </p>
                <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
                   Carga los planos de la propiedad. Se admite formatos .jpg .jpeg .png desde 500 x 500px hasta 6000 x 6000px
                </p>

                <div className="flex  ">
                    <div> 
                        <div className="flex justify-center w-[782px] h-[444px] bg-[#E0E0E0] mt-7 border-dashed border-[3px] border-[#DE7E1F]">
                            <div className="flex flex-col justify-center">
                                <div className="flex justify-center"><button><LuShare className="w-[40px] h-[50px]" style={{color:'#DE7E1F'}}/></button></div>
                                <div><p className="">Agrega o arrastra las planos de la propiedad</p></div>    
                            </div>
                        
                        </div>
                        
                    </div>          
                   <div className="flex flex-col-reverse ml-20">
                       <button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] ">Subir planos</button>
                   </div> 
                </div>

                <div className="flex justify-center my-16">
                    <Link to="/revision-publicacion">
                       <button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] ">Continuar</button>
                    </Link>
                </div> 

                

            </div>

        </section>

     )
}

export default CaracteristicasPropiedadVista;