import React from 'react'
import SelectedArea from '../SelectedArea/SelectedArea';
import Agenda from './Agenda/Agenda';

const AgendaVisita = () => {
  return (
    <section className="w-full bg-white">
        <SelectedArea/>
        <Agenda />
    </section>
  )
}

export default AgendaVisita;