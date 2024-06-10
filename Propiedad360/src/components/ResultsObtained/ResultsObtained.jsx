import React from 'react'
import ResultsTitle from '../SearchProperties/ResultsTitle/ResultsTitle';
import Map from './Map/Map';
import Button from './Button/Button';

const ResultsObtained = () => {
  return (
    <section className="pb-16">
        <ResultsTitle />
        <Map />
        <Button />
    </section>
  )
}

export default ResultsObtained;