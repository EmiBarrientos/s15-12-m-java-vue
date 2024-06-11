import React from 'react';
import { Link } from "react-router-dom";
import { LuUsers } from "react-icons/lu";
import img1 from './assets/img1.png';
import img2 from './assets/img2.png';
import img3 from './assets/img3.png';
import img4 from './assets/img4.png';
import img5 from './assets/img5.png';
import img6 from './assets/img6.png';


const RevisionPublicacion = () => {
    return ( 
     <section className="bg-white">
        <div className="container mx-auto px-4 py-16 md:py-14">
            <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
               Revisión de <span className="text-customColor2 font-bold">Publicación</span>
            </h1>
            <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
                Información, manejo de pagos, ajustes
            </p> 
            <div className="flex flex-row ...">
                <div>
                    <p className="text-[32px] text-customColor font-bold mt-12">
                       Perfil
                    </p>
                    <div className="card w-[314px] h-[197px] shadow-xl bg-[#F2C44E]  text-customColor mt-4">
                        <div className="card-body items-center text-center">
                            <div><LuUsers  className="w-16 h-16" /></div>
                            <p className="text-[22px] ">
                                Propietario particular <br/> de inmueble
                            </p>
                        </div>
                    </div> 
                    <p className="text-[32px] text-customColor font-bold mt-12">
                       Tipo de inmueble
                    </p>
                    <p className="text-[32px] text-customColor ">
                      Departamento
                    </p>
                    <div className="flex flex-row mt-44">
                        <div>
                            <p className="text-[32px] text-customColor font-bold ">
                               Recámaras
                             </p>
                        </div>
                        <div className="ml-20"><input type="text" placeholder="2" className="input w-[56px] rounded-md  bg-white text-customColor text-center  border-customColor placeholder:text-customColor" /></div>
                    </div>
                    <p className="text-[32px] text-customColor font-bold mt-10" >
                        Superficie construida
                    </p>
                    <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-4">
                        <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor ">m2</button>
                        <input placeholder="75" className="w-[186px] h-[60px]  mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center place-content-center placeholder:text-customColor "></input> 
                    </div>
                </div>
                <div>
                    <div className="ml-32">
                        <p className="text-[32px] text-customColor font-bold mt-12">
                          Operación
                        </p>
                        <button className="btn  w-[314px] h-[120px] bg-[#F2C44E] text-[32px] text-customColor mt-4">RENTA</button>
                        <p className="text-[32px] text-customColor font-bold mt-32">
                          Ubicación
                        </p>
                        <p className="text-[32px] text-customColor w-[708px]">
                            Avenida, Santa Fe 2755 Piso 7° 1425, Cuidad
                            autónoma de Buenos Aires 
                            <p className="font-bold">(Se muestra aproximada en el mapa)</p>
                        </p>
                        <div className="flex flex-row mt-20">
                            <div>
                                <p className="text-[32px] text-customColor font-bold ">
                                   Baños
                                </p>
                            </div>
                            <div className="ml-20"><input type="text" placeholder="2" className="input w-[56px] rounded-md  bg-white text-customColor text-center  border-customColor placeholder:text-customColor" /></div>
                        </div>
                        <p className="text-[32px] text-customColor font-bold mt-9" >
                           Superficie Terreno 
                        </p>
                        <div className="flex justify-row bg-[#F9F9F9] w-[320px] h-[86px] rounded-[16px] border-[1px] border-customColor mt-4">
                            <button className="w-[66px] h-[58px] rounded-[16px] mt-3 ml-4 bg-[#D9D9D9] text-[24px] text-customColor ">m2</button>
                            <input placeholder="80" className="w-[186px] h-[60px]  mt-3 ml-4 bg-[#F9F9F9] text-[24px] text-customColor text-center place-content-center placeholder:text-customColor "></input> 
                        </div>

                    </div>
                </div>
            </div>
            <p className="text-[32px] text-customColor font-bold mt-12">
                Descripción de la propiedad
            </p>
            <div className="w-[1142px] h-[594px] bg-[#E0E0E0] mt-4">
              <div className=" ml-10">
                <br/>
                <p className="text-[32px] text-customColor font-bold ">
                    Título
                </p>
                <input type="text" placeholder="Departamento en venta"  className="input w-[1080px] h-[49px] mt-6 bg-white border border-customColor4 rounded-md text-customColor placeholder:text-customColor" />  
                <p className="text-[32px] text-customColor font-bold mt-10">
                    Descripción
                </p>
                <textarea className="textarea textarea-bordered textarea-md w-[1081px] h-[272px] bg-[#F9F9F9] placeholder:text-customColor" 
                placeholder="Venta de departamento amueblado de 75m², ideal para una vida cómoda y práctica. Cuenta con 2 recámaras, 1 baño completo y espacios bien distribuidos que aprovechan cada rincón. Aunque no tiene estacionamiento, su ubicación estratégica compensa con facilidad de acceso a transporte y servicios cercanos.¡Perfecto para quienes buscan comodidad y funcionalidad en su nuevo hogar!">
                </textarea>
              </div>
            </div>
            <p className="text-[32px] text-customColor font-bold mt-10">
                   Fotografías
            </p>
            <div className="flex flex-nowrap">
                <div className="w-[460px] h-[402px]">
                    <div className="flex flex-col ...">
                        <div className="mt-4"> <img src={img1}  /></div>
                        <div>
                            <div className="flex flex-row mt-5 h-[193px]">
                                <div className=""><img src={img2}  /></div>
                                <div className="ml-5"><img src={img3}  /></div>     
                            </div>
                        </div>     
                    </div>
                </div>
                <div className="ml-5 w-[268px] h-[402px] mt-4">
                   <img src={img4}  /> 
                </div>
                <div>
                    <div className="flex flex-col w-[364px] h-[402px] ml-5 mt-4">
                        <div className=""><img src={img5}  /></div>
                        <div className="mt-5"><img src={img6}  /></div>     
                    </div>
                   
                </div>
            </div>
            <div className="flex flex-row-reverse mt-24">
                <div>
                    <Link to="/publicacion-exitosa">
                       <button className="btn  bg-[#179149] text-white w-[208px] h-[62px] rounded-[16px] mr-28">Publicar</button>
                    </Link>
                </div>
                <div>
                    <Link to="/">
                       <button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] mr-10">Modificar</button>
                    </Link>
                </div>
            </div>
        </div>
     </section>
    )
  }
  
  export default RevisionPublicacion;