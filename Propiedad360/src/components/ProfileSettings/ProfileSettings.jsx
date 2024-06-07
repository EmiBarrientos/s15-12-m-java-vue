import React from 'react'
import Ajuste from './Ajustes/Ajuste';
import PaymentSettings from './PaymentSettings/PaymentSettings';

const ProfileSettings = () => {
  return (
    <section  className="container mx-auto px-4 py-8 md:py-16 lg:py-24">
        <h1 className="text-black font-bold text-4xl md:text-5xl lg:text-6xl">Configuración de <span className="text-customColor2 font-bold">Perfil</span></h1>
        <p className="text-customColor3 font-normal text-lg md:text-xl lg:text-2xl mt-4 md:mt-6 lg:mt-8">Infirmación, manejo de pagos, ajustes</p>
        <Ajuste />
        <PaymentSettings />
    </section>
  )
}

export default ProfileSettings;