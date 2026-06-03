import React from 'react';
import { createBrowserRouter, RouterProvider,Navigate  } from 'react-router-dom';
import PageLayout from '../layout/PageLayout';
import Login from '../pages/Login/Login';
import Home from '../pages/Home/Home';
import BuscarPropiedades from '../pages/BuscarPropiedades/BuscarPropiedades';
import ResultadosObtenidos from '../pages/ResultadosObtenidos/ResultadosObtenidos';
import Comprar from '../pages/Comprar/Comprar';
import Renta from '../pages/Renta/Renta';
import AgendaUnaVisita from '../pages/AgendaUnaVisita/AgendaUnaVisita';
import PublicaTuPropiedad from '../pages/PublicaTuPropiedad/PublicaTuPropiedad';
import DetalleVivienda from '../pages/DetalleVivienda/DetalleVivienda';
import ConfirmaCita from '../pages/ConfirmaCita/ConfirmaCita';
import CaracteristicasPropiedad from '../components/CaracteristicasPropiedad/CaracteristicasPropiedad';
import ConfiguraciónPerfil from '../pages/ConfiguraciónPerfil/ConfiguraciónPerfil';
import PagoAlquiler from '../pages/PagoAlquiler/PagoAlquiler';
import RevisaTuPago from '../pages/RevisaTuPago/RevisaTuPago';
import OrdenDePago from '../pages/OrdenDePago/OrdenDePago';
import CaracteristicasPropiedadVista from '../components/CaracteristicasPropiedadVista/CaracteristicasPropiedadVista';
import RevisionPublicacion from '../components/RevisionPublicacion/RevisionPublicacion';
import PublicacionExitosa from '../components/PublicacionExitosa/PublicacionExitosa';
import RevisionAnuncio from '../components/RevisionAnuncio/RevisionAnuncio';
import Register from '../components/Register/Register';


export const createRoutes = (user) => createBrowserRouter([
  // --- RUTAS PÚBLICAS ---
  {
    path: "/",
    element: user ? <Navigate to="/home" replace /> : <Login />
  },
  {
    path: "/registro",
    element: user ? <Navigate to="/home" replace /> : <Register />
  },

  // --- RUTAS PROTEGIDAS ---
  {
    path: '/',
    element: user ? <PageLayout /> : <Navigate to="/" replace />,
    children: [
      { path: "home", element: <Home /> },
      { path: "buscar-propiedades-en-zona", element: <BuscarPropiedades /> },
      { path: "resultados-obtenidos", element: <ResultadosObtenidos /> },
      { path: "comprar", element: <Comprar /> },
      { path: "renta", element: <Renta /> },
      { path: "detalle-de-vivienda", element: <DetalleVivienda /> },
      { path: "agenda-una-visita", element: <AgendaUnaVisita /> },
      { path: "confirmar-cita", element: <ConfirmaCita /> },
      { path: "publica-tu-propiedad", element: <PublicaTuPropiedad /> },
      { path: "caracteristicas-de-propiedad", element: <CaracteristicasPropiedad /> },
      { path: "caracteristicas-de-propiedad-vista", element: <CaracteristicasPropiedadVista /> },
      { path: "configuración-de-perfil", element: <ConfiguraciónPerfil /> },
      { path: "pago-de-alquiler", element: <PagoAlquiler /> },
      { path: "revisa-tu-pago", element: <RevisaTuPago /> },
      { path: "orden-de-pago", element: <OrdenDePago /> },
      { path: "revision-publicacion", element: <RevisionPublicacion /> },
      { path: "publicacion-exitosa", element: <PublicacionExitosa /> },
      { path: "ir-a-anuncio", element: <RevisionAnuncio /> },
    ]
  }
]);
