import React from 'react';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import PageLayout from '../layout/PageLayout';
import Home from '../pages/Home/Home';
import Comprar from '../pages/Comprar/Comprar';
import Renta from '../pages/Renta/Renta';
import AgendaUnaVisita from '../pages/AgendaUnaVisita/AgendaUnaVisita';
import PublícaTuPropiedad from '../pages/PublícaTuPropiedad/PublícaTuPropiedad';
import DetalleVivienda from '../pages/DetalleVivienda/DetalleVivienda';
import ConfirmaCita from '../pages/ConfirmaCita/ConfirmaCita';


const routes = createBrowserRouter([
    {
        path: "/",
        element: <PageLayout> <Home /> </PageLayout>
    },
    {
        path: "/comprar",
        element: <PageLayout> <Comprar /> </PageLayout> 
    },
    {
        path: "/renta",
        element: <PageLayout> <Renta /> </PageLayout> 
    },
    {
        path: "/detalle-de-vivienda",
        element: <PageLayout> <DetalleVivienda /> </PageLayout> 
    },
    {
        path: "/agenda-una-visita",
        element: <PageLayout> <AgendaUnaVisita /> </PageLayout>  
    },
    {
        path: "/confirmar-cita",
        element: <PageLayout> <ConfirmaCita /> </PageLayout>  
    },
    {
        path: "/publíca-tu-propiedad",
        element: <PageLayout> <PublícaTuPropiedad /> </PageLayout>  
    }
    
]);

const Navigation = () => {
    return <RouterProvider router={routes} />;
  };
  
export default Navigation;