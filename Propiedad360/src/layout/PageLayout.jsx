import React from 'react'
import NavBar from '../components/NavBar/NavBar';
import Footer from '../components/Footer/Footer';

const PageLayout = ({ children }) => {
  return (
    <section>
        <NavBar />
        {children}
        <Footer />
    </section>
  )
}

export default PageLayout;