import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import logo from '../NavBar/assets/logo.png';
import texto from '../NavBar/assets/texto.png';
import perfil1 from '../NavBar/assets/perfil1.png';
import { AiOutlineMenu, AiOutlineClose } from "react-icons/ai";

const NavBar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };

  return (
    <section>
      <div className="navbar bg-customColor flex justify-between items-center px-4">
        <Link to="/home" className="navbar-start flex items-center cursor-pointer">
          <img src={logo} alt="logo" className="h-6 w-auto" />
          <img src={texto} alt="texto" className="h-6 w-auto ml-2" />
        </Link>
        <div className="navbar-center text-white hidden lg:flex space-x-4">
          <Link to="/comprar" className="btn btn-ghost text-xl">Compra</Link>
          <Link to="/renta" className="btn btn-ghost text-xl">Renta</Link>
          <Link to="/agenda-una-visita" className="btn btn-ghost text-xl">Agenda una visita</Link>
          <Link to="/publíca-tu-propiedad" className="btn btn-ghost text-xl">Publíca tu propiedad</Link>
        </div>
        <div className="navbar-end flex items-center">
          <button className="btn btn-ghost btn-circle lg:hidden" onClick={toggleMenu}>
            {isOpen ? <AiOutlineClose className="w-6 h-6 text-white" /> : <AiOutlineMenu className="w-6 h-6 text-white" />}
          </button>
          <div className="hidden lg:flex items-center">
            <span className="text-white mr-2">Hola Javier</span>
            <div className="indicator">
              <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5 text-white" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
              </svg>
              <span className="badge badge-xs badge-primary indicator-item"></span>
            </div>
          </div>
          <Link to="/configuración-de-perfil" className="btn btn-ghost btn-circle">
            <img src={perfil1} alt="Perfil" className="w-6 h-6 rounded-full" />
          </Link>
        </div>
      </div>

      {isOpen && (
        <div className="lg:hidden">
          <div className="flex flex-col items-start space-y-2 p-4 text-white font-roboto">
            <Link to="/comprar" className="btn btn-ghost text-xl" onClick={toggleMenu}>Compra</Link>
            <Link to="/renta" className="btn btn-ghost text-xl" onClick={toggleMenu}>Renta</Link>
            <Link to="/agenda-una-visita" className="btn btn-ghost text-xl" onClick={toggleMenu}>Agenda una visita</Link>
            <Link to="/publíca-tu-propiedad" className="btn btn-ghost text-xl" onClick={toggleMenu}>Publíca tu propiedad</Link>
          </div>
        </div>
      )}
    </section>
  );
};

export default NavBar;