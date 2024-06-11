import React from 'react'
import Title from './Title/Title';
import SuccessfulPayment from './SuccessfulPayment/SuccessfulPayment';

const PayOrder = () => {
  return (
    <section className="pb-16">
        <Title />
        <SuccessfulPayment />
    </section>
  )
}

export default PayOrder;