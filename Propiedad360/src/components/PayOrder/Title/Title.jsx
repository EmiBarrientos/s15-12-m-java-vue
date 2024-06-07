import React from 'react'

const Title = () => {
  return (
    <section>
      <div className="container mx-auto px-4 py-16 md:py-32">
        <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
        Pago de <span className="text-customColor2 font-bold">Alquiler</span>
        </h1>
        <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] mt-4">
          Orden de pago
        </p>
      </div>
    </section>
  )
}

export default Title