import React from 'react'
import ResultsTitle from './ResultsTitle/ResultsTitle';
import Mapa from './Map/Map'
import Button from './Button/Button';

const SearchProperties = () => {
  return (
    <section className="pb-16">
        <ResultsTitle />
        <Mapa />
        <Button />
    </section>
  )
}

export default SearchProperties;