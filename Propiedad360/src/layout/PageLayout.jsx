import React from 'react'
import NavBar from '../components/NavBar/NavBar';
import Footer from '../components/Footer/Footer';
import { Outlet } from 'react-router-dom';

const PageLayout = ({ children }) => {
  return (
    <section>
        <NavBar />
         <Outlet />
        <Footer />
    </section>
  )
}

export default PageLayout;