import img1 from '../CardsPropiedad/assets/img1.png';
import img2 from '../CardsPropiedad/assets/img2.png';
import img3 from '../CardsPropiedad/assets/img3.png';
import img4 from '../CardsPropiedad/assets/img4.png';

function CardsPropiedad() {
  return (
    <div className="grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-4 p-4">
      <div className="card w-full shadow-xl mt-4">
        <div className="mt-4 items-center text-center">
          <figure><img src={img1} alt="Propiedad 1" /></figure>
          <div className="card-body bg-[#191A18] mt-5 rounded-tr-lg text-[20px] h-[140px] border-2 border-[#C3922E]">
            <p className="text-[#C3922E]">Propiedad 1</p>
            <p>Zona: Este</p>
            <p>$4000 mensuales</p>
          </div>
        </div>
      </div>
      <div className="card w-full shadow-xl mt-4">
        <div className="mt-4 items-center text-center">
          <figure><img src={img2} alt="Propiedad 2" /></figure>
          <div className="card-body bg-[#191A18] mt-5 rounded-tr-lg text-[20px] h-[140px] border-2 border-[#C3922E]">
            <p className="text-[#C3922E]">Propiedad 2</p>
            <p>Zona: Este</p>
            <p>$4500 mensuales</p>
          </div>
        </div>
      </div>
      <div className="card w-full shadow-xl mt-4">
        <div className="mt-4 items-center text-center">
          <figure><img src={img3} alt="Propiedad 3" /></figure>
          <div className="card-body bg-[#191A18] mt-5 rounded-tr-lg text-[20px] h-[140px] border-2 border-[#C3922E]">
            <p className="text-[#C3922E]">Propiedad 3</p>
            <p>Zona: Este</p>
            <p>$4300 mensuales</p>
          </div>
        </div>
      </div>
      <div className="card w-full shadow-xl mt-4">
        <div className="mt-4 items-center text-center">
          <figure><img src={img4} alt="Propiedad 4" /></figure>
          <div className="card-body bg-[#191A18] mt-5 rounded-tr-lg text-[20px] h-[140px] border-2 border-[#C3922E]">
            <p className="text-[#C3922E]">Propiedad 4</p>
            <p>Zona: Este</p>
            <p>$4200 mensuales</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CardsPropiedad;