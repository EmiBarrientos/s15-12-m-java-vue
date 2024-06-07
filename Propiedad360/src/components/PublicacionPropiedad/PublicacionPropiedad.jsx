import { LuUsers } from "react-icons/lu";
import { CiHome } from "react-icons/ci";
import { PiCodepenLogoThin } from "react-icons/pi";
import { Link } from "react-router-dom";


const PublicacionPropiedad = () => {
  return (
    <section >
      <div className="container mx-auto px-4 py-16 md:py-14">
        <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
          Publicación de <span className="text-customColor2 font-bold">Propiedad</span>
        </h1>
        <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] ">
          Gratis y en simples pasos
        </p>

        <p className="text-[32px] text-customColor font-bold mt-12">
             Selecciona el perfil que más se ajuste a tus necesidades
        </p>

        <div className="grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-x-96 pt-7">
                <div className="card w-[314px] h-[197px] shadow-xl bg-[#F2C44E]  text-customColor">
                    <div className="card-body items-center text-center">
                        <div><LuUsers  className="w-16 h-16" /></div>
                        <p className="text-[22px] ">
                            Propietario particular <br/> de inmueble
                        </p>
                    </div>
                </div> 

                <div className="card w-[314px] h-[197px] shadow-xl bg-[#E0E0E0]  text-customColor">
                    <div className="card-body items-center text-center">
                        <div><CiHome className="w-16 h-16" /></div>
                        <p className="text-[22px] ">
                           Agente inmobiliario <br/> Inmobiliaria
                        </p>
                    </div>
                </div> 

                <div className="card w-[314px] h-[197px] shadow-xl bg-[#E0E0E0]  text-customColor">
                    <div className="card-body items-center text-center">
                        <div><PiCodepenLogoThin  className="w-16 h-16" /></div>
                        <p className="text-[22px] ">
                            Constructora <br/> Desarrolladora
                        </p>
                    </div>
                </div> 

               
        </div>

        <p className="text-[32px] text-customColor font-bold mt-12">
            Tipo de operación a realizar 
        </p>
              
        <button className="btn  w-[314px] h-[120px] bg-[#E0E0E0] text-[32px] text-customColor mt-4">VENTA</button>
        <button className="btn ml-24 w-[314px] h-[120px] bg-[#F2C44E] text-[32px] text-customColor mt-4">RENTA</button>
        
        <p className="text-[32px] text-customColor font-bold mt-12">
            Tipo de inmueble 
        </p>
          
        <div className="bg-[#E0E0E0] w-[1142px] h-[776px] rounded-lg mt-6">
            <select className="select select-bordered bg-white text-black w-[1059px] mt-9 mx-8 ">
              <option className="text-black text-lg md:text-xl lg:text-2xl " disabled selected>Selecciona una opción</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Casa</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Departamento</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Edificio</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Oficina</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Rancho</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Quinta</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Terreno</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Lote</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Villa</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Dúplex</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Huerta</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Nave comercial</option>
              <option className="text-black text-lg md:text-xl lg:text-2xl">Bodega</option>
            </select>  
        </div> 

        <p className="text-[32px] text-customColor font-bold mt-12">
            Ubicación
        </p>

        <div className="bg-[#E0E0E0] w-[1142px] h-[236px] rounded-lg mt-6">
            <br/>
            <div className="flex justify-start  ml-7">
              <CiHome className="w-10 h-10 text-customColor"/>
               <span className="text-[#191A18] text-[32px] font-bold"> Ingresar la dirección completa</span>
            </div>
            
            <div className="w-full ml-7 mt-4">
               <input type="text" placeholder="Ingresa dirección"  className="input w-[1080px] h-[49px] bg-white border border-customColor4 rounded-md text-customColor" />  
            </div>             
        </div>

        <p className="text-[32px] text-customColor font-bold mt-12">
            Ubicación
        </p>

        <div className="form-control">
          <label className="label cursor-pointer w-10">       
            <input type="checkbox" className="checkbox border-customColor checked:border-blue-700 [--chkbg:theme(colors.blue.700)] [--chkfg:white]" />
            <span className="label-text ml-3 text-customColor">Exacta</span> 

            <input type="checkbox" defaultChecked className="checkbox ml-20 border-customColor checked:border-blue-700 [--chkbg:theme(colors.blue.700)] [--chkfg:white]" />
            <span className="label-text ml-3 text-customColor">Aproximada</span> 
          </label>
        </div>

        <div className="flex justify-end">
            <Link to="/caracteristicas-de-propiedad">
                 <button className="btn  bg-[#DE7E1F] text-white w-[208px] h-[62px] rounded-[16px] ">Continuar</button>
            </Link>  
        </div>

     </div>
    </section>
  )
}

export default PublicacionPropiedad;