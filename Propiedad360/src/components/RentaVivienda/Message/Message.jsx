import React from 'react';
import { Link } from 'react-router-dom';

const Message = () => {
  return (
    <section className="container mx-auto px-4 py-32 mt-[-100px]">
      <h1 className="text-black text-[24px] font-bold mb-6">Mensaje al anunciante opcional:</h1>
      <div>
        <textarea 
          placeholder="Mensaje..." 
          className="textarea textarea-bordered bg-white border-gray-300 text-black w-full h-[200px] resize-none mb-6" 
        />
      </div>
      <Link to="/agenda-una-visita" className="flex justify-center">
        <button className="btn btn-wide bg-gustomColor6 text-white cursor-pointer">Agendar</button>
      </Link>
    </section>
  );
}

export default Message;