import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { MdEmail, MdLock } from 'react-icons/md';
import login from './assets/login.png';

const LoginSignup = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!email || !password) {
      setError('Por favor, complete ambos campos.');
      return;
    }

    setError('');
    window.location.href = '/home'; // Redirección simulada
  };

  return (
    <div className="bg-white pb-16"> 
      <div className="login-image w-full">
        <img className="w-full h-full" src={login} alt="login" />
      </div>
      <div className="container mx-auto px-4 py-16 md:py-32">
        <h1 className="text-black font-bold text-[32px] md:text-[48px] lg:text-[64px]">
          Iniciar <span className="text-customColor2 font-bold">Sesión</span>
        </h1>
        <p className="text-customColor3 font-normal text-[18px] md:text-[20px] lg:text-[24px] mt-4">
          Accede a tu cuenta
        </p>
      </div>
      <div className="flex justify-center items-center mb-14">
        <div className="card w-[1206px] h-[548px] shadow-2xl bg-base-100">
          <form className="card-body bg-slate-300 rounded-lg w-full h-full" onSubmit={handleSubmit}>
            <div className="form-control mt-16">
              <label className="flex items-center">
                <MdEmail className="mr-4" size={32} color="black" /> 
                <span className="label-text text-[32px] font-semibold text-black">Email</span>
              </label>
              <input
                type="email"
                placeholder="email"
                className="input input-bordered text-slate-700 bg-white mt-4"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <div className="form-control">
              <label className="flex items-center">
                <MdLock className="mr-4" size={32} color="black" /> 
                <span className="label-text text-[32px] font-semibold text-black">Password</span>
              </label>
              <input
                type="password"
                placeholder="password"
                className="input input-bordered text-slate-700 bg-white mt-4"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
              <label className="label">
                <a href="#" className="label-text-alt link link-hover text-[20px] text-black font-normal mt-4">Forgot password?</a>
              </label>
            </div>
            {error && <p className="text-red-500 mt-4">{error}</p>}
            <div className="form-control mt-9 flex justify-center items-center">
              <button type="submit" className="btn btn-wide text-white bg-buttonColor">Acceder</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default LoginSignup;